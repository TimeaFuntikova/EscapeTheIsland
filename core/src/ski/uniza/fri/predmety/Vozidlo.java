package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

/**
 * Abstraktná trieda vozidlo slúži na posun informácii lodi, ktorá sa bude vykreslovať a dediť informácie z tejto triedy
 *
 * @author Timea Funtíková
 * @version 1.0 (19.5.2021)
 */
public abstract class Vozidlo implements IPredmet {

    //----------------------
    // Atribúty pre Vozidlo
    //----------------------

    private int x;
    private int y;
    private int width;
    private int height;
    private String nazov;
    private VykreslovacPredmetov vykreslovacPredmetov;


    /**
     * (Vozidlo) Parametricky konstruktor triedy vozidlo, iniciazuje názov vozidla.
     *
     */
    public Vozidlo(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vykreslovacPredmetov = new VykreslovacPredmetov();
    }

    //getter na atribút
    public String getNazov() {
        return this.nazov;
    }

    //-----------------------------------
    // Zdedené metódy z triedy IPredmet
    //-----------------------------------

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
        return this.nazov;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return false;
    }

    public void daSaPouzit(boolean daSaPouzit) {
    }

    @Override
    public boolean daSaPouzit() {
        return true;
    }

    @Override
    public boolean nastalaKolizia() {
        return false;
    }

    @Override
    public void nastalaKolizia(boolean nastalaKolizia) {

    }

    @Override
    public void vypisStavPredmetu() {}

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
