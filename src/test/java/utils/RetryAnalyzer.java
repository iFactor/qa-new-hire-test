package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

  int counter = 0;
  int retryLimit = 3;

  @Override
  public boolean retry(ITestResult result) {

    if(counter < retryLimit)
    {
      System.out.println("The following test is failing: "+result.getName());
      System.out.println("Sleeping for 5 seconds before retry.");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      counter++;
      return true;
    }
    return false;
  }

}
