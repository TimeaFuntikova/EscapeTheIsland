package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kamen extends Predmet {

    private String nazov;
    private Sprite kamiencokyy;

    /**
     * (Kamen) Konštruktor pre triedu Kamen, kde sa inicializujú zdenene parametre na vykreslenie pozície.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Kamen(Sprite texturka, int x, int y, int width, int height, String nazov) {
        super(x, y, 35, 35);
        this.kamiencokyy = texturka;
        this.nazov = nazov;
    }

    //---------------------------------
    // Zdedené metódy z triedy Predmet
    //---------------------------------

    @Override
    public String dajNazov() {
        return super.dajNazov();
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return super.sluziNaOdplavenie();
    }
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
        super.draw(batch);
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return super.jeVRuksaku(trueFalse);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }
}
