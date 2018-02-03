package com.selenium;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/maddy/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://naukri.com");
		
		String parentWindowId=driver.getWindowHandle();
		System.out.println("This is Parent Window Id "+parentWindowId);
		System.out.println("This is Parent Window Title "+driver.getTitle());
		
		Set<String> windowPopUp= driver.getWindowHandles();
		Iterator<String> it=windowPopUp.iterator();

		while(it.hasNext()) {
			
			String childWindowId=it.next();
			
			if(!parentWindowId.equals(childWindowId)) {
				driver.switchTo().window(childWindowId);
				System.out.println("This is Child Window Id "+childWindowId);
				System.out.println("This is Child Window Title "+driver.getTitle());
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println("This is Parent Window "+driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
