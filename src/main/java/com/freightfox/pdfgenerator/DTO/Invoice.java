package com.freightfox.pdfgenerator.DTO;

import lombok.Data;
import java.util.List;

/**
 * Object to describe the invoice details.
 */
@Data
public class Invoice {

    private String seller;
    private String sellerGstin;
    private String sellerAddress;
    private String buyer;
    private String buyerGstin;
    private String buyerAddress;
    private List<Items> items;
}
