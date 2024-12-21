package com.bankinc.marketplace.dto;

import com.bankinc.marketplace.model.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CardCreationDTO {
    @NotBlank(message = "Holder name is required")
    private String holderName;

    private CardType cardType;

    @NotBlank(message = "Product ID is required")
    @Size(min = 6, max = 6, message = "Product ID must be exactly 6 digits")
    @Pattern(regexp = "\\d{6}", message = "Product ID must contain only digits")
    private String productId;
}