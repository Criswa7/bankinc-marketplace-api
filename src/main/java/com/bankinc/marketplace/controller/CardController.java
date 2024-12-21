package com.bankinc.marketplace.controller;

import com.bankinc.marketplace.dto.CardCreationDTO;
import com.bankinc.marketplace.dto.CardRechargeDTO;
import com.bankinc.marketplace.model.Card;
import com.bankinc.marketplace.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@Valid @RequestBody CardCreationDTO dto) {
        return ResponseEntity.ok(cardService.createCard(dto.getHolderName(), 
                                                      dto.getCardType(), 
                                                      dto.getProductId()));
    }

    @PostMapping("/recharge")
    public ResponseEntity<Card> rechargeCard(@Valid @RequestBody CardRechargeDTO dto) {
        return ResponseEntity.ok(cardService.rechargeCard(dto.getCardNumber(), 
                                                        dto.getAmount()));
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<Card> getCard(@PathVariable String cardNumber) {
        return ResponseEntity.ok(cardService.getCard(cardNumber));
    }
}