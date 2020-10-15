package com.demo.parser.job;

import com.demo.parser.driver.AppContext;
import com.demo.parser.factory.ReaderFactory;
import com.demo.parser.factory.WriterFactory;
import com.demo.parser.interfaces.Job;
import com.demo.parser.interfaces.Reader;
import com.demo.parser.interfaces.Writer;
import com.demo.parser.model.BaseModel;

public class FileReader implements Job {
    private Class<?> clazz;
    private AppContext context;

    public void init(AppContext context, Class<?> clazz) {
        this.context = context;
        this.clazz = clazz;
    }

    public void run() {
        read();
        write();
    }

    public BaseModel read() {
        Reader reader = ReaderFactory.getReader(context.getSourceType());
        reader.init(context, clazz);
        BaseModel object = reader.read();
        context.setBaseModel(object);
        return object;
    }

    public void write() {
        Writer writer = WriterFactory.getWriter(context.getTargetType());
        writer.init(context);
        writer.write();
    }
}
