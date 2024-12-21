package com.bankinc.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, length = 16)
    private String cardNumber;
    
    private String holderName;
    private LocalDate expirationDate;
    private Double balance;
    
    @Enumerated(EnumType.STRING)
    private CardType cardType;
}