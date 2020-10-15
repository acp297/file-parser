package com.demo.parser.driver;


import com.demo.parser.factory.JobFactory;
import com.demo.parser.interfaces.Job;
import com.demo.parser.model.*;
import org.apache.commons.cli.ParseException;


public class App {
    public static void main(String[] args) throws ParseException {
        new App().run(args);
    }

    public void run(String[] args) throws ParseException {
        AppContext context = AppContext.getInstance();
        context.setContext(args);

        Job job = JobFactory.getJob(context.getJobType());
        job.init(context, Employees.class);
        job.run();
    }

}
