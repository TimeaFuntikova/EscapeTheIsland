package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

public abstract class Predmet implements IPredmet {

    //----------------------
    // Atribúty pre Predmet
    //----------------------

    private int x;
    private int y;
    private int width;
    private int height;
    private VykreslovacPredmetov vykreslovacPredmetov;

    /**
     * (Predmet) Parametrický konštruktor triedy Predmet na inicializáciu parametrov pozícií a vykreslovania
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Predmet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vykreslovacPredmetov = new VykreslovacPredmetov(); //????
    }

    //--------------------------------------------------
    // Gettery a settery na pozície x, y, šírka a výška
    //--------------------------------------------------


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    //----------------------------------
    // Zdedené metódy z triedy IPredmet
    //----------------------------------

    @Override
    public String dajNazov() {
        return null;
    }

    @Override
    public boolean sluziNaOdplavenie() {
        return false;
    }

    public void daSaPouzit(boolean daSaPouzit) {
    }

    @Override
    public boolean daSaPouzit() {
        return false;
    }

    @Override
    public boolean nastalaKolizia() {
        return false;
    }


    @Override
    public void vypisStavPredmetu() {
        System.out.println("Predmet" + this.dajNazov());
    }

    @Override
    public void draw(SpriteBatch batch) {
    }

    @Override
    public boolean jeVRuksaku(boolean trueFalse) {
        return true;
    }

    @Override
    public void nastalaKolizia(boolean nastalaKolizia) {
    }

}
