package ski.uniza.fri.mapa;

import ski.uniza.fri.predmety.IPredmet;
import java.util.ArrayList;

public interface IMapa {

    String dajNazovLokality();

    ArrayList<String> dajPredmetyVLokalite();

    Lokalita dajLokalituHraca();

    Lokalita hladajLokalitu(String hladanaLokalita);

    void vezmiPredmet(IPredmet predmet);

    void naplnMiestnost(IPredmet predmet);

    void zmenLokalitu(Lokalita paNovaLokalita);

    void vlozPredmetDoLokality(IPredmet predmet);

}
