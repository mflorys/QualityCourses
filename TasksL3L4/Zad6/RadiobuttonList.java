package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


/*
 * Zad.6.
 * Stwórz program, który wejdzie na stronę http://qualitycourses.pl/boxes.html, załaduje do List<WebElement> wszystkie radiobuttony z grupy gender, zaznaczy opcję "Other"
 * i sprawdzi asercjami czy stan wszystkich trzech się zgadza. Następnie sprawdzi, czy po kliknięciu Submit response code to 404.
 */

public class RadiobuttonList {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void test() {
        driver.get("http://www.qualitycourses.pl/boxes.html");
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type='radio'][name='gender']"));
        radios.get(2).click();

        Assertions.assertFalse(radios.get(0).isSelected());
        Assertions.assertFalse(radios.get(1).isSelected());
        Assertions.assertTrue(radios.get(2).isSelected());

        WebElement submit = driver.findElement(By.cssSelector("input[type='submit'"));
        submit.submit();

        Assertions.assertTrue(driver.getTitle().contains("404"));
    }
}
