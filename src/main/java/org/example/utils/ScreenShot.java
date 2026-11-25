package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {

    public static String getCurrentDateTime() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        Parameters.DATE_FORMAT
                );

        return LocalDateTime.now().format(formatter);
    }

    public static Path createFolder(String scenarioName)
            throws IOException {

        String safeName = scenarioName
                .replaceAll("[^\\p{L}\\p{N} _-]", "_");

        Path folder = Path.of(
                System.getProperty("user.dir"),
                Parameters.EVIDENCE_PATH,
                getCurrentDateTime() + "_" + safeName
        );

        Files.createDirectories(folder);

        return folder;
    }

    public static String captureScreenshot(
            WebDriver driver,
            Path folder,
            String screenName) throws IOException {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Path destination = folder.resolve(
                "evidencia_"
                        + getCurrentDateTime()
                        + "_"
                        + screenName
                        + ".png"
        );

        FileHandler.copy(
                source,
                destination.toFile()
        );

        return destination.toString();
    }
}
