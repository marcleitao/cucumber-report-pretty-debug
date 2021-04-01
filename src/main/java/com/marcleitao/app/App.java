package com.marcleitao.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.File;

import org.apache.commons.io.FileUtils;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;

public class App 
{
    public static void main( String[] args )
    {
        List<String> list = new ArrayList<>();
        list.add(new File("target/classes") + "/" + "report.json");
        Configuration configuration = new Configuration(new File("target"), "cucumberProject");
        // do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        
        ReportBuilder reportBuilder = new ReportBuilder(list, configuration);
        reportBuilder.generateReports();
    }
}
