/**
 * 
 */
package catalyst.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.mongodb.diagnostics.logging.Logger;

import catalyst.base.BaseUtil;
import java.util.logging.*;
import org.apache.log4j.Logger;

/**
 * @author E000911
 *
 */
public class Selenide extends BaseUtil{
	public final static Logger LOG = Logger.getLogger(Selenide.class);


	protected boolean click(By locator, String locatorName) throws Throwable {
		boolean status = false;
		try {
			
			//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
			LOG.info("Method : click  ::  Locator : " + locatorName);
			WebDriverWait wait = new WebDriverWait(Driver.browser, 15);
			LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			LOG.info("Clicked on the Locator");
			Driver.browser.findElement(locator).click();
			//Driver.findElement(locator).click();
			LOG.info("identified the element :: " + locator);
			status = true;
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
			BaseUtil.scenarioDef.pass("entered text as khaja");
		} finally {
			if (!status) {
					//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
				BaseUtil.scenarioDef.pass("entered text as khaja");
			} else {
				//reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
				BaseUtil.scenarioDef.pass("entered text as khaja");
			}
		}
		return status;
	}
	
	public static WebElement getelement(By locator) throws Throwable {
		WebElement webelement = null;
		try {
			
			//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
		//	LOG.info("Method : click  ::  Locator : " + locatorName);
			WebDriverWait wait = new WebDriverWait(Driver.browser, 15);
			LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			LOG.info("Clicked on the Locator");
			Driver.browser.findElement(locator);
			//Driver.findElement(locator).click();
			LOG.info("identified the element :: " + locator);
			return webelement;
		} catch (Exception e) {
			
			LOG.info(e.getMessage());
			//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
			BaseUtil.scenarioDef.pass("entered text as khaja");
		} finally {
			
		}
		return webelement;
	}	
}
