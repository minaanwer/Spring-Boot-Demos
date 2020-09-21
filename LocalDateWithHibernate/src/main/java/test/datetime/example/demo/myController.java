package test.datetime.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.datetime.example.demo.entity.PayTransaction;
import test.datetime.example.demo.entity.TransactionRepo;
import test.datetime.example.demo.entity.crudRepo;
import test.datetime.example.demo.entity.SearchCriteria;
import test.datetime.example.demo.entity.SearchOperation;
import test.datetime.example.demo.entity.SpecificationsBuilder;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class myController {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    crudRepo simpleRepo;

    @GetMapping("test")
    public String test() {
        return "I'm ok";
    }


    @GetMapping(value = "simpleSearch")
    public Page<PayTransaction> SearchBydate() {

        List<SearchCriteria> searchCriteria = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        searchCriteria.add(new SearchCriteria("txnTimeStamp", SearchOperation.GreaterThanOrEqual, today));

        Specification<PayTransaction> result = new SpecificationsBuilder<PayTransaction>(searchCriteria).build();
        Pageable pageable = PageRequest.of(0, 2);

        return transactionRepo.findAll(result, pageable);
    }

    @GetMapping(value = "search")
    public Optional<PayTransaction> Search() {

       // List<SearchCriteria> searchCriteria = new ArrayList<>();
      //  LocalDate today = LocalDate.now();

        Date date = new Date(2012,12,1);
        return   simpleRepo.findByswitchDate(date);

    }



}
