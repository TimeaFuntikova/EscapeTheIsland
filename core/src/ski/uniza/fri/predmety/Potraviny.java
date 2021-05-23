package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

public abstract class Potraviny implements  IPredmet {

    //-----------------------
    // Atribúty pre Potraviny
    //-----------------------
    private int x;
    private int y;
    private int width;
    private int height;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    private int energy;
    private VykreslovacPredmetov vykreslovacPredmetov;

    //gettery a settery na pozície, potrebné pri vykresľovaní predmetov

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

    /**
     * (Potraviny)
     * @param x
     * @param y
     * @param width
     * @param height
     * @param energy
     */
    public Potraviny (int x, int y, int width, int height, int energy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.energy = energy;
        this.vykreslovacPredmetov = new VykreslovacPredmetov();
    }


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

}
