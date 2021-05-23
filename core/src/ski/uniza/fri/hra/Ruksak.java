package ski.uniza.fri.hra;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.predmety.Kokos;
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
    private static final int KAPACITA = 10; // v ruksaku moze byt najviac 10 predmetov
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
     * (Ruksak) Pridáva do virtuálneho ruksaku predmety. Kontroluje, či sa vôbec nejaký predmet pridáva a áno, tak skontoroluje, o aku inštanciu ide.
     * Ak je to kokos, pridá energiu, ak drevo, pridá skóre.
     *
     * @param predmet
     */
    public void pridajDoRuksaku(IPredmet predmet) { //urobí sa toto len raz...
        try {
            //pridaj predmet do kontajnera.
            //navys pocet predmetov v kontajneri o 1
            //osetri ak je kontajner plny --> hashmap
            //hashmap lebo chcem pri vypise na herne okno Stringovu reprezentu

            if (predmet != null) {
                this.predmetyVRuksaku.put(predmet.dajNazov(), predmet);
                aktualnyPocetPredmetovVRuksaku++;
                predmet.jeVRuksaku(true);
                if(!(predmet instanceof Kokos)) {
                    this.postava.setSkore(10);
                }
                if(predmet instanceof Kokos) {
                    this.postava.setEnergy(10);
                }
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

    public HashMap<String, IPredmet> dajZoznamPredmetovVRuksaku() {
        return this.predmetyVRuksaku;
    }

    /**
     *(Ruksak) Metoda na zistovnie stavu ruksaku.
     * @return
     */
    public boolean jePlny() {
        if (this.aktualnyPocetPredmetovVRuksaku < KAPACITA) {
            this.aktualnyPocetPredmetovVRuksaku++;
            System.out.println("Ešte nie je plný.");
            return false;
        }
        System.out.println("Je plný.");
        return true;
    }

    /**
     * (Ruksak) Ak sa dosiahne potrebne skore, vykresli sa lod.
     * @return
     */
    public boolean postavitLod() {
        if (this.postava.getSkore() >= 50 && this.postava.getSkore() < 60) {
            System.out.println("lod bola Vytvorenaaaa----------------------------------");
            this.postava.setSkore(10);
            return true;
        } return false;
    }
}
