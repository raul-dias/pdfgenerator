package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.GeneratePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @Autowired
    GeneratePDFService generatePDFservice;

    @GetMapping("/test")
    public String test(){return "helloWorld";}

    @PostMapping("/generatePDF")
    public String generatePDF(@RequestBody Invoice invoice){
        return generatePDFservice.generatePDF(invoice);
    }
}
