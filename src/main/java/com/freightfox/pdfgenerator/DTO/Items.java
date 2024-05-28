package com.freightfox.pdfgenerator.DTO;

import lombok.Data;

/**
 * DTO to describe the details of an Item in an invoice
 */
@Data
public class Items {

    private String name;
    private String quantity;
    private float rate;
    private float amount;
}
