package com.demo.parser.interfaces;

import com.demo.parser.driver.AppContext;

public interface Job {
    void run();
    void init(AppContext context, Class<?> clazz);
}
