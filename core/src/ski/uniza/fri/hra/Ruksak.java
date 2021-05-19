package ski.uniza.fri.hra;

import ski.uniza.fri.predmety.IPredmet;

import java.util.ArrayList;

/**
 * Trieda Ruksak sluzi ako hracov inventar. Nesie si v nom vsetky predmety, pricom ako kazdy ruksak ma svoju nosnost.
 *
 * @author  Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Ruksak {

    //----------------------------
    // Atribúty pre triedu Ruksak
    //----------------------------

    private Postava postava;
    private static final int KAPACITA = 10; // v ruksaku moze by t najviac 10 predmetov
    private int aktualnyPocetPredmetovVRuksaku = 0;
    private final ArrayList<IPredmet> predmety = new ArrayList<>();

    /**
     * (Ruksak) konštruktor triedy Ruksak.
     * @param postava
     */
    public Ruksak(Postava postava) {
        this.postava = postava;
    }

    /**
     * (Ruksak) Getter na aktuálny počet predmetov v ruksaku. ----Treba?
     * @return
     */
    public int getAktualnyPocetPredmetovVRuksaku() {
        return aktualnyPocetPredmetovVRuksaku;
    }

    /**
     * (Ruksak) Pridáva do virtuálneho ruksaku predmety. Kontroluje, či sa vôbec nejaký predmet pridáva a áno, tak skontoroluje, či sa dá použiť.
     * ak sa presiahne kapacita ruksaku, predmet sa nepridá.
     * @param predmet
     */
    public void pridajDoRuksaku(IPredmet predmet) {
        predmet = this.postava.getAktualnaLokalita().vezmiPredmet(predmet.toString());
        try {
            if(predmet.daSaPouzit()) {
                if (aktualnyPocetPredmetovVRuksaku != KAPACITA) {
                    this.predmety.add(predmet);
                    aktualnyPocetPredmetovVRuksaku++;
                    System.out.println("------som pridal do ruksakuuu-------");
                } else {
                    System.out.println("Ruksak je plny. Nepodarilo sa pridať predmet.");
                }
            } else {
                System.out.println("Nedá sa použiť.");
            }
        } catch (NullPointerException e) {
            System.out.println("Tento predmet v danej lokalite neexistuje. ");
        }
    }

    //ošetriť + vykreslenie
    public IPredmet vyberZRuksaku(IPredmet predmet){
        for (IPredmet iPredmet : this.predmety) {
            if (predmet != null) {
                this.predmety.remove(predmet);
                this.postava.getAktualnaLokalita().vlozPredmetDoLokality(predmet);
                return iPredmet;
            }
        } return null;
    }

    public void vypisVsetkyPredmetyVRuksaku() {
        System.out.println("Predmety, ktoré máš práve v ruksaku: ");

        for (IPredmet predmet : this.predmety) {
            System.out.println("Predmety, ktoré máš aktuálne v ruksaku: " + predmet.dajNazov());

        }
    }

    public boolean jePlny (IPredmet predmet) {
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
