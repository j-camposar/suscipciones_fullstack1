package com.subscripciones.subcripciones.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suscrpcion {
    private int id;
    private String planName;
    private int price;
    private int maxScreen;
    private Boolean isActive;
    private String category;
}
