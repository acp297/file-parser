package com.demo.parser.writer;

import com.demo.parser.driver.AppContext;
import com.demo.parser.interfaces.Writer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlWriter implements Writer {
    private AppContext context;

    public void init(AppContext context) {
        this.context = context;
    }

    public void write() {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xmlString = null;
        try {
            xmlString = objectMapper.writeValueAsString(context.getBaseModel());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(xmlString);

        File xmlOutput = new File(context.getTargetFilePath());
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
