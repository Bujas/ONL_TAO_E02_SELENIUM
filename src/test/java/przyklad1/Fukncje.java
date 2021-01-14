package przyklad1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fukncje {
    WebDriver driver;


    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://pl.wikipedia.org/");
    }

    @Test
    public void fillForm() {
        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isEnabled()) {
            search.sendKeys("Selenium");
            search.submit();
        }else 	{
            Assert.fail();
        }
    }

}