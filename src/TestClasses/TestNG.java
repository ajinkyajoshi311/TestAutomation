package TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
 
public class TestNG {
 WebDriver driver ;
 @Test
 public void f() {
   
     String baseUrl = "https://www.toolsqa.com/";
       
          
         System.out.println("Launching FireFox browser"); 
     	System.setProperty("webdriver.gecko.driver", "E:\\Selenium Files\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    	driver = new FirefoxDriver();
         driver.get(baseUrl);
     	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         String testTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
         String originalTitle = driver.getTitle();
         Assert.assertEquals(originalTitle, testTitle);
  }
 
 @BeforeMethod
 public void beforeMethod() {
 System.out.println("Starting Test On FireFox Browser");
 }
 
 @AfterMethod
 public void afterMethod() {
 driver.close();
 System.out.println("Finished Test On FireFox Browser");
 }
}