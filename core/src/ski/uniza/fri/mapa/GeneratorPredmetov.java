package ski.uniza.fri.mapa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.hra.Postava;
import ski.uniza.fri.predmety.Drevo;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.predmety.Kokos;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

import java.util.HashMap;

public class GeneratorPredmetov {

    private Postava postava;
    private HashMap<String, IPredmet> predmetyNaVykreslenie = new HashMap<>();
    private VykreslovacPredmetov vykreslovac;
    private GeneratorLokalit generatorLokalit;


    //predmety: je potrebne mat atributy aby sa dalo jednotlive objekty odoberať resp.pridavať do ruksaku
    //mozno to poriesit ako boolen: je VRuksaku - nevykreslí sa znova.
    private Kokos kokosPlazovy1;
    private Kokos kokosPlazovy2;
    private Kokos kokosPlazovy3;
    private Kokos kokosCesta;
    private Kokos kokosCesta2;
    private Drevo drevoLesne1;
    private Drevo drevoLesne2;
    private Drevo drevoUtes;
    private Drevo drevoCesta1;
    private Drevo drevoCesta2;
    private Drevo patyk3;

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

    /**
     * (GeneratorPredmetov) Bezaparametrický konštruktor triedy GeneratorPredmetov.
     */
    public GeneratorPredmetov() {
    }

    /**
     * (GeneratorLokalit) Vlozi do lokalit na pozicie predmety, s ktorými moze hrac iteragovat.
     * Zároveň pridá do zoznamu predmetov tie, ktore čakaju na vykreslenie.
     */
    public void naplnLokality(VykreslovacPredmetov vykreslovacPredmetov) {
        this.vykreslovac = vykreslovacPredmetov;
        //naplnenie lokalit predmetmmi v nich

        this.nastavovacPredmetov();
        this.generatorLokalit.getPlaz().naplnMiestnost(this.kokosPlazovy1);
        this.generatorLokalit.getPlaz().naplnMiestnost(this.kokosPlazovy2);
        this.generatorLokalit.getPlaz().naplnMiestnost(this.kokosPlazovy3);
        this.generatorLokalit.getLes().naplnMiestnost(this.drevoLesne1);
        this.generatorLokalit.getLes().naplnMiestnost(this.drevoLesne2);
        this.generatorLokalit.getCesta().naplnMiestnost(this.kokosCesta);
        this.generatorLokalit.getCesta().naplnMiestnost(this.kokosCesta2);
        this.generatorLokalit.getCesta().naplnMiestnost(this.drevoCesta1);
        this.generatorLokalit.getCesta().naplnMiestnost(this.drevoCesta2);
        this.generatorLokalit.getCesta().naplnMiestnost(this.patyk3);
        this.generatorLokalit.getUtes().naplnMiestnost(this.drevoUtes);

        this.naplnovac();
    }

    public void nastavovacPredmetov() {
        //zapodmienkovať existuj. atributy aby sa do zoznamu na vykreslenie nedostalo null
        this.kokosPlazovy1 = new Kokos(vykreslovac.getKokosTexture(), 800, 350, 10, 10, "Kokos1", 10);
        this.kokosPlazovy2 = new Kokos(vykreslovac.getKokosTexture(), 740, 290, 10, 10, "Kokos2", 10);
        this.kokosPlazovy3 = new Kokos(vykreslovac.getKokosTexture(), 640, 250, 10, 10, "Kokos3", 10);
        this.drevoLesne1 = new Drevo(vykreslovac.getDrevoTexture(), 500, 100, 10, 10, "DrevoLesne1");
        this.drevoLesne2 = new Drevo(vykreslovac.getPatykTexture(), 200, 200, 50, 50, "patyk1");
        this.kokosCesta = new Kokos(vykreslovac.getKokosTexture(), 100, 300, 10, 10, "Kokos4", 10);
        this.kokosCesta2 = new Kokos(vykreslovac.getKokosTexture(), 120, 350, 10, 10, "Kokos5", 10);
        this.drevoUtes = new Drevo(vykreslovac.getPatykTexture(), Gdx.graphics.getWidth() - 50, 20, 10, 10, "Patyk2");
        this.drevoCesta1 = new Drevo(vykreslovac.getDrevoTexture(), 500, 200, 10, 10, "DrevoCesta1");
        this.drevoCesta2 = new Drevo(vykreslovac.getDrevoTexture(), 650, 300, 10, 10, "DrevoCesta2");
        this.patyk3 = new Drevo(vykreslovac.getPatykTexture(), 520, 420, 10, 10, "Patyk3");
    }

