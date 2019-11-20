package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Fight {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        Dog[] dogs = new Dog[2];

        String[] rasy = {"Owczarek", "Buldog", "Labrador", "Mops", "Chihuahua", "Pudel"};
        String[] imiona = {"Burek", "Azor", "Max", "Jackie", "Reksio"};
        String[] plecTab = {"pies", "suka"};

        //dogs[0] = new Dog("Owczarek", "Burek", 2, 12, 3, 7, 90, "pies");
        //dogs[1] = new Dog("Owczarek", "Azor", 4, 32, 4, 6, 70, "pies");

        System.out.println("1.Wygeneruj atrybuty");
        System.out.println("2.Wprowadź atrybuty");
        int wybor = Integer.parseInt(bufferedReader.readLine());

        switch (wybor) {
            case 1:
                for (int i = 0; i < dogs.length; i++) {
                    dogs[i] = new Dog(
                            rasy[random.nextInt(rasy.length)],
                            imiona[random.nextInt(imiona.length)],
                            random.nextInt(5) + 1,
                            random.nextInt(60) + 1,
                            random.nextInt(11),
                            random.nextInt(11),
                            random.nextInt(40) + 60,
                            plecTab[random.nextInt(plecTab.length)]
                    );
                    System.out.println(dogs[i].getImie()
                            + " (wiek: " + dogs[i].getWiek()
                            + ", waga: " + dogs[i].getWaga()
                            + ", agresja: " + dogs[i].getAgresja()
                            + ", zwinnosc: " + dogs[i].getZwinnosc()
                            + ", punkty zycia: " + dogs[i].getPunktyZycia()
                            + ", " + dogs[i].getPlec()
                            + ")");
                }
                break;
            case 2:
                for (int i = 0; i < dogs.length; i++) {
                    System.out.print("Rasa: ");
                    String rasa = bufferedReader.readLine();
                    System.out.print("Imie: ");
                    String imie = bufferedReader.readLine();
                    System.out.print("Wiek: ");
                    int wiek = Integer.parseInt(bufferedReader.readLine());
                    System.out.print("Waga: ");
                    int waga = Integer.parseInt(bufferedReader.readLine());
                    System.out.print("Agresja: ");
                    int agresja = Integer.parseInt(bufferedReader.readLine());
                    System.out.print("Zwinnosc: ");
                    int zwinnosc = Integer.parseInt(bufferedReader.readLine());
                    System.out.print("Punkty zycia: ");
                    int punktyZycia = Integer.parseInt(bufferedReader.readLine());
                    System.out.print("Plec: ");
                    String plec = bufferedReader.readLine();

                    dogs[i] = new Dog(rasa, imie, wiek, waga, agresja, zwinnosc, punktyZycia, plec);

                    System.out.println(dogs[i].getImie()
                            + " (wiek: " + dogs[i].getWiek()
                            + ", waga: " + dogs[i].getWaga()
                            + ", agresja: " + dogs[i].getAgresja()
                            + ", zwinnosc: " + dogs[i].getZwinnosc()
                            + ", punkty zycia: " + dogs[i].getPunktyZycia()
                            + ", " + dogs[i].getPlec()
                            + ")");
                }
                break;
            default:
                System.out.println("koniec gry");
        }

        int iloscAtakow = 0;
        int maxAtakow = 10;
        int atakuje, broniSie;

        atakuje = random.nextInt(dogs.length);
        if (atakuje == 1) {
            broniSie = 0;
        } else {
            broniSie = 1;
        }

        while (iloscAtakow < maxAtakow) {
            int pktZyciaPoAtaku = 0;
            int atakujacy = atakuje;
            int broniacy = broniSie;

            System.out.println("Atakuje: " + dogs[atakuje].getImie());
            System.out.println("Moc ataku wynosi: " + dogs[atakuje].atak());
            System.out.println("Moc uniku wynosi: " + dogs[atakuje].unik());

            if (dogs[broniSie].unik() > dogs[atakuje].atak()) {
                System.out.println(dogs[broniSie].getImie() + " uniknął ataku");
            } else {
                pktZyciaPoAtaku = dogs[broniSie].getPunktyZycia() - dogs[atakuje].atak();
                if (pktZyciaPoAtaku < 0) {
                    pktZyciaPoAtaku = 0;
                }
                dogs[broniSie].setPunktyZycia(pktZyciaPoAtaku);
                System.out.println(dogs[broniSie].getImie() + " otrzymał cios, zostało mu " + pktZyciaPoAtaku + " punktow zycia");
            }

            if (dogs[broniSie].getPunktyZycia() <= 0) {
                System.out.println(dogs[broniSie].getImie() + " otrzymał śmiertelny cios i zdechł");
                break;
            } else if (iloscAtakow == maxAtakow - 1) {
                System.out.println(dogs[atakuje].getImie() + " odpuszcza i wraca do budy");
                System.out.println(dogs[broniSie].getImie() + " odpuszcza i wraca do budy");
            } else {
                atakuje = broniacy;
                broniSie = atakujacy;
            }

            iloscAtakow++;


        }
    }
}
