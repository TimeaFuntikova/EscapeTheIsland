package ski.uniza.fri.mapa;

import ski.uniza.fri.hra.Postava;
import ski.uniza.fri.predmety.IPredmet;

public interface IMapa {

    String dajNazovLokality();

    String dajNazovPredmetuVLokalite();

    Lokalita dajLokalituHraca();

    Lokalita hladajLokalitu(String hladanaLokalita);

    IPredmet vezmiPredmet(String predmet);

    void naplnMiestnost(IPredmet predmet);

    void zmenLokalitu(Lokalita paNovaLokalita);

    void vlozPredmetDoLokality(IPredmet predmet);

}
