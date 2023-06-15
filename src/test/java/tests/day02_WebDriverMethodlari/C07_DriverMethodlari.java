package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverMethodlari {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //ChromeDriver kullanarak, facebook sayfasina gidin
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.navigate().to("https://www.facebook.com");

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        }else {

            System.out.println("facebook title testi FAILED \nActual title : " + actualTitle);
        }


        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        String expectedUrlIcerik = "facebook";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("facebook url testi PASSED");
        }else {
            System.out.println("facebook url testi FAILED \nActualUrl : "+actualUrl);
        }

        //https://www.walmart.com/ sayfasina gidin.

        driver.navigate().to("https://www.walmart.com");

        actualTitle =driver.getTitle();
        String expectedTitleIcerik = "Walmart.com";

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart title testi PASSED");
        }else {
            System.out.println("Walmart title testi FAILED \nActualTite : "+ actualTitle);
        }

        // Tekrar “facebook” sayfasina donun

        driver.navigate().back();

        // Sayfayi yenileyin

        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin

        driver.manage().window().maximize();

        //Browser’i  kapatin
        Thread.sleep(3000);
        driver.close();




    }
}
