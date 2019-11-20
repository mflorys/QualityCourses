package com.company;

public class Dog {
    private String rasa;
    private String imie;
    private int wiek;
    private int waga;
    private int agresja;
    private int zwinnosc;
    private int punktyZycia;
    private String plec;

    public Dog(String rasa, String imie, int wiek, int waga, int agresja, int zwinnosc, int punktyZycia) {
        this.rasa = rasa;
        this.imie = imie;
        this.wiek = wiek;
        this.waga = waga;
        this.agresja = agresja;
        this.zwinnosc = zwinnosc;
        this.punktyZycia = punktyZycia;
    }

    public Dog(String rasa, String imie, int wiek, int waga, int agresja, int zwinnosc, int punktyZycia, String plec) {
        this.rasa = rasa;
        this.imie = imie;
        this.wiek = wiek;
        this.waga = waga;
        this.agresja = agresja;
        this.zwinnosc = zwinnosc;
        this.punktyZycia = punktyZycia;
        this.plec = plec;
    }

    public String getRasa() {
        return rasa;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public int getWaga() {
        return waga;
    }

    public int getAgresja() {
        return agresja;
    }

    public int getZwinnosc() {
        return zwinnosc;
    }

    public int getPunktyZycia() {
        return punktyZycia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPunktyZycia(int punktyZycia) {
        this.punktyZycia = punktyZycia;
    }

    public int atak() {
        int atak = (agresja + zwinnosc + punktyZycia + waga) / wiek;
        if (plec.equals("suka")) {
            return atak - 3;
        } else {
            return atak;
        }
    }

    public int unik() {
        int unik = (zwinnosc + punktyZycia) - (wiek + waga);
        if (unik >= 0) {
            if (plec.equals("suka")) {
                return unik + 4;
            } else {
                return unik;
            }
        } else {
            return 0;
        }
    }
}
