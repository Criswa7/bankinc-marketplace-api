package com.bankinc.marketplace.repository;

import com.bankinc.marketplace.model.Transaction;
import com.bankinc.marketplace.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCard(Card card);
    List<Transaction> findByTransactionDateAfter(LocalDateTime date);
}