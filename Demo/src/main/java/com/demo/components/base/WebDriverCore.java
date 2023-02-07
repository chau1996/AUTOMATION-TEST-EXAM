package com.demo.components.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebDriverCore {
  public static WebDriver driver;
  public static Properties properties;
  public static String baseURL;
  public static WebDriver newDriver(String browserName) {
    switch (browserName) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      default:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
    }
    return driver;
  }

  public static void initialization() {
    try {
      properties = new Properties();
      FileInputStream ip =
          new FileInputStream(
              "src/test/resources/config.properties");
      properties.load(ip);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("file not found");
    } catch (IOException e) {
      System.out.println("io exception");
    }

    String browserName = System.getProperty("browser","chrome");
    baseURL = properties.getProperty("url");
    driver = newDriver(browserName);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(baseURL);
  }

  public static void tearDownMain() {
    driver.quit();
  }
}
