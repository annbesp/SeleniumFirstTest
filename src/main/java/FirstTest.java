import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkAuthorisation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("tt9853341@gmail.com");
        driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("Alkkkjhkg7565543");
        driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
        Thread.sleep(10000);
        Assert.assertEquals("Завантажити зображення" , driver.findElement(By.xpath("//div[@aria-label='Завантажити зображення']")).getText());
        driver.close();
    }

    @Test
    public void checkInvalidAuthorisation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("tt9853341@gmail.com");
        driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("11111111");
        driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
        Thread.sleep(10000);
        Assert.assertNotNull(driver.findElement(By.xpath("//form[@id='login_form']")));
        driver.close();
    }
}
