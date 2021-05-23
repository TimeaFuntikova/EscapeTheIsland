package ski.uniza.fri.predmety;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IPredmet {

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    String dajNazov();

    boolean sluziNaOdplavenie();

    boolean daSaPouzit(boolean daSaPouzit);

    boolean daSaPouzit();

    boolean nastalaKolizia();

    void nastalaKolizia(boolean nastalaKolizia);

    void vypisStavPredmetu(); //napriklad pri opotrebení, alebo nakoľko bude jedlo "zhnité"...

    void draw(SpriteBatch batch);

    boolean jeVRuksaku(boolean trueFalse);
}
