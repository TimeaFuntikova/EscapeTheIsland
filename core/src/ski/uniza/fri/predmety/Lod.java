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
    private Sprite lodTexture;

    /**
     * (Lod) Parametrický konstruktor kde sa inicialitujú potrebné parametre na vykreslenie lode.
     *
     * @param nazov
     */
    public Lod(Sprite texturkaLode, int x, int y, int width, int height, String nazov) {
        super(x, y, 40, 40, "Lodka");
        this.lodTexture = texturkaLode;
        this.nazovVozidla = nazov;
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
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
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
    public void daSaPouzit(boolean daSaPouzit) {
    }

    @Override
    public boolean daSaPouzit() {
        return super.daSaPouzit();
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
            batch.draw(this.lodTexture, (float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight());
            System.out.println("(Lodka) Nakreslila som sa.");
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return false;
    }
}
