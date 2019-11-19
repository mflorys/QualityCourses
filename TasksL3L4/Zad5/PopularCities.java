package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/*
 * Zad.5.
 * Stórz mapę {String, Integer} i zainicjuj klucze nazwami 10 popularnych miast polskich. Następnie napisz program, który wyszuka każde miasto w google i zapisze obok miasta wartość równią liczbie trafień w Google.
 * Następnie wyświetl na konsoli zestawienie:
 * NazwaMiasta1 - liczbaTrafień
 * NazwaMiasta2 - liczbaTrafień
 * .
 * .
 *   NazwaMiasta10 - liczbaTrafień
 */

public class PopularCities {

    WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void test() {

        driver.get("https://www.google.com");
        WebElement search;
        WebElement resultStats;

        String[] city = {"Warszawa", "Kraków", "Gdańsk", "Wrocław", "Poznań", "Katowice", "Łódź", "Białystok", "Szczecin", "Zakopane"};
        Map<String, Integer> cities = new HashMap<String, Integer>();
        String result;
        int resultNum = 0;

        for (int i = 0; i < city.length; i++) {
            search = driver.findElement(By.name("q"));
            search.sendKeys(city[i]);
            search.submit();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));
            driver.navigate().refresh();
            resultStats = driver.findElement(By.xpath("//div[@id = 'resultStats']"));
            result = resultStats.getText();
            result = result.substring(6, result.indexOf("wyników")).replaceAll(" ", "");
            resultNum = Integer.parseInt(result);
            cities.put(city[i], resultNum);
            driver.navigate().back();
        }
        System.out.println(cities);
    }
}
