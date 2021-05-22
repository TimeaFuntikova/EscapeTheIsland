package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Abstraktná trieda vozidlo slúži na posun informácii lodi, ktorá sa bude vykreslovať a dediť informácie z tejto triedy
 *
 * @author Timea Funtíková
 * @version 1.0 (19.5.2021)
 */
public abstract class Vozidlo implements  IPredmet {

    //--------------------
    // Atribúty pre Voda
    //--------------------

    private String nazov;

    /**
     * (Vozidlo) Parametricky konstruktor triedy vozidlo, iniciazuje názov vozidla.
     * @param nazov
     */
    public Vozidlo(String nazov) {
        this.nazov = nazov;
    }

    /**
     * (Vozidlo) Bezparametricky konstruktor triedy vozidlo
     */
    public Vozidlo() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //getter na atribút názvu

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

    public boolean daSaPouzit(boolean daSaPouzit) {
        return true;
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
}
