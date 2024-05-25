package com.freightfox.pdfgenerator.service.serviceImpl;

import com.freightfox.pdfgenerator.DTO.Invoice;
import com.freightfox.pdfgenerator.service.CreatePDFService;
import com.lowagie.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class CreatePDFServiceImpl implements CreatePDFService {
    private Logger logger = LoggerFactory.getLogger(CreatePDFServiceImpl.class);

    @Autowired
    private TemplateEngine templateEngine;

    private static String pdfDirectory = "D:\\dev\\FreightFox\\pdfs\\";

    @Override
    public File createPDF(Invoice invoice) {
        Context context = new Context();
        context.setVariable("invoice", invoice);

        String htmlContent = templateEngine.process("invoiceTemplate.html", context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfDirectory + "pdfFileName");
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
        } catch (FileNotFoundException | DocumentException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
