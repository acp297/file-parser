package com.demo.parser.factory;

import com.demo.parser.enums.JobType;
import com.demo.parser.interfaces.Job;
import com.demo.parser.job.FileModifier;
import com.demo.parser.job.FileReader;

public class JobFactory {

    public static Job getJob(JobType type) {

        switch (type) {
            case READ:
                return new FileReader();

            case UPDATE:
                return new FileModifier();
        }
        throw new IllegalArgumentException("Unknown reader type format");

    }

    }
