package com.demo.parser.reader;

import com.demo.parser.driver.AppContext;
import com.demo.parser.interfaces.Reader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlReader implements Reader {
    private Class<?> clazz;
    private AppContext context;


    public void init(AppContext context, Class<?> clazz) {
        this.context = context;
        this.clazz = clazz;
    }


    public <T> T read() {
        File file = new File(context.getSourceFilePath());
        try {

            return parseXmlFileIntoObject(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T parseXmlFileIntoObject(File file, Class<?> clazz) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return (T) mapper.readValue(file, clazz);

        } catch (IOException e) {
            throw new IOException("Configuration loader failed" + " " + e.getMessage());
        }
    }
}
