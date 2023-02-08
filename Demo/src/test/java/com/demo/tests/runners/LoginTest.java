package com.demo.tests.runners;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {


  @Test(priority = 0)
  public void testSuccessfulLogin() {
    driver.findElement(By.name("email")).sendKeys("user1@phptravels.com");
    driver.findElement(By.name("password")).sendKeys("demouser1");
    driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
    String username = driver.findElement(By.xpath("//h2[contains(text(),'Hi,')]")).getText();

    if (username.equals("Hi, Demo Welcome Back")) {
      System.out.println("Login Success: Pass");
    } else {
      System.out.println("Login Success: Fail");
    }
  }

  @Test(priority = 1)
  public void placeholdersTest() throws InterruptedException {
    Thread.sleep(3000);
    WebElement email = driver.findElement(By.name("email"));
    WebElement password = driver.findElement(By.name("password"));
    Assert.assertEquals(email.getAttribute("placeholder"), "Email");
    Assert.assertEquals(password.getAttribute("placeholder"), "Password");
    WebElement rememberMe = driver.findElement(By.xpath("//label[normalize-space()='Remember Me']"));
    rememberMe.click();
    Thread.sleep(3000);
    Assert.assertFalse(rememberMe.isSelected());
  }
}
