package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private Sprite texturaBoat;

    /**
     * (Lod) Parametrický konstruktor kde sa inicialitujú potrebné parametre na vykreslenie lode.
     * @param nazov
     */
    public Lod (Sprite texturkaLode, int x, int y, int width, int height, String nazov) {
        super(x, y, 35,35);
        this.texturaBoat = texturkaLode;
        this.nazovVozidla = nazovVozidla;
    }

    //---------------------------------
    // Zdedené metódy z triedy Vozidlo
    //---------------------------------

    @Override
    public String getNazov() {
        return this.nazovVozidla;
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
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
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
    public boolean daSaPouzit(boolean daSaPouzit) {
        return true;
    }
    @Override
    public boolean nastalaKolizia() {
        return super.nastalaKolizia();
    }


    @Override
    public void nastalaKolizia(boolean nastalaKolizia) {

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

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return false;
    }
}
