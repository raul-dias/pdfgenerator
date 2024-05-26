package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.DTO.Invoice;

import java.io.File;

public interface GeneratePDFService {

    public File generatePDF(Invoice invoice);
}
