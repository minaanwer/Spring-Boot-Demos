package test.datetime.example.demo.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface crudRepo extends CrudRepository<PayTransaction,Long> {

    Optional<PayTransaction> findByswitchDate(LocalDate date);

}
