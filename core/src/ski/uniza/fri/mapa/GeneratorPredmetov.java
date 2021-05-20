package ski.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.hra.Postava;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;
import java.util.HashMap;

public class GeneratorPredmetov {

    private Postava postava;
    private HashMap<String, IPredmet> predmetyNaVykreslenie;
    private VykreslovacPredmetov vykreslovac;
    private GeneratorLokalit generatorLokalit;

    /**
     * (GeneratorPredmetov) Parametricky konstruktor triedy GeneratorPredmetov
     *
     * @param vykreslovac
     * @param generatorLokalit
     * @param postava
     */


    public void initGeneratorPredmetov(VykreslovacPredmetov vykreslovac, GeneratorLokalit generatorLokalit, Postava postava) {
        this.vykreslovac = vykreslovac;
        this.generatorLokalit = generatorLokalit;
        this.postava = postava;
    }

    public GeneratorPredmetov() {}

    /**
     * (GeneratorPredmetov) Vezme si zoznam predpripravených predmetov na vykreslenie do lokality.
     *
     * @return
     */
    public void inicializujZoznam() { //mal by sa volat ked sa zmeni lokalita
        this.predmetyNaVykreslenie = this.generatorLokalit.dajPredmetyNaVykreslenie();
    }

    /**
     * (GenratorPredmetov) Prida nový predmet do zoznamu predmetov na vykreslenie.
     */
    private void pridaniePredmetov() {
        inicializujZoznam();
    }

    /**
     * (GeneratorPredmetov) Prejde si kontajner pridaných predmetov a v cykle ich všetky predmety vykresli.
     * Pozícia sa určí  na zaklade určenia v triede GeneratorLokalit
     *
     * @param batch
     */
    public void nakresliSa(SpriteBatch batch) {
        this.pridaniePredmetov();
        //this.predmetyNaVykreslenie.forEach((k, h) -> predmetyNaVykreslenie.draw(batch)); java8+
        for (int i = 0; i < this.predmetyNaVykreslenie.size(); i++) {
            if (this.predmetyNaVykreslenie != null) {
                for (IPredmet value : predmetyNaVykreslenie.values()) {
                    value.draw(batch);
                   continue;
                }
            }



            //TODO Dorobiť branie vecí :
            /* else{
            try {
                this.postava.zoberPredmet(this.predmetyNaVykreslenie.get());
            } catch (NullPointerException e) {
                System.out.println("aktualna lokalita je null v triede postava....");
            }
        } */
        }
    }
}

