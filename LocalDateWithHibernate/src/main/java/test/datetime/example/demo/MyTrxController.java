package test.datetime.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.datetime.example.demo.entity.*;
import test.datetime.example.demo.helpers.SearchCriteria;
import test.datetime.example.demo.helpers.SearchOperation;
import test.datetime.example.demo.helpers.SpecificationsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import test.datetime.example.demo.entity.reportRepo;

@RestController
public class MyTrxController {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    crudRepo simpleRepo;

    @Autowired
    private ArticleRepository repository;


    // @Autowired
    // private reportRepo myReportRepo;


    @GetMapping("checkstatus")
    public String CheckStatus() {
        return "I'm ok";
    }

    @GetMapping(value = "simpleSearch")
    public Page<PayTransaction> SearchTransactionBydate() {

        List<SearchCriteria> searchCriteria = new ArrayList<>();
        LocalDate startDate = LocalDate.of(2020, 1, 3);
        LocalDate endDate = LocalDate.now();

        LocalDate[] myval = {startDate, endDate};

        searchCriteria.add(new SearchCriteria("switchDate", SearchOperation.DataRange, myval));
        Specification<PayTransaction> result = new SpecificationsBuilder<PayTransaction>(searchCriteria).build();

        Pageable pageable = PageRequest.of(0, 20);
        return transactionRepo.findAll(result, pageable);
    }

    @GetMapping(value = "search")
    public Optional<PayTransaction> SearchTransactionBySwitchDate() {
        LocalDate localDate = LocalDate.now();
        return simpleRepo.findByswitchDate(localDate);
    }

    @GetMapping(value = "")
    public List<PayTransaction> SearchTransactionByDateTime() {

        ArrayList<SearchCriteria> searchCriteria = new ArrayList<SearchCriteria>();
        // searchCriteria.add(new SearchCriteria("txnTimeStamp", "txnTimeStamp", LocalDateTime.now(),LocalDateTime.now()));


        Specification<PayTransaction> searchSpecification = new SpecificationsBuilder<PayTransaction>(searchCriteria).build();

        //  return myReportRepo.findAll(searchSpecification);
        return null;
    }


    @GetMapping(value = "/artical")
    public List<Article> getArticalsByDateTime() throws ParseException {
        List<Article> result = repository.findAllWithCreationDateTimeBefore(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-10-26 15:07"));
        return result;
    }

    @GetMapping(value = "artical/searchDateTime")
    public List<Article> SearchArticalsByDateTime() throws ParseException {
        ArrayList<SearchCriteria> searchCriteria = new ArrayList<SearchCriteria>();

        //searchCriteria.add(new SearchCriteria("creationDateTime",SearchOperation.LessThanOrEqual, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-10-26 15:07")));

        searchCriteria.add(new SearchCriteria("creationDateTime", "creationDateTime",
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-10-25 15:07"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-10-26 15:07")));

        Specification<Article> searchSpecification = new SpecificationsBuilder<Article>(searchCriteria).build();

        return repository.findAll(searchSpecification);
    }



}
