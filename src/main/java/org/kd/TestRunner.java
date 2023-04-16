package org.kd;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRunner implements ITestListener, IReporter {

    private Map<String, Integer> groupCounts = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        for (String group : groups) {
            if (groupCounts.containsKey(group)) {
                int count = groupCounts.get(group);
                groupCounts.put(group, count + 1);
            } else {
                groupCounts.put(group, 1);
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test results:");
        for (Map.Entry<String, Integer> entry : groupCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " tests");
        }
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Do nothing
    }

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{});
        testng.addListener(new TestRunner());
        testng.run();
    }
}
