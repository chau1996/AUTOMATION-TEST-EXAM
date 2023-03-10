package com.demo.tests.runners;


import com.demo.components.base.WebDriverCore;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainTest extends WebDriverCore {

  @BeforeMethod
  public void beforeTest() {
    WebDriverCore.initialization();
  }

  @AfterMethod
  public void afterTest() {
    WebDriverCore.tearDownMain();
  }
}
