package com.ssd.transactionservice.repo;

import com.ssd.transactionservice.POJO.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Orders,Long> {
}
