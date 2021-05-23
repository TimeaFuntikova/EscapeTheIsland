package ski.uniza.fri.predmety;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Abstraktná trieda Jedlo sluzi na zdedenie metód od triedy Potraviny. Inštanciam tym mozno prideliť energiu
 * a pozicie na vykreslenie cez paramatre.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public abstract class Jedlo extends Potraviny {

    //--------------------
    // Atribúty pre Jedlo
    //--------------------

    private String nazov;

    /**
     * (Jedlo) Končtruktor na inicializáciu parametrov.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param nazov
     * @param energy
     */
    public Jedlo(int x, int y, int width, int height, String nazov, int energy) {
        super(x, y, width, height, energy);
        this.nazov = nazov;
    }

    //----------------------------------
    // Zdedené metódy z triedy Potraviny
    //----------------------------------

    @Override
    public String dajNazov() {
        return super.dajNazov();
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return super.sluziNaOdplavenie();
    }

    public boolean daSaPouzit(boolean daSaPouzit) {
        return super.daSaPouzit(daSaPouzit);
    }

    @Override
    public boolean daSaPouzit() {
        return true;
    }

    @Override
    public boolean nastalaKolizia() {
        return super.nastalaKolizia();
    }

    @Override
    public void nastalaKolizia(boolean nastalaKolizia) {}

    @Override
    public void vypisStavPredmetu() {
        super.vypisStavPredmetu();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return true;
    }
}
