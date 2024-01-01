package com.simonorow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WatchlistTests extends BaseTests {

    @Test
    public void watchlistIsEmpty() {
        List<WebElement> watchlistClasses = driver.findElements(By.className("watchlist"));

        // Click watchlist
        watchlistClasses.get(0).click();

        // Wait for page to load.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean watchlistIsEmpty = wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.className("WatchList")),
                ExpectedConditions.textToBePresentInElementLocated(By.className("WatchList"), "Your watchlist is empty")
        ));

        Assert.assertTrue(watchlistIsEmpty);
    }

    // Depend on the previous method so that we can check for an empty list first.
    // Dependency: Watchlist is clear.
    @Test(dependsOnMethods={"watchlistIsEmpty"})
    public void AddToWatchList_MovieAppearsOnWatchList() {
        // Aliens vs Predator: Requiem


        // Part 1 - Search for movie

        String movie = "Aliens vs Predator: Requiem";
        // Enter text in search box and hit return.
        WebElement searchInput = driver.findElement(new By.ById("inquiry"));
        searchInput.sendKeys(movie);
        searchInput.sendKeys(Keys.RETURN);

        // Wait for results to populate.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.className("MovieCard")),
                ExpectedConditions.textToBePresentInElementLocated(By.className("MovieCard"), movie)
        ));

        // Part 2 - Add movie to watchlist

        List<WebElement> watchlistStarButtons = driver.findElements(By.className("fa-star"));
        watchlistStarButtons.get(0).click();


        // Part 3 - Check watchlist

        // click watchlist
        List<WebElement> watchlistClasses = driver.findElements(By.className("watchlist"));
        watchlistClasses.get(0).click();

        // Check if Aliens vs Predator movie present and double check we're on watchlist page.
        // Wait for results to populate.
        Boolean isAliensVSPredatorMoviePresentOnWatchlist = wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.className("MovieCard")),
                ExpectedConditions.textToBePresentInElementLocated(By.className("MovieCard"), movie),
                ExpectedConditions.textToBePresentInElementLocated(By.className("WatchList"), "Your Watchlist")
        ));

        Assert.assertTrue(isAliensVSPredatorMoviePresentOnWatchlist);
    }
}
