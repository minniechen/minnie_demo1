package com.minnie.learning.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class TestNgTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\WEIYK\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver= new ChromeDriver(options);
        baseUrl= "http://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {

        driver.get(baseUrl+"/");
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("testNG");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String title=driver.getTitle();
        assertEquals(title,"testNG_百度搜索");
    }
    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();

    }
}
