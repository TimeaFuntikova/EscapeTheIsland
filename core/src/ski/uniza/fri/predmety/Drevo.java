package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Trieda Drevo vytvára inštancie driev, ktoré bude možné nájsť na ostrve a hráč s nimi bude môcť manipulovať.
 * Keď ich bude dostatok, dajú sa použiť na vytvorenie lode. Vedia sa vykresliť a majú svoje pozície.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Drevo extends Predmet {

    //--------------------
    // Atribúty pre Drevo
    //--------------------

    private String nazov;
    private Sprite drevoTexture;

    /**
     * (Drevo) Parametrický konšstruktor triedy Drevo. Inicializuje si zdedene parametre a pre potreby vykreslenia
     * nastaví každej vytvorenej inštancii výšku a šírku na 50 px.
     * @param drevoTexture
     * @param x
     * @param y
     * @param width
     * @param height
     * @param nazov
     */
    public Drevo(Sprite drevoTexture, int x, int y, int width, int height, String nazov) {
        super(x, y,50, 50);
        this.nazov = nazov;
        this.drevoTexture = drevoTexture;
    }

    //---------------------------------
    // Zdedené metódy z triedy Predmety
    //---------------------------------

    @Override
    public String dajNazov() {
        return this.nazov;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return true;
    }


    @Override
    public void daSaPouzit(boolean daSaPouzit) {
       super.daSaPouzit(daSaPouzit);
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
    public void vypisStavPredmetu() {
        super.vypisStavPredmetu();
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(this.drevoTexture, (float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight());
        System.out.println("(Drevo) Nakreslil som sa.");

    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return super.jeVRuksaku(trueFalse);
    }
}
