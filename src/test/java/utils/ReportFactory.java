package utils;

import static java.lang.Boolean.FALSE;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportFactory {

  public static ExtentReports extent;
  public static String timeStamp = new SimpleDateFormat("MM-dd-yyyy_HHmmss")
      .format(Calendar.getInstance().getTime());
  private static Properties props;

  public static void setup() throws IOException {
    props = new Properties();
    InputStream in = ReportFactory.class.getClassLoader().getResourceAsStream("config.properties");
    props.load(in);
    in.close();
  }

  public static synchronized ExtentReports getReporter() {
    if (extent == null) {
      try {
        setup();
      } catch (IOException e) {
        e.printStackTrace();
      }
      // Create object of extent report and specify the report file path.
      String path = System.getProperty("user.dir") + (props.getProperty("report.path"));
      ExtentHtmlReporter h = new ExtentHtmlReporter(path);
      h.config().setDocumentTitle("Pulse Monitoring");
      h.config().setReportName("Health Check Report");
      h.config().setTestViewChartLocation(ChartLocation.TOP);
      h.config().setTheme(Theme.DARK);
      h.setAppendExisting(FALSE);
      extent = new ExtentReports();
      extent.attachReporter(h);
      extent.setSystemInfo("Selenium Version", "3.40");
      extent.setSystemInfo("Environment", "Test");
    }
    return extent;
  }
    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
      fileName = fileName + ".png";
      String directory = System.getProperty("user.dir") + (props.getProperty("screenshot.path"));
      File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(sourceFile, new File(directory + fileName));
      String destination = "screenshots/" + fileName;
      return destination;
    }

}