package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Trieda Kokos vytvára inštancie kokosov, ktoré bude možné nájsť na ostrove a hráč s nimi bude môcť manipulovať.
 * Dávajú mu potrebnú energiu na prežite. Vedia sa vykresliť a majú svoje pozície.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Kokos extends Jedlo {

    //--------------------
    // Atribúty pre Kokos
    //--------------------

    private String nazov;
    private Sprite kokosTexture;

    /**
     * (Kokos) Parametrický konštuktor, ktorý si inicializuje parametre na vykreslenie a energiu, ak ide o potravinu
     *
     * @param kokosTexture
     * @param x
     * @param y
     * @param width
     * @param height
     * @param nazov
     * @param energy
     */
    public Kokos(Sprite kokosTexture, int x, int y, int width, int height, String nazov, int energy) {
        super(x, y, 50, 50, "Kokos", 50); // toto prioritne určuje kde sa vykreslí kokos.
        this.kokosTexture = kokosTexture;
        this.nazov = nazov;
    }

    //-------------------------------
    // Zdedené metódy z triedy Jedlo
    //-------------------------------

    @Override
    public String dajNazov() {
        return this.nazov;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return false;
    }

    @Override
    public void daSaPouzit(boolean daSaPouzit) {
        super.daSaPouzit(daSaPouzit);
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
        super.vypisStavPredmetu();
        //System.out.println("Kokos. Tvrdý.");
    }

    @Override //chce FLOAAT!!
    public void draw(SpriteBatch batch) {
        batch.draw(this.kokosTexture, (float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight());
        System.out.println("(Kokos) Nakreslil som sa.");
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return super.jeVRuksaku(trueFalse);
    }

}
