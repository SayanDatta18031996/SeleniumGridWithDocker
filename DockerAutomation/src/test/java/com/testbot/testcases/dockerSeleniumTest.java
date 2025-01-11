package com.testbot.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class dockerSeleniumTest {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set the browser type based on the parameter
		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			System.out.println("##### Testcase execution started on Chrome #####");
		} else if (browser.equalsIgnoreCase("firefox")) {
			capabilities.setBrowserName("firefox");
			System.out.println("##### Testcase execution started on Firefox #####");
		} else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
			capabilities.setBrowserName("MicrosoftEdge");
			System.out.println("##### Testcase execution started on Edge #####");
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
	}

	@Test
	public void googleOnChromeTest() {
		try {
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			System.out.println("Inside GoogleOnChromeTest");
			System.out.println(driver.getTitle());
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void linkedInOnFirefoxTest() {
		try {
			driver.get("https://www.linkedin.com");
			driver.manage().window().maximize();
			System.out.println("Inside linkedInOnFirefoxTest");
			System.out.println(driver.getTitle());
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void facebookOnEdgeTest() {
		try {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			System.out.println("Inside facebookOnEdgeTest");
			System.out.println(driver.getTitle());
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void facebookOnChromeTest() {
		try {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			System.out.println("Inside facebookOnChromeTest");
			System.out.println(driver.getTitle());
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("##### Browser closed #####");
		}
	}
}
