package com.demo.parser.interfaces;

import com.demo.parser.driver.AppContext;

public interface Writer {
    void init(AppContext context);
    void write();
}
