/**
 * 
 */
package catalyst.base;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import catalyst.automation.utility.Driver;
import cucumber.api.Scenario;
//import catalyst.automation.utility.Driver;
/**
 * @author E000911
 *
 */
public class ExtentReportUtil extends BaseUtil{

	//private String filename = reportLocation + "\\extentreport.html";
	
	public void ExtentReport() {
		String filename = reportLocation + "extentreport.html";
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Catalyst Automation Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Catalyst BDD Report");
		
		extent.attachReporter(htmlReporter);
	}
	
	public void ExtentReportScreenShot() throws IOException {		
		File scr= ((TakesScreenshot)Driver.browser).getScreenshotAs(OutputType.FILE);
		Files.copy(scr,new File(reportLocation + "screenshot.png"));
		//Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
	//	scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
			
	}
	
	public void creatTest(Scenario scenario,String screenshotfilename) throws IOException {
		if(scenario != null)
		{
			switch (scenario.getStatus()) {
			case PASSED:				
				extent.createTest(scenario.getName(), "Test Description").pass("details");
				break;
			case FAILED:
				extent.createTest(scenario.getName()).fail("Failed").addScreencastFromPath(getScreenShotLocation(screenshotfilename));

			default:
				extent.flush();
				break;
			}
			
		}		
	}
	
	private String getScreenShotLocation(String location) {
		
		return "file:///"+ location.replaceAll("\\", "//");
	
	}
	
	
	public void FlushReport() {
		extent.flush();
	}
	
}
