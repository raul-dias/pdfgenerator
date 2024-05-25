package com.freightfox.pdfgenerator.service.serviceImpl;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.CreatePDFService;
import com.freightfox.pdfgenerator.service.GeneratePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratePDFServiceImpl implements GeneratePDFService {

    @Autowired
    CreatePDFService createPDFService;

    @Override
    public String generatePDF(Invoice invoice) {
        createPDFService.createPDF(invoice);
        return invoice.getBuyer();
    }
}
