package ski.uniza.fri.mapa;

import ski.uniza.fri.predmety.IPredmet;

public interface IMapa {

    String dajNazovLokality();

    Lokalita dajLokalituPostavy();

    void vezmiPredmet(IPredmet predmet);

    void naplnMiestnost(IPredmet predmet);

    void zmenLokalitu(Lokalita paNovaLokalita);

}
