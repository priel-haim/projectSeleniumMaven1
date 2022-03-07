package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllureAttachment {

	@Attachment(value = "{0}", type = "text/plain", fileExtension = ".txt")
	public static String TextAttachment(String message) {
		return message;
	}

	@Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
	public static byte[] getPageSource(WebDriver driver) {
		return driver.getPageSource().getBytes(java.nio.charset.StandardCharsets.UTF_8);
	}

	@Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
	public static String attachURL(String url) {
		return url;
	}

	@Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
	static byte[] attachScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "Element Screenshot", type = "image/png", fileExtension = ".png")
	public static byte[] attachElementScreenshot(WebElement element) {
		return element.getScreenshotAs(OutputType.BYTES);
	}

}
