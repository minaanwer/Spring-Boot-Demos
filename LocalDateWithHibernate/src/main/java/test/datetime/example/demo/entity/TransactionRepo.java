package test.datetime.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("TransactionRepo")
public interface TransactionRepo extends JpaRepository<PayTransaction, Long>, JpaSpecificationExecutor<PayTransaction> {
}
