package homework34;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
* Zad.2.
* Stwórz program, który będzie dodawał do listy wprowadzone w konsoli imiona, a po wprowadzeniu tekstu "koniec" wypisze wszystkie imiona alfabetycznie.
* */

public class AddNameToTheList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> imiona = new LinkedList<>(); //ArrayList would be faster here, read about the differences; then => Collections.sort(imiona);
        String koniec = "koniec"; 
        String imie = "";

        while (true) {
            imie = scanner.nextLine();
            if (!imie.equals(koniec)) {
                imiona.add(imie);
                System.out.println("dodane: " + imiona);
            } else {
                imiona.sort(Comparator.naturalOrder());
                System.out.println(imiona);
                break;
            }
        }
    }
}
