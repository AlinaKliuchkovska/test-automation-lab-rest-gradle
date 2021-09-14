package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestNGListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(TestNGListener.class);

    public void onFinish(ITestContext result) {
        LOG.info("Test suite finished: " + result.getEndDate());
    }

    public void onStart(ITestContext result) {
        LOG.info("Test suite started" + result.getStartDate() + ",on host: " + result.getHost());
    }

    public void onTestFailure(ITestContext result) {
        LOG.error("Test failed: " + result.getName());
    }

    public void onTestSkipped(ITestContext result) {
        LOG.warn("Test skipped: " + result.getName());
    }

    public void onTestStart(ITestContext result) {
        LOG.info("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestContext result) {
        LOG.info("Test passed: " + result.getName());
    }
}