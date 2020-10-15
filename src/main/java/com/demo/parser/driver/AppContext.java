package com.demo.parser.driver;

import com.demo.parser.enums.JobType;
import com.demo.parser.enums.FileType;
import com.demo.parser.enums.UpdateType;
import com.demo.parser.model.BaseModel;
import org.apache.commons.cli.*;

import java.util.Objects;

import static com.demo.parser.constants.CommandLineParamConstants.*;
import static com.demo.parser.helper.CommandLineUtils.getCommandLine;

public class AppContext {
    private String sourceFilePath;
    private String targetFilePath;
    private FileType sourceType;
    private FileType targetType;
    private JobType jobType;
    private BaseModel baseModel;
    private UpdateType updateType;
    private String updateSourcePath;
    private static AppContext instance;

    private AppContext(){};


    public static synchronized AppContext getInstance(){
        if (Objects.isNull(instance)) {
            synchronized (AppContext.class){
                if (Objects.isNull(instance)) {
                    instance = new AppContext();
                }
            }
        }
        return instance;
    }

    public AppContext setContext(String[] args) throws ParseException {
        CommandLine cmd = getCommandLine(args);

        String updateType = cmd.getOptionValue(UPDATE_TYPE);

        instance.setSourceFilePath(cmd.getOptionValue(SOURCE_FILE_PATH));
        instance.setTargetFilePath(cmd.getOptionValue(TARGET_FILE_PATH));
        instance.setSourceType(FileType.valueOf(cmd.getOptionValue(SOURCE_FILE_FORMAT).toUpperCase()));
        instance.setTargetType(FileType.valueOf(cmd.getOptionValue(TARGET_FILE_FORMAT).toUpperCase()));
        instance.setJobType(JobType.valueOf(cmd.getOptionValue(JOB_TYPE).toUpperCase()));
        instance.setUpdateType(updateType != null ? UpdateType.valueOf(updateType.toUpperCase()) : null);
        instance.setUpdateSourcePath(cmd.getOptionValue(UPDATE_SOURCE_PATH));

        return instance;
    }


    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public FileType getSourceType() {
        return sourceType;
    }

    public void setSourceType(FileType sourceType) {
        this.sourceType = sourceType;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getTargetFilePath() {
        return targetFilePath;
    }

    public void setTargetFilePath(String targetFilePath) {
        this.targetFilePath = targetFilePath;
    }

    public FileType getTargetType() {
        return targetType;
    }

    public void setTargetType(FileType targetType) {
        this.targetType = targetType;
    }

    public BaseModel getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(BaseModel baseModel) {
        this.baseModel = baseModel;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public String getUpdateSourcePath() {
        return updateSourcePath;
    }

    public void setUpdateSourcePath(String updateSourcePath) {
        this.updateSourcePath = updateSourcePath;
    }

}
