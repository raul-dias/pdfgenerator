package com.freightfox.pdfgenerator.service.serviceImpl;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.GeneratePDFService;
import org.springframework.stereotype.Service;

@Service
public class GeneratePDFServiceImpl implements GeneratePDFService {
    @Override
    public String generatePDF(Invoice invoice) {
        return invoice.getBuyer();
    }
}
