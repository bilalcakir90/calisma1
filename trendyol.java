package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class trendyol {

    protected WebDriver driver;
    public static String loginUrl = "https://www.trendyol.com/";

    @Before
    public void setUp() {

        try {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver","C:\\Users\\testinium\\IdeaProjects\\Otomasyon\\CromeDriver\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void login() {

        driver.get(loginUrl);

        driver.findElement(xpath("//*[contains(@class,'fancybox-close')]")).click();


        driver.findElement(id("not-logged-in-container")).click();


        driver.findElement(id("login-email")).sendKeys("testyaanimail@gmail.com");


        driver.findElement(id("login-password-input")).sendKeys("Test1234.");


        driver.findElement(xpath("//*[contains(@class,'q-fluid')]")).click();
        ;

        Assert.assertEquals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da", driver.getTitle());
        System.out.println("Başarılı şekilde login olundu");

        driver.findElement(id("Combined-Shape")).click();


        driver.findElement(xpath("//*[contains(text(), 'KADIN')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'ERKEK')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'ÇOCUK')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'EV & YAŞAM')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'SÜPERMARKET')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'KOZMETİK')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'AYAKKABI & ÇANTA')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'SAAT & AKSESUAR')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'ELEKTRONİK')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(xpath("//*[contains(text(), 'ERKEK')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(xpath("(//span[contains(@class,'image-container')])[1]")).click();

            /*boolean notUpload = driver.findElement(By.xpath("(//*[contains(@src,'/Content/images/defaultThumb.jpg')])[1]")).isDisplayed();

            if(notUpload == true)
            {
                System.out.println("Sayfada yuklenmeyen urunler var.");
            } */
        driver.findElement(xpath("(//img[contains(@class,'p-card-img')])[1]")).click();

        

        driver.findElement(xpath("//div[contains(@class, 'add-to-bs-tx') and text()='Sepete Ekle']")).click();


        driver.close();
        driver.quit();


    }
    @After
    public void tearDown() throws Exception {

    }
}

