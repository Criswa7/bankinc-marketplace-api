package com.bankinc.marketplace.controller;

import com.bankinc.marketplace.dto.TransactionDTO;
import com.bankinc.marketplace.model.Transaction;
import com.bankinc.marketplace.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(transactionService.createTransaction(dto.getCardNumber(), 
                                                                    dto.getAmount()));
    }

    @PostMapping("/{transactionId}/cancel")
    public ResponseEntity<Transaction> cancelTransaction(@PathVariable Long transactionId) {
        return ResponseEntity.ok(transactionService.cancelTransaction(transactionId));
    }

    @GetMapping("/card/{cardNumber}")
    public ResponseEntity<List<Transaction>> getTransactionsByCard(@PathVariable String cardNumber) {
        return ResponseEntity.ok(transactionService.getTransactionsByCard(cardNumber));
    }
}