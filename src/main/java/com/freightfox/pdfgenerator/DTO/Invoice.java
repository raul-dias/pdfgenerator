package com.freightfox.pdfgenerator.DTO;

import lombok.Data;
import java.util.List;

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
