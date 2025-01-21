package org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListeners implements ITestListener {

    private static Logger logger = LogManager.getLogger(ITestListener.class);

    public void onTestStart(ITestResult result){

        logger.info("Test Suite Started.." + " " + result.getMethod().getMethodName());
        logger.info("Description!"+ " " + result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result){
        logger.info("Test cases failed!"+ " : " + result.getMethod().getMethodName());

    }

    public void onTestSkipped(ITestResult result){
        logger.info("Test cases are skipped:"+ " " + result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result){
        logger.info("Test cases are passed Successfully! "+ result.getMethod().getMethodName());

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        logger.info("Test failed but is within the success percentage: "+ result.getMethod().getMethodName());

    }
}
