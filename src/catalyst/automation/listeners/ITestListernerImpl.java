/**
 * 
 */
package catalyst.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;

import catalyst.base.ExtentReportUtil;


import static catalyst.base.BaseUtil.features;

import java.io.IOException;

/**
 * @author E000911
 *
 */
public class ITestListernerImpl implements ITestListener {

	ExtentReportUtil extentreportUtil =new ExtentReportUtil();
	private static boolean isReportRunning;
	@Override
	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		extentreportUtil.FlushReport();
		System.out.print("On finish from listener");
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		if(!isReportRunning) {			
			extentreportUtil.ExtentReport();
		    isReportRunning = true;				
		}
		//features = extentreportUtil.extent.createTest(Feature.class, "youtube feature");
		System.out.print("from on start");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
			
			try {
				extentreportUtil.ExtentReportScreenShot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

}
