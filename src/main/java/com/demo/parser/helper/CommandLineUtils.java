package com.demo.parser.helper;

import org.apache.commons.cli.*;

import static com.demo.parser.constants.CommandLineParamConstants.*;

public class CommandLineUtils {
    public static CommandLine getCommandLine(String[] args) throws ParseException {
        Options options = getOptions();
        CommandLineParser cmdParser = new GnuParser();
        return cmdParser.parse(options, args);
    }

    public static Options getOptions() {
        Options options = new Options();
        options.addOption("sp", SOURCE_FILE_PATH, true, "Source file path");
        options.addOption("sf", SOURCE_FILE_FORMAT, true, "Source file format");
        options.addOption("tp", TARGET_FILE_PATH, true, "Target file path");
        options.addOption("tf", TARGET_FILE_FORMAT, true, "Target file format");
        options.addOption("j", JOB_TYPE, true, "Job Type");
        options.addOption("ut", UPDATE_TYPE, true, "Update Type");
        options.addOption("usp", UPDATE_SOURCE_PATH, true, "Update source path");

        return options;
    }
}
