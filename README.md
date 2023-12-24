# Better IMDB Tests

Better IMDB is an online movie database website that I worked on with a team during my coding bootcamp at Grand Circus. Better IMDB is simple to use website that showcases upcoming movies, trending movies, etc, as well as the information on all of the movies. The website also has functionality for searching for movies and discovering new movies by various criteria.

This repository contains a Java program I developed to perform various tests on the website using the Selenium framework. 

Live website: https://simonorow.github.io/better-imdb/

Original GitHub repository: https://github.com/wongmatt93/group-project-2


## Configuration

As of Chrome 115+ (July 2023), there is a new endpoint to obtain the latest chrome driver (Chrome for Testing). Instead of a driver, Google has recently created Chrome for Testing, a new flavor of Chrome specifically targeted for testing. This project utilizes the latest Selenium framework for Java as well the new Chrome for Testing application.

Below are the versions of the maven dependencies used in this project:
|Dependency|Version  |
|--|--|
| Selenium | 4.16.1 |
| WebDriverManager | 5.6.2 |

Both versions above are the latest as of December 24, 2023.

Up-to-date versions of Selenium and WebDriverManager are needed to support the new Chrome for Testing tool and the proper endpoints.

Sources:

https://stackoverflow.com/questions/76911590/could-not-start-a-new-session-response-code-500-message-session-not-created

https://developer.chrome.com/blog/chrome-for-testing
