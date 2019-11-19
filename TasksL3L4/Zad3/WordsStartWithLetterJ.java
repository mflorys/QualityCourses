package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Set;

/*
 * Zad.3.
 * Stwórz program, który otworzy stronę www.onet.pl, znajdzie wszystkie wyrazy zaczynające się na literę "j" (case insensitive!)
 * i wypisze je na ekranie. Skorzystaj z takiej kolekcji, która zagwarantuje unikalność elementów.
 * */

public class WordsStartWithLetterJ {

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
        driver.get("http://www.onet.pl");
        WebElement body = driver.findElement(By.tagName("body"));
        int countWordsOccurances = 0;
        Set<String> wordsList = new HashSet<String>();

        String text = body.getText();
        String[] words = text.split("[\\s.,!?\"]");

        for (String word : words
        ) {
            if (word.length() > 1 && (word.charAt(0) == 'j' || word.charAt(0) == 'J')) {
                word = word.toLowerCase();
                wordsList.add(word);
                countWordsOccurances++;
            }
        }

        System.out.println("Lista występujących słów: " + wordsList);
        System.out.println("Liczba występujących słów: " + wordsList.size());
        System.out.println("Liczba wystąpień: " + countWordsOccurances);
    }
}
