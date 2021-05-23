package ski.uniza.fri.mapa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.hra.Postava;
import ski.uniza.fri.predmety.*;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

import javax.swing.*;
import java.util.HashMap;

/**
 * Trieda GeneratorPredmetov sluzi na generovanie Predmetov v Lokalitach. Zaroven kontroluje, ake predmety sú vhodne na vykreslenie.
 */

public class GeneratorPredmetov {

    //----------------------------------------
    // Atribúty pre triedu GeneratorPredmetov
    //----------------------------------------


    private Postava postava;
    private HashMap<String, IPredmet> predmetyNaVykreslenie = new HashMap<>(); // na zaciatku v ňom nič nie je.
    private VykreslovacPredmetov vykreslovac;
    private GeneratorLokalit generatorLokalit;
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
    private Drevo drevoLietadlo;
    private Kamen kamen1;
    private Lod lod;

    /**
     * (GeneratorPredmetov) Parametricky konstruktor triedy GeneratorPredmetov
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
     * (GenerátorPredmetov)Metóda na vytvorenie loďky. Je samostatne preto, lebo sa zavolá priamo z hry, keď sa zmení vlastnosť,
     * že loďku už je možné postaviť.
     */
    public void pridajLodDoZoznamu() {
        this.lod = new Lod(vykreslovac.getLodTexture(), 250, 100, 40, 40, "Lodka");
        this.generatorLokalit.getPlaz().naplnMiestnost(this.lod);
        JOptionPane.showMessageDialog(null, "Loď sa vytvorila. Utekaj na pláž."); //pride až sem.

    }

    /**
     * (Generatorpredmetov) zoberie si všetky predmety z triedy Lokalita, ktoré sú práve v aktuálnej lokalite, kde sa nachádza hráč.
     */
    public HashMap<String, IPredmet> getPredmetyNaVykreslenie() {
        return predmetyNaVykreslenie = this.postava.getAktualnaLokalita().getPredmetyVLokalite();
    }

    /**
     * (Generatorpredmetov) Napľňa zoznam predmetov v treide Lokalita. Na začiatku hry sa nainicialitujú všetky predmety do lokalít,
     * pri zmenach lokalit sa vola metody naplnovac, ktorá už na základe špecifickej vlastnosti predmety bud vykresli alebo nie.
     */
    public void naplnLokality() {
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
        this.generatorLokalit.getLietadlo().naplnMiestnost(this.kamen1);
    }

    /**
     * (GeneratorPredmetov) Nastaví si všetky predmety v hre a pridelí im texúru, pozíciu a jedinečný názov.
     */
    public void nastavovacPredmetov() {

        this.kokosPlazovy1 = new Kokos(vykreslovac.getKokosTexture(), 800, 350, 10, 10, "Kokos1", 10);//vyška a šírka sú pri kokose prednastavene na 50px
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
        this.drevoLietadlo = new Drevo(vykreslovac.getDrevoTexture(), 450, 80, 10, 10, "DrevoLietadlo");
        this.kamen1 = new Kamen(vykreslovac.getKamenTexture(), 350, 80, 10, 10, "kamen");
    }

    /**
     * (GeneratorPredmetov) Vymaže celý zoznam predmetov na vykreslenie, aby sa pri prepínaní lloklaít nezachovávali objekty vykreslené.
     */
    private void mazacPredmetov() { //vymaže zoznam predmetov na vykreslovanie
        predmetyNaVykreslenie.clear();
    }

    /**
     * (GeneratorPredmetov) Prejde si kontajner na vykreslenie a pokial v nom nájdepredmet, ktorý sa už nachádza v ruksaku, resp - nedá sa pouziť,
     * vymaze ho zo zoznamu predmetov na vykreslenie. Zaručí sa tak, že sa po zmene lokality predmet opatovne nyvkresli pokial sa uz nachadza v ruksaku.
     */
    public void odstranPredmet() {
        IPredmet vymaz = null;
        if (predmetyNaVykreslenie != null) {
            for (IPredmet predmet : this.predmetyNaVykreslenie.values()) {
                if (!predmet.daSaPouzit()) {
                    vymaz = predmet;
                }
            }
            if (vymaz != null) {
                this.predmetyNaVykreslenie.remove(vymaz.dajNazov(), vymaz);
            }
        }
    }

    /**
     * (GeneratorPredmetov) vloží do kontajnera vopred pripravené predmety.
     */
    public void naplnovac() {

        // praca s kontajnerom predmety na vykreslenie

        if (this.postava.getAktualnaLokalita() == this.generatorLokalit.getPlaz()) {
            mazacPredmetov();
            if (!kokosPlazovy1.daSaPouzit()) {
                this.predmetyNaVykreslenie.put("KokosPlazovy1", this.kokosPlazovy1);
                this.predmetyNaVykreslenie.put("KokosPlazovy2", this.kokosPlazovy2);
                this.predmetyNaVykreslenie.put("KokosPlazovy3", this.kokosPlazovy3);
                this.predmetyNaVykreslenie.put(this.lod.dajNazov(), this.lod);
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
                this.predmetyNaVykreslenie.put("DrevoLietadlo", this.drevoLietadlo);
                this.predmetyNaVykreslenie.put("kamen", this.kamen1);
            }
        }
    }

    /**
     * (GeneratorPredmetov) Vezme si zoznam predpripravených predmetov na vykreslenie do lokality.
     * Vymaze zo zoznaamu také predmety, ktore po kolizii s postavou dostali vlastnost "neda sa pouzit"
     *
     */
    private void inicializujZoznam() { //mal by sa volat ked sa zmeni lokalita
        HashMap<String, IPredmet> vymazMa = new HashMap<>();
        for (IPredmet predmet : this.getPredmetyNaVykreslenie().values()) {
            if (predmet.nastalaKolizia() && !predmet.daSaPouzit()) {
                vymazMa.put(predmet.dajNazov(), predmet);
            }
        }
        this.predmetyNaVykreslenie.remove(vymazMa.keySet(), vymazMa.values());
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
        pridaniePredmetov();
        for (int i = 0; i < this.predmetyNaVykreslenie.size(); i++) {
            if (this.predmetyNaVykreslenie != null) {
                for (IPredmet value : predmetyNaVykreslenie.values()) {
                    value.draw(batch);
                }
            }
        }
    }
}
