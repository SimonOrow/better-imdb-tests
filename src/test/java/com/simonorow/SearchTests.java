package com.simonorow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTests extends BaseTests {

    @Test
    public void searchPresent() {
        WebElement searchInput = driver.findElement(new By.ById("inquiry"));
        Assert.assertTrue(searchInput != null);
    }

    @Test
    public void findSpecificMovie() {
        // Aliens vs Predator: Requiem

        String movie = "Aliens vs Predator: Requiem";
        // Enter text in search box and hit return.
        WebElement searchInput = driver.findElement(new By.ById("inquiry"));
        searchInput.sendKeys(movie);
        searchInput.sendKeys(Keys.RETURN);

        // Wait for results to populate.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean isAliensVSPredatorMoviePresent = wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.className("MovieCard")),
                ExpectedConditions.textToBePresentInElementLocated(By.className("MovieCard"), movie)
        ));

        Assert.assertTrue(isAliensVSPredatorMoviePresent);
    }


    @Test
    public void canReturnHomeThroughDiscoverMovies() {

        WebElement button = driver.findElement(By.xpath("//button[text()='" + "Discover Movies" + "']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean trendingMoviesPresent = wait.until(ExpectedConditions.and(
                ExpectedConditions.textToBePresentInElementLocated(new By.ByClassName("Main"), "Trending Movies")
        ));

        Assert.assertTrue(trendingMoviesPresent);
    }
}
