package com.freightfox.pdfgenerator.service.serviceImpl;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.CreatePDFService;
import com.freightfox.pdfgenerator.service.GeneratePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

@Service
public class GeneratePDFServiceImpl implements GeneratePDFService {

    @Autowired
    CreatePDFService createPDFService;

    HashMap<Invoice,File> db = new HashMap<>();

    @Override
    public File generatePDF(Invoice invoice) {
        if(db.containsKey(invoice)){
            System.out.println("printing from memory");
            return db.get(invoice);
        } else {
            File temp = createPDFService.createPDF(invoice);
            db.put(invoice,temp);
            return createPDFService.createPDF(invoice);
        }
    }
}
