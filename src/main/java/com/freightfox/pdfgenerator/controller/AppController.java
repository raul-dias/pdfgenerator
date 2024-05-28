package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.GeneratePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
public class AppController {

    @Autowired
    GeneratePDFService generatePDFservice;

    @GetMapping("/test")
    public String test(){return "helloWorld";}

    /**
     * Api will return the invoice.pdf file based on json.
     * @param invoice
     * @return File or Internal Server Error
     */
    @PostMapping("/generatePDF")
    public ResponseEntity<Resource> generatePDF(@RequestBody Invoice invoice) {
        File file = generatePDFservice.generatePDF(invoice);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice.pdf");
        try{
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
