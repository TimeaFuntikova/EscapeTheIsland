package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Trieda Lod predstavuje predmet lode, ktory sa hrác počas hrania hry a zberom predmetov snaží vytovoriť. Akonáhle
 * hráč nazbieral potrebné suroviny a vytvoril loď, hra sa končí a misia opustenia ostrova bola úspešná.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Lod extends Vozidlo {

    //--------------------
    // Atribúty pre Lod
    //--------------------
    private String nazovVozidla;
    private String stav = "Misia bola úspešná.";

    /**
     * (Lod) Parametrický konstruktor kde sa inicialitujú potrebné parametre na vykreslenie lode.
     * @param nazov
     * @param nazovVozidla
     */
    public Lod (String nazov, String nazovVozidla) {
        super(nazov);
        this.nazovVozidla = nazovVozidla;
    }

    //---------------------------------
    // Zdedené metódy z triedy Vozidlo
    //---------------------------------

    @Override
    public String getNazov() {
        return this.nazovVozidla;
    }

    public Lod() {
        super();
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public String dajNazov() {
        return super.dajNazov();
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return true; //signal na ukoncenie hry
    }

    @Override
    public boolean daSaPouzit() {
        return true;
    }

    @Override
    public boolean bolPouzity() {
        return super.bolPouzity();
    }

    @Override
    public void vypisStavPredmetu() {
        System.out.println(stav);
    }


    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        //nakreslit lod a v hre dať použiť aby hra bola ukoncena
    }
}
