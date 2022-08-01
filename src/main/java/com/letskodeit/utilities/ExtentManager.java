package com.letskodeit.utilities;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
//here I used ExtentSparkReporter with newer version. need to downgrade to version 4xx to
//support ExtentHtmlReporter
public class ExtentManager {
    private static final Logger log = LogManager.getLogger(ExtentManager.class.getName());
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static synchronized ExtentReports createInstance() {
        String fileName = Util.getReportName();
        String reportsDirectory = Constants.REPORTS_DIRECTORY;
        new File(reportsDirectory).mkdirs();
        String path = reportsDirectory + fileName;
        log.info("*********** Report Path ***********");
        log.info(path);
        log.info("*********** Report Path ***********");
       // ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Run");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
       // need below config when runs from jenkins
       // htmlReporter.config().setAutoCreateRelativePathMedia(true);
        

        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "com.Chathundara");
        extent.setSystemInfo("Automation Framework", "Selenium WebDriver");
        extent.setSystemInfo("Automation Engineer", "Chathundara");
        
        extent.attachReporter(htmlReporter);

        return extent;
    }

}