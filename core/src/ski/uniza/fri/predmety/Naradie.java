package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Naradie extends Kamen {
    private String nazov;
    private int opotrebenie = 0;
    private static final int MAX_OPOTREBENIE = 100; //v percentach
    private Sprite naradieTexture;


    public Naradie(int x, int y, int width, int height, String nazov, int opotrebenie, Sprite naradieTexture) {
        super(x, y, width, height);
        this.nazov = nazov;
        this.opotrebenie = opotrebenie;
        this.naradieTexture = naradieTexture;
    }


    public Naradie(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public String dajNazov() {
        return this.nazov;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return false;
    }

    /**
     *
     * (Naradie) PO každom použití sa zvýši opotrebenie o 5 bodov. // hodiť do metódy na spracovanie použitia
     * @return
     */
    @Override
    public boolean daSaPouzit(boolean daSaPouzit) {
        if (this.opotrebenie <100 && this.opotrebenie >0) {
            this.opotrebenie += 5;
            return true;
        }
        return false;
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

