package vention.com;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestLogger implements ITestListener {

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("Pass: " + result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println("Fail: " + result.getName()); 
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("Skip: " + result.getName());
  }
}
