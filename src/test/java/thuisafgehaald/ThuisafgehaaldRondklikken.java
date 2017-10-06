package thuisafgehaald;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ThuisafgehaaldRondklikken {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    // Manual path to firefox:
    System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");

    driver = new FirefoxDriver();
    baseUrl = "https://www.thuisafgehaald.nl";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testThuisafgehaaldRondklikken() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Hoe werkt het?")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Registreren')])[2]")).click();
    driver.findElement(By.linkText("Het team")).click();
    driver.findElement(By.linkText("Contact")).click();
    driver.findElement(By.cssSelector("#logo > img")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
