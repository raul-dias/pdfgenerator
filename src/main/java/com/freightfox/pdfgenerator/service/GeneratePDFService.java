package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.DTO.Invoice;

public interface GeneratePDFService {

    public String generatePDF(Invoice invoice);
}
