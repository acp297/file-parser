package com.demo.parser.factory;

import com.demo.parser.enums.FileType;
import com.demo.parser.interfaces.Reader;
import com.demo.parser.reader.JsonReader;
import com.demo.parser.reader.XmlReader;


public class ReaderFactory {

    public static Reader getReader(FileType type) {

        switch (type) {
            case XML:
                return new XmlReader();

            case JSON:
                return new JsonReader();
        }
        throw new IllegalArgumentException("Unknown reader format");
    }

}
