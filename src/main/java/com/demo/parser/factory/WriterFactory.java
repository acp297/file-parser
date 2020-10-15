package com.demo.parser.factory;

import com.demo.parser.enums.FileType;
import com.demo.parser.interfaces.Writer;
import com.demo.parser.writer.JsonWriter;
import com.demo.parser.writer.XmlWriter;

public class WriterFactory {
    public static Writer getWriter(FileType type) {

        switch (type) {
            case XML:
                return new XmlWriter();

            case JSON:
                return new JsonWriter();
        }
        throw new IllegalArgumentException("Unknown writer format");
    }
}
