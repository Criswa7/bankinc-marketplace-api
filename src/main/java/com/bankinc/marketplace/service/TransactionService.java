package com.bankinc.marketplace.service;

import com.bankinc.marketplace.model.Card;
import com.bankinc.marketplace.model.Transaction;
import com.bankinc.marketplace.model.TransactionStatus;
import com.bankinc.marketplace.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardService cardService;

    @Transactional
    public Transaction createTransaction(String cardNumber, Double amount) {
        Card card = cardService.getCard(cardNumber);
        
        if (card.getBalance() < amount) {
            return Transaction.builder()
                    .card(card)
                    .amount(amount)
                    .transactionDate(LocalDateTime.now())
                    .status(TransactionStatus.RECHAZADA)
                    .build();
        }

        card.setBalance(card.getBalance() - amount);
        
        Transaction transaction = Transaction.builder()
                .card(card)
                .amount(amount)
                .transactionDate(LocalDateTime.now())
                .status(TransactionStatus.EXITOSA)
                .build();
        
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction cancelTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (transaction.getTransactionDate().plusHours(24).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Transaction cannot be cancelled after 24 hours");
        }

        if (transaction.getStatus() != TransactionStatus.EXITOSA) {
            throw new RuntimeException("Only successful transactions can be cancelled");
        }

        Card card = transaction.getCard();
        card.setBalance(card.getBalance() + transaction.getAmount());
        
        transaction.setStatus(TransactionStatus.ANULADA);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByCard(String cardNumber) {
        Card card = cardService.getCard(cardNumber);
        return transactionRepository.findByCard(card);
    }
}