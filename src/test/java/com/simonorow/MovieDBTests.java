package com.simonorow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MovieDBTests extends BaseTests {
	 

    @Test
    public void isPageRendered() {
        Assert.assertTrue(driver.getPageSource().contains("Trending Movies"));
    }
    

    @Test
    public void AtLeastOneMoviePresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("MovieCard")));
        Assert.assertTrue(elements.size() > 0);
    }
    
}
