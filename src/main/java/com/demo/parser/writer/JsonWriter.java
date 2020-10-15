package com.demo.parser.writer;

import com.demo.parser.driver.AppContext;
import com.demo.parser.interfaces.Writer;

public class JsonWriter implements Writer {
    private AppContext appContext;

    public void init(AppContext context) {
        this.appContext = context;
    }

    public void write() {

    }
}
