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

import java.time.LocalDate;
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
        LocalDate startDate = LocalDate.of(2020,1,3);
        LocalDate endDate = LocalDate.now();

        LocalDate[]myval = {startDate,endDate};

        searchCriteria.add(new SearchCriteria("switchDate", SearchOperation.DataRange,myval));
        Specification<PayTransaction> result = new SpecificationsBuilder<PayTransaction>(searchCriteria).build();

        Pageable pageable = PageRequest.of(0, 20);
        return transactionRepo.findAll(result, pageable);
    }

    @GetMapping(value = "search")
    public Optional<PayTransaction> Search() {
       LocalDate localDate = LocalDate.now();
        return   simpleRepo.findByswitchDate(localDate);
    }



}
