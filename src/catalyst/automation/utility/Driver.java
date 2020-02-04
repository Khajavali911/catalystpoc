package catalyst.automation.utility;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class Driver {
	private static WebDriverWait browserWait;
	public static WebDriver browser=null;
	
    public WebDriver getWebDriver() { return this.browser; }
    public void setWebDriver(WebDriver browser) { Driver.browser = browser; }
    public WebDriverWait getWebDriverWait() { return this.browserWait; }
    public void setWebDriverWait(WebDriverWait browserWait) { this.browserWait = browserWait; }
    public static void StartBrowser(BrowserTypes browserType,int defaultTimeOut)
    {    	   
		if(browser == null) {		
        switch (browserType)
        {
            case Firefox:
                Driver.browser = new FirefoxDriver();                    
                break;
            case InternetExplorer:
                break;
            case Chrome:
            	System.setProperty("webdriver.chrome.driver", "C:\\Walmart\\chromedriver_win32\\chromedriver.exe");
            	Driver.browser = new ChromeDriver();
                break;
            default:
                break;
        }
        browserWait = new WebDriverWait(Driver.browser, defaultTimeOut);
		}
		browser.manage().deleteAllCookies();
		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		browser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();	
    }
    public static void StopBrowser()
    {    
    	browser.quit();
    	browser = null;
    	browserWait = null;
    }
	
}
