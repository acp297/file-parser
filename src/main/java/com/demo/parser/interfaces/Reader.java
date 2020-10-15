package com.demo.parser.interfaces;

import com.demo.parser.driver.AppContext;

public interface Reader {
    void init(AppContext context, Class<?> clazz);
    <T>T read();
}
