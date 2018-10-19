package com.qa;




	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

public class JenkinsWebElementsForConfigure {
		public WebElement element = null;

		//initial login page
		public WebElement getConfgure(WebDriver driver)
		{
			 element =  driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]"));
			 return element;
		}
		public WebElement getFullName(WebDriver driver)
		{
			 element =  driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input"));
			 return element;
		}
		public WebElement getSave(WebDriver driver)
		{
			 element =  driver.findElement(By.id("yui-gen2-button"));
			 return element;
		}
		public WebElement getFullNameBanner(WebDriver driver)
		{
			 element =  driver.findElement(By.xpath("//*[@id=\"main-panel\"]/h1"));
			 return element;
		}

}
