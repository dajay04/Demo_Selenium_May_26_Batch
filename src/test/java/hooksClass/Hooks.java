package hooksClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;

public class Hooks {
    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();


    @Before
    public void setUp() {

        WebDriver webDriver = createDriver("chrome");

        driver.set(webDriver);

        System.out.println(
                "Browser started on Thread: "
                        + Thread.currentThread().getId()
        );
    }


    @After
    public void tearDown(Scenario scenario) {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {

            if (scenario.isFailed()) {
                takeScreenshot(scenario);
            }

            webDriver.quit();

            driver.remove();
        }

        System.out.println(
                "Browser closed on Thread: "
                        + Thread.currentThread().getId()
        );
    }


    private WebDriver createDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                webDriver =
                        new ChromeDriver(chromeOptions);

                break;


            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions =
                        new FirefoxOptions();

                webDriver =
                        new FirefoxDriver(firefoxOptions);

                break;


            default:

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }


        webDriver.manage()
                .window()
                .maximize();

        webDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        return webDriver;
    }


    private void takeScreenshot(Scenario scenario) {

        try {

            String screenshotDir =
                    System.getProperty("user.dir")
                            + "/reports/screenshots/";

            File directory =
                    new File(screenshotDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }


            String scenarioName =
                    scenario.getName()
                            .replaceAll(
                                    "[^a-zA-Z0-9.-]",
                                    "_"
                            );

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss"
                    ).format(new Date());


            String fileName =
                    scenarioName
                            + "_"
                            + timestamp
                            + ".png";


            String filePath =
                    screenshotDir + fileName;


            WebDriver webDriver = driver.get();


            byte[] screenshot =
                    ((TakesScreenshot) webDriver)
                            .getScreenshotAs(
                                    OutputType.BYTES
                            );


            Files.write(
                    Paths.get(filePath),
                    screenshot
            );


            scenario.attach(
                    screenshot,
                    "image/png",
                    fileName
            );


            System.out.println(
                    "Screenshot captured: "
                            + filePath
            );

        } catch (Exception e) {

            System.out.println(
                    "Failed to capture screenshot: "
                            + e.getMessage()
            );
        }
    }


    public static WebDriver getDriver() {

        return driver.get();
    }
}
