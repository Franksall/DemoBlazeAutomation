package org.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.example.utils.ScreenShot;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.nio.file.Path;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PreAndProsCondition {

    private Path evidenceFolder;
    private int stepNumber;

    @Before
    public void beforeScenario(Scenario scenario) {

        stepNumber = 0;

        try {

            evidenceFolder = ScreenShot.createFolder(
                    scenario.getName()
            );

        } catch (IOException e) {

            System.err.println(
                    "Error al crear carpeta de evidencias: "
                            + e.getMessage()
            );
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        stepNumber++;

        if (evidenceFolder == null) {
            return;
        }

        try {

            WebDriver driver = getDriver();

            if (alertIsPresent(driver)) {
                System.out.println(
                        "Captura omitida: alerta JavaScript activa"
                );
                return;
            }

            String status = scenario.isFailed()
                    ? "_Failed"
                    : "";

            String screenshot = ScreenShot.captureScreenshot(
                    driver,
                    evidenceFolder,
                    "Paso" + stepNumber + status
            );

            System.out.println(
                    "Evidencia guardada: " + screenshot
            );

        } catch (IOException | WebDriverException e) {

            System.err.println(
                    "Error al capturar evidencia: "
                            + e.getMessage()
            );
        }
    }

    private boolean alertIsPresent(WebDriver driver) {

        try {

            driver.switchTo().alert();

            return true;

        } catch (NoAlertPresentException e) {

            return false;
        }
    }
}
