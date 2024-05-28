package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.DTO.Invoice;

import java.io.File;

public interface CreatePDFService {

    /**
     * Method to create a new PDF
     * @param invoice
     * @return File
     */
    public File createPDF(Invoice invoice);
}