    private void mazacPredmetov() {
        predmetyNaVykreslenie.clear(); //posúvací zoznam keď sa vezmú veci na nakreslenie bude null.
    }

    public void naplnovac() { //planovac domysliet null
        if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getPlaz()) {
            mazacPredmetov();
            this.predmetyNaVykreslenie.put("KokosPlazovy1", this.kokosPlazovy1);
            this.predmetyNaVykreslenie.put("KokosPlazovy2", this.kokosPlazovy2);
            this.predmetyNaVykreslenie.put("KokosPlazovy3", this.kokosPlazovy3);
        } else if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getLes()) {
            mazacPredmetov();
            this.predmetyNaVykreslenie.put("DrevoLesne1", this.drevoLesne1);
            this.predmetyNaVykreslenie.put("Patyk1", this.drevoLesne2);
        } else if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getCesta()) {
            mazacPredmetov();
            this.predmetyNaVykreslenie.put("Kokos4", this.kokosCesta);
            this.predmetyNaVykreslenie.put("Kokos5", this.kokosCesta2);
            this.predmetyNaVykreslenie.put("DrevoCesta1", this.drevoCesta1);
            this.predmetyNaVykreslenie.put("DrevoCesta2", this.drevoCesta2);
            this.predmetyNaVykreslenie.put("Patyk3", this.patyk3);
        } else if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getUtes()) {
            mazacPredmetov();
            this.predmetyNaVykreslenie.put("Patyk2", this.drevoUtes);
        } else if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getLietadlo()) {
            mazacPredmetov();
            this.predmetyNaVykreslenie.put("Patyk2", this.drevoUtes);
        }
        System.out.println("Nie su tu ziadne predmety na vykreslenie. lokalita uz nema v sebe ziadne predmety. ");
    }


    //lepšie a kratšie urobiť toto
    public IPredmet kontrolaKolizii() {
        //HashMap<Set<String>, IPredmet> predmetyNaPridanie = new HashMap<>(); // nech sa pridáva do ruksaka a zároveň nech znizne z vykreslovania lokalit
        int PostavaX = this.postava.getX();
        int PostavaY = this.postava.getY();
        if (PostavaY == kokosPlazovy1.getY() + PostavaX) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            this.postava.zoberPredmet(kokosPlazovy1);
            return kokosPlazovy1;
        } else if (PostavaY == kokosPlazovy2.getY()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(kokosPlazovy2);
            return kokosPlazovy2;
        } else if (PostavaY == kokosPlazovy3.getY()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(kokosPlazovy3);
            return kokosPlazovy3;
        } else if (PostavaX == drevoCesta1.getX()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(drevoCesta1);
            return drevoCesta1;
        } else if (PostavaX == drevoCesta2.getX()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(drevoCesta2);
            return drevoCesta2;
        } else if (PostavaY== drevoLesne1.getY()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(drevoLesne1);
            return drevoLesne1;
        } else if (PostavaY == drevoLesne2.getY()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(drevoLesne2);
            return drevoLesne2;
        } else if (PostavaX == drevoUtes.getX()) {
            System.out.println("ZISTIL SOM KOLIIIIIIIIIIIZIUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            postava.zoberPredmet(drevoUtes);
            return drevoUtes;
        }
        return null;
    }


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
        }
    }
}

