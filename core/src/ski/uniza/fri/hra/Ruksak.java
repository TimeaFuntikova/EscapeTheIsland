package ski.uniza.fri.hra;

import ski.uniza.fri.predmety.IPredmet;

import java.util.HashMap;

/**
 * Trieda Ruksak sluzi ako hracov inventar. Nesie si v nom vsetky predmety, pricom ako kazdy ruksak ma svoju nosnost.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Ruksak {

    //----------------------------
    // Atribúty pre triedu Ruksak
    //----------------------------

    private Postava postava;
    private static final int KAPACITA = 10; // v ruksaku moze by t najviac 10 predmetov
    private int aktualnyPocetPredmetovVRuksaku = 0;
    private HashMap<String, IPredmet> predmetyVRuksaku = new HashMap<>();


    /**
     * (Ruksak) konštruktor triedy Ruksak.
     *
     * @param postava
     */
    public Ruksak(Postava postava) {
        this.postava = postava;
    }

    /**
     * (Ruksak) Pridáva do virtuálneho ruksaku predmety. Kontroluje, či sa vôbec nejaký predmet pridáva a áno, tak skontoroluje, či sa dá použiť.
     * ak sa presiahne kapacita ruksaku, predmet sa nepridá.
     *
     * @param predmet
     */
    public void pridajDoRuksaku(IPredmet predmet) {
        try {
            //pridaj predmet do kontajnera.
            //navys pocet predmetov v kontajneri o 1
            //osetri ak je kontajner plny --> hashmap alebo arrazlist, pole radšej nie
            //hashmap lebo chcem pri vpise na herne okno Stringovu reprezentu
            if (predmet != null) {
                this.postava.setSkore(10);
                this.predmetyVRuksaku.put(predmet.dajNazov(), predmet);
                aktualnyPocetPredmetovVRuksaku++;
                System.out.println("------som pridal do ruksakuuu-------");
            } else if (jePlny()) {
                System.out.println("Ruksak je plny. Nepodarilo sa pridať predmet.");
            } else {
                System.out.println("Nedá sa použiť.");
            }
        } catch (NullPointerException e) { //toto by sa ikdy nemalo stať, inak by program padol už dávno predtým .
            System.out.println("Tento predmet v danej lokalite neexistuje. ");
        }
    }

/*
    //ošetriť + vykreslenie
    public IPredmet vyberZRuksaku(IPredmet predmet) {
        for (IPredmet iPredmet : this.predmety.values()) {
            if (predmet != null) {
                this.predmety.remove(predmet);
                this.postava.getAktualnaLokalita().vlozPredmetDoLokality(predmet);
                return iPredmet;
            }
        }
        return null;
    }
 */
 /*
    public String dajPredmetyVRuksaku() {
        for (String s : this.predmetyVRuksaku.keySet()) {
            System.out.println("Predmety, ktoré máš aktuálne v ruksaku: " + s);
            return s;
        }
        return null;
    }

  */

    public HashMap<String, IPredmet> dajZoznamPredmetovVRuksaku() {
        return this.predmetyVRuksaku;
    }

    public boolean jePlny() {
        if (this.aktualnyPocetPredmetovVRuksaku < KAPACITA) {
            this.aktualnyPocetPredmetovVRuksaku++;
            System.out.println("Ešte nie je plný.");
            return false;
        }
        System.out.println("Je plný.");
        return true;
    }
}
