package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.DTO.Invoice;

import java.io.File;

public interface GeneratePDFService {

    /**
     * method to check if the pdf is created, else create a new one.
     * @param invoice
     * @return
     */
    public File generatePDF(Invoice invoice);
}
