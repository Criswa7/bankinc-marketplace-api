package com.bankinc.marketplace.service;

import com.bankinc.marketplace.model.Card;
import com.bankinc.marketplace.model.CardType;
import com.bankinc.marketplace.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {
    
    private final CardRepository cardRepository;
    private final Random random = new Random();

    @Transactional
    public Card createCard(String holderName, CardType cardType, String productId) {
        Card card = Card.builder()
                .holderName(holderName)
                .cardType(cardType)
                .cardNumber(generateCardNumber(productId))
                .expirationDate(LocalDate.now().plusYears(3))
                .balance(0.0)
                .build();
        
        return cardRepository.save(card);
    }

    @Transactional
    public Card rechargeCard(String cardNumber, Double amount) {
        Card card = cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        
        card.setBalance(card.getBalance() + amount);
        return cardRepository.save(card);
    }

    private String generateCardNumber(String productId) {
        if (productId.length() != 6) {
            throw new IllegalArgumentException("Product ID must be 6 digits");
        }

        StringBuilder cardNumber = new StringBuilder(productId);
        for (int i = 0; i < 10; i++) {
            cardNumber.append(random.nextInt(10));
        }
        
        return cardNumber.toString();
    }

    public Card getCard(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }
}