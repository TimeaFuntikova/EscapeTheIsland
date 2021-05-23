package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Trieda Voda vytvára inštancie vody, ktoré bude možné nájsť na ostrve a hráč s nimi bude môcť manipulovať.
 * Dávajú mu potrebnú energiu na prežite. Vedia sa vykresliť a majú svoje pozície.
 *
 * @author Timea Funtíková
 * @version 1.0 (12.4.2021)
 */
public class Voda extends Potraviny {

    //--------------------
    // Atribúty pre Voda
    //--------------------

    private String nazov;

    /**
     * (Voda) Parametrický konštruktor triedy Voda na inicializáciu parametrov pozícií, názvu a energie
     * @param x
     * @param y
     * @param width
     * @param height
     * @param nazov
     * @param energy
     */
    public Voda(int x, int y, int width, int height, String nazov, int energy) {
        super(x, y, width, height, energy);
        this.nazov = nazov;
    }

    //-----------------------------------
    // Zdedené metódy z triedy Potraviny
    //-----------------------------------

    @Override
    public String dajNazov() {
        return this.nazov;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return false;
    }

    @Override
    public boolean daSaPouzit(boolean daSaPouzit) {
        return true;
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
    public void nastalaKolizia(boolean nastalaKolizia) {

    }

    @Override
    public void vypisStavPredmetu() {
        System.out.println("Obyčajná voda.");
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return false;
    }


}
