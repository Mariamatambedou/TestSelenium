package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test1 {
    public static void main(String[] args) {
        // Chemin du driver Chrome. Assurez-vous d'avoir le bon chemin pour votre système.
        System.setProperty("webdriver.chrome.driver", "E:\\Springboot\\chromedriver.exe");

        // Instanciation du driver Chrome
        WebDriver driver = new ChromeDriver();

        // Ouverture de la page HTML
        driver.get("http://localhost:8000/index.html");
        try {
            Thread.sleep(5000); // Pause de 5 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Remplir le formulaire
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("texte")));


         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("texte")));

        // Correction : Déclarer la variable texteInput
        WebElement texteInput = driver.findElement(By.id("texte"));
        texteInput.sendKeys("Test de sentiment");

        WebElement typeDropdown = driver.findElement(By.id("type"));
        typeDropdown.sendKeys("POSITIF");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@gmail.com");

        WebElement telephoneInput = driver.findElement(By.id("telephone"));
        telephoneInput.sendKeys("123456789");

        // Cliquer sur le bouton "Créer Sentiment"
        WebElement creerButton = driver.findElement(By.xpath("//button[contains(text(),'Créer Sentiment')]"));
        creerButton.click();

        // Attendre quelques secondes pour voir le résultat (facultatif)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fermer le navigateur
        driver.quit();
    }

}
