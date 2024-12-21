package com.bankinc.marketplace.exception;

public class CardNotFoundException extends BusinessException {
    public CardNotFoundException(String cardNumber) {
        super("Card not found with number: " + cardNumber);
    }
}