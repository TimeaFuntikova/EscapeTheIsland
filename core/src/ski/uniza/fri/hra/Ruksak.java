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

    private Ovladanie ovladanie;
    private Postava postava;
    private static final int KAPACITA = 10; // v ruksaku moze by t najviac 10 predmetov
    private int aktualnyPocetPredmetovVRuksaku = 0;
    private HashMap<String, IPredmet> predmety = new HashMap<>();

    /**
     * (Ruksak) konštruktor triedy Ruksak.
     *
     * @param postava
     */
    public Ruksak(Postava postava) {
        this.postava = postava;
        this.postava.aktualizujOvladanie(this.ovladanie);
    }

    /**
     * (Ruksak) Pridáva do virtuálneho ruksaku predmety. Kontroluje, či sa vôbec nejaký predmet pridáva a áno, tak skontoroluje, či sa dá použiť.
     * ak sa presiahne kapacita ruksaku, predmet sa nepridá.
     *
     * @param predmet
     */
    public void pridajDoRuksaku(IPredmet predmet) { // predmet is null
        this.postava.getAktualnaLokalita().vezmiPredmet(predmet);
        try {
            if (predmet.daSaPouzit()) {
                this.predmety.put(predmet.dajNazov(), predmet);
                aktualnyPocetPredmetovVRuksaku++;
                System.out.println("------som pridal do ruksakuuu-------");
            } else if (!jePlny(predmet)) {
                System.out.println("Ruksak je plny. Nepodarilo sa pridať predmet.");
            } else {
                System.out.println("Nedá sa použiť.");
            }
        } catch (
                NullPointerException e) {
            System.out.println("Tento predmet v danej lokalite neexistuje. ");
        }
    }


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

    public void vypisVsetkyPredmetyVRuksaku() {
        for (String s : this.predmety.keySet()) {
            System.out.println("Predmety, ktoré máš aktuálne v ruksaku: " + s);

        }
    }

    public HashMap<String, IPredmet> dajPredmetyVRuksakuObjektovo() {
        for (String s : this.predmety.keySet()) {
            System.out.println("Predmety, ktoré máš aktuálne v ruksaku: " + s.toString());

        }
        return this.predmety;
    }

    public boolean jePlny(IPredmet predmet) {
        if (predmet != null) {
            if (this.aktualnyPocetPredmetovVRuksaku < KAPACITA) {
                this.aktualnyPocetPredmetovVRuksaku++;
                System.out.println("Ešte nie je plný.");
                return false;
            }
        }
        System.out.println("Je plný.");
        return true;
    }
}
