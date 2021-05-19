package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IPredmet {

    int getX();
    int getY();

    String dajNazov();

    boolean sluziNaOdplavenie();

    boolean daSaPouzit();

    boolean bolPouzity();

    void vypisStavPredmetu(); //napriklad pri opotrebení, alebo nakoľko bude jedlo "zhnité"...

    void draw(SpriteBatch batch);
}
