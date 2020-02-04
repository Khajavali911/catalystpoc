package catalyst.automation.stepdef;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;

import catalyst.automation.pages.YoutubeSearchPageElementMap;
import catalyst.automation.pages.YoutubeSearchPageValidator;

import catalyst.automation.utility.Driver;
import catalyst.automation.utility.propertiesfilereader;
import catalyst.base.BaseUtil;
import catalyst.base.ExtentReportUtil;
import catalyst.base.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;


public class youtubesearchstepdef {
	//public static WebDriver driver;
	 propertiesfilereader obj= new propertiesfilereader();  
	 private BaseUtil base;
	 private static ExtentReportUtil extentreportUtil= new ExtentReportUtil();
	 YoutubeSearchPageElementMap youtubesearch=	new YoutubeSearchPageElementMap(Driver.browser);
	 YoutubeSearchPageValidator serachValidator = new YoutubeSearchPageValidator(youtubesearch);
	 public youtubesearchstepdef(BaseUtil base)
	 {
		this.setBase(base);
	 }
	@Before(order=0)
	public void BeforeFeature(Feature feature) {
		BaseUtil.features = BaseUtil.extent.createTest(Feature.class,feature.toString());
	}
	 
	@Before
	public void BeforeScenario(Scenario scenario)
	{
		//if(extentreportUtil != null) {
	//	BaseUtil.features = BaseUtil.extent.createTest(Feature.class, "youtube feature");
		BaseUtil.features = BaseUtil.extent.createTest((Class<? extends IGherkinFormatterModel>) Scenario.class,scenario.getName());
			// features.createNode((Class<? extends IGherkinFormatterModel>) Scenario.class, scenario.getName());
		
	}
	
	@After
	public void AfterScenario()
	{
		
	}
	
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		
		//test = extent.createTest(Feature.class, "Youtube channel name validation");							
		//test=test.createNode(Scenario.class, "Youtube channel name validations");						
		//logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
		Properties properties=obj.getProperty(); 
		BaseUtil.scenarioDef=BaseUtil.features.createNode(new GherkinKeyword("Given"), "Open chrome browser and enter url");
        Driver.browser.get(properties.getProperty("browser.baseURL"));
        BaseUtil.scenarioDef.pass("entered youtube url in the search box");
	//	Driver.browser.get(properties.getProperty("browser.baseURL"));
		//driver.get(properties.getProperty("browser.baseURL"));
		Thread.sleep(3000);	
		System.out.print("you tube open browser from stepdef");
	}

	@When("^Enter search creteria$")
	public void enter_search_creteria() throws Throwable 
	{
		//scenarioDef.createNode(new GherkinKeyword("When"),"Enter search creteria");
		//BaseUtil.features.createNode("Enter search creteria");
		//BaseUtil.scenarioDef.createNode(new GherkinKeyword("When"),"Enter search creteria");
		//BaseUtil.scenarioDef.createNode(new GherkinKeyword("When"), "Enter search creteria");
		BaseUtil.scenarioDef=BaseUtil.features.createNode(new GherkinKeyword("When"), "Enter search creteria");
		 serachValidator.entertext("Khajavali");
		 BaseUtil.scenarioDef.pass("entered text as khaja");
		//Driver.browser.findElement(By.id("search")).sendKeys("selenium by bakkappa n");	
		
		Thread.sleep(1000);	 	    
	}

	@Then("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
		BaseUtil.scenarioDef=BaseUtil.features.createNode(new GherkinKeyword("Then"), "Clicks on search button");
		serachValidator.clicktext();
		BaseUtil.scenarioDef.pass("Clicked on youtube search button");
		
//	Driver.browser.findElement(By.cssSelector("search-icon-legacy")).click();;	
		Thread.sleep(3000);	 	
		//driver.quit();
	}

	

	public BaseUtil getBase() {
		return base;
	}

	public void setBase(BaseUtil base) {
		this.base = base;
	}

}