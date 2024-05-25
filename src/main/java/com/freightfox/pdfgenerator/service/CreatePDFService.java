package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.DTO.Invoice;

import java.io.File;

public interface CreatePDFService {

    public File createPDF(Invoice invoice);
}
