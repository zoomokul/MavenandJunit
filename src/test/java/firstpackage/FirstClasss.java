package firstpackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstClasss {
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void googleSearch(){
        driver.get("https://www.google.com.tr/");
        Assert.assertEquals("Google",driver.getTitle());
    }
    @Test
    public  void yandexSearch(){
        driver.get("https://yandex.com.tr/");
        Assert.assertEquals("https://yandex.com.tr/",driver.getCurrentUrl());
    }
    @Test
    public  void bingSearch(){
        driver.get("https://www.bing.com/");
        Assert.assertTrue(driver.getTitle().contains("Bing"));
    }
    @After
    public  void tearDown(){
        driver.close();
    }
}
