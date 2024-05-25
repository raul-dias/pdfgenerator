package com.freightfox.pdfgenerator.DTO;

import lombok.Data;

@Data
public class Items {

    private String name;
    private String quantity;
    private float rate;
    private float amount;
}
