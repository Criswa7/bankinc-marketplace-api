package com.bankinc.marketplace.exception;

public class TransactionNotFoundException extends BusinessException {
    public TransactionNotFoundException(Long transactionId) {
        super("Transaction not found with id: " + transactionId);
    }
}