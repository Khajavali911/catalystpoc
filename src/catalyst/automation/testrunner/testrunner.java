package catalyst.automation.testrunner;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import catalyst.automation.utility.BrowserTypes;
import catalyst.automation.utility.Driver;
import catalyst.base.BaseUtil;
import catalyst.base.ExtentReportUtil;
import catalyst.base.Hooks;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
@Listeners(catalyst.automation.listeners.ITestListernerImpl.class)
@CucumberOptions (
        features = "./features/"
        ,glue = {"catalyst.automation.stepdef"}
        ,tags = {"@Youtube"})
		/*,plugin= { "pretty",
                "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" },
        monochrome = true) */
public class testrunner  {
    private TestNGCucumberRunner testNGCucumberRunner;
    //private static ExtentReportUtil extentreportUtil=new ExtentReportUtil();
   // private static ExtentReportUtil extentreportUtil;
	//private static boolean isReportRunning;
   @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {      	
       testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());		
       Driver.StartBrowser(BrowserTypes.Chrome, 30);
       //scenaraioDef = BaseUtil.features.createNode( )
    }
    
   
    @Test(dataProvider = "features")    
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }
    
    @DataProvider//(parallel=true)
    public Object[][] features() {
       // return testNGCucumberRunner.provideFeatures();    	
    	 return testNGCucumberRunner.provideScenarios();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass(ITestContext text) throws IOException{            
       testNGCucumberRunner.finish();        
        Driver.StopBrowser();
       
    }
    
    
    
}