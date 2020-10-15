package com.demo.parser.job;

import com.demo.parser.driver.AppContext;
import com.demo.parser.enums.UpdateType;
import com.demo.parser.interfaces.Job;
import com.demo.parser.interfaces.BaseModel;

public class FileModifier implements Job {
    private Class<?> clazz;
    private AppContext context;
    private FileReader fileReader;
    private BaseModel existingObject;
    private BaseModel newObject;

    public void init(AppContext context, Class<?> clazz) {
        this.context = context;
        this.clazz = clazz;
    }

    public void run() {
        UpdateType updateType = context.getUpdateType();
        fileReader = new FileReader();
        fileReader.init(context, clazz);
        existingObject = fileReader.read();

        context.setSourceFilePath(context.getUpdateSourcePath());
        newObject = fileReader.read();

        switch (updateType){
            case ADD:
                existingObject.appendObject(newObject);
                break;

            case DELETE:
                existingObject.deleteObject(newObject);
                break;

            case MODIFY:
                existingObject.modifyObject(newObject);
                break;
        }
        context.setBaseModel(existingObject);
        fileReader.write();
    }
}
