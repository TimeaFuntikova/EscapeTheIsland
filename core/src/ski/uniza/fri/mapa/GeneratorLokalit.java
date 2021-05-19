package ski.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.predmety.Drevo;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.predmety.Kokos;
import ski.uniza.fri.vykreslovace.VykreslovacPozadiLokalit;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * (GeneratorLokalit) Trieda služi na generovanie lokalít. Priradí im ich názov a naplní ich predmetmi.
 * Obsahuje metódu. ktorá volá dalšiu, na vykreslenie predmetov aj pozadí lokalít.
 */
public class GeneratorLokalit { //nie adapter ale listener? naopak? sem??

    //--------------------------------------
    // Atribúty pre triedu GeneratorLokalit
    //--------------------------------------

    private Lokalita aktualnaLokalita;
    private VykreslovacPredmetov vykreslovac;
    private VykreslovacPozadiLokalit vykreslovacPozadiLokalit;
    private HashMap<String, Lokalita> vsetkyLokality = new HashMap<>();
    private HashMap<String, IPredmet> predmetyNaVykreslenie = new HashMap<>();
    private GeneratorPredmetov generatorPredmetov;
    private SpriteBatch batch;

    private Lokalita plaz;
    private Lokalita cesta;
    private Lokalita vodopad;
    private Lokalita les;
    private Lokalita lietadlo;
    private Lokalita jaskyna;
    private Lokalita utes;
    private Lokalita more;
    private Lokalita sopka;


    /**
     * (GeneratorLokalit) Bezparametricky konstruktor triedy GeneratorLokalit.
     */
    public GeneratorLokalit(GeneratorPredmetov generatorPredmetov) {
        this.generatorPredmetov = generatorPredmetov;
    }

    //gettre na lokality
    public Lokalita getPlaz() {
        return this.plaz;
    }

    public Lokalita getCesta() {
        return cesta;
    }

    public Lokalita getLes() {
        return les;
    }

    public Lokalita getVodopad() {
        return vodopad;
    }

    public Lokalita getLietadlo() {
        return lietadlo;
    }

    public Lokalita getJaskyna() {
        return jaskyna;
    }

    public Lokalita getUtes() {
        return utes;
    }

    public Lokalita getMore() {
        return more;
    }

    public Lokalita getSopka() {
        return sopka;
    }

    //predmety: je toto vobedc nutne?
    private Kokos kokosPlazovy1;
    private Kokos kokosPlazovy2;
    private Kokos kokosPlazovy3;
    private Drevo drevoLesne1;
    private Drevo drevoLesne2;

    public HashMap<String, Lokalita> getVsetkyLokality() {
        this.naplnZoznamLokalit();
        return vsetkyLokality;
    }

    /**
     * (GeneratorLokalit) Vrati aktualnu lokalitu, v ktorej sa nachadza hrac.
     *
     * @return
     */
    public Lokalita getAktualnaLokalita() {
        return this.aktualnaLokalita;
    }

    /**
     * (GeneratorLokalit) Arraylistpredmetov na vykreslenie.
     *
     * @return
     */
    public HashMap<String, IPredmet> dajPredmetyNaVykreslenie() {
        return predmetyNaVykreslenie;
    }

    /**
     * (GeneratorLokalit)) Metóda, ktorá vloží do zoznamu všetky lokality, ktoré exstujú. Slúži na to, aby sa z neho dala metódou určiť
     * aktuálna lokalita.
     *
     * @return ArrayList<Lokatita>vsetkyLokality
     */
    public void naplnZoznamLokalit() {
        this.vsetkyLokality.put(this.plaz.getNazovLokality(), this.plaz);
        this.vsetkyLokality.put(this.vodopad.getNazovLokality(), this.vodopad);
        this.vsetkyLokality.put(this.lietadlo.getNazovLokality(), this.lietadlo);
        this.vsetkyLokality.put(this.jaskyna.getNazovLokality(), this.lietadlo);
        this.vsetkyLokality.put(this.utes.getNazovLokality(), this.utes);
        this.vsetkyLokality.put(this.more.getNazovLokality(), this.more);
        this.vsetkyLokality.put(this.sopka.getNazovLokality(), this.sopka);
    }

    /**
     * (GeneratorLokalit) Metóda najskor vytvori instancie danych lokalit a priradí im nazvy. Vzápati
     * si v sebe zavola metodu, ktora nastavui lokalitam vychody - cim vznikne mapa.
     */
    public void vytvorLokality() {

        //vytvorenie lokalit
        this.cesta = new Lokalita("cesta", this);
        this.plaz = new Lokalita("plaz", this);
        this.vodopad = new Lokalita("vodopad", this);
        this.les = new Lokalita("les", this);
        this.lietadlo = new Lokalita("lietadlo", this);
        this.jaskyna = new Lokalita("jaskyna", this);
        this.utes = new Lokalita("utes", this);
        this.more = new Lokalita("more", this);
        this.sopka = new Lokalita("sopka", this);

    }

    /**
     * (GeneratorLokalit) Nastavi aktualnu lokalitu.
     *
     * @param paNova
     */
    public Lokalita nastavAktualnuLokalitu(Lokalita paNova) {  // zaciatku sa zavola z hry, kde sa za začiatok bude povazovať pláž.
        this.aktualnaLokalita = paNova;
        System.out.println("--------------Nastavila sa nová lokalita");
        return this.aktualnaLokalita;
    }

    /**
     * (GeneratorLokalit) Nastaví lokalitam ich pozadia a vykresli ich.
     *
     * @param vykreslovacPozadiLokalit
     * @param batch
     */
    public void vykresliPozadieLokality(VykreslovacPozadiLokalit vykreslovacPozadiLokalit, SpriteBatch batch) {

        this.vykreslovacPozadiLokalit = vykreslovacPozadiLokalit;
        this.batch = batch;

        if (this.aktualnaLokalita == this.plaz) {
            batch.draw(this.vykreslovacPozadiLokalit.getPlazTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.les) {
            batch.draw(this.vykreslovacPozadiLokalit.getLesTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.lietadlo) {
            batch.draw(this.vykreslovacPozadiLokalit.getLietadloTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.vodopad) {
            batch.draw(this.vykreslovacPozadiLokalit.getVodopadTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.cesta) {
            batch.draw(this.vykreslovacPozadiLokalit.getCestaTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.utes) {
            batch.draw(this.vykreslovacPozadiLokalit.getUtesTexture(), 0, 0);
        }
    }

    /**
     * (GeneratorLokalit) Vlozi do lokalit na pozicie predmety, s ktorými moze hrac iteragovat.
     * Zároveň pridá do zoznamu predmetov tie, ktore čakaju na vykreslenie.
     */
    public void naplnLokality(VykreslovacPredmetov vykreslovacPredmetov) {
        this.vykreslovac = vykreslovacPredmetov;
        //naplnenie lokalit predmetmmi v nich
        //na cestu drevo dat a iné suroviny este nie len kokosy

        nastavovacPredmetov();
        plaz.naplnMiestnost(this.kokosPlazovy1);
        plaz.naplnMiestnost(this.kokosPlazovy2);
        plaz.naplnMiestnost(this.kokosPlazovy3);
        les.naplnMiestnost(this.drevoLesne1);
        les.naplnMiestnost(this.drevoLesne2);
        this.naplnovac();
    }

    private void nastavovacPredmetov() {
        this.kokosPlazovy1 = new Kokos(vykreslovac.getKokosTexture(), 800, 350, 10, 10, "Kokos1", 10);
        this.kokosPlazovy2 = new Kokos(vykreslovac.getKokosTexture(), 740, 290, 10, 10, "Kokos2", 10);
        this.kokosPlazovy3 = new Kokos(vykreslovac.getKokosTexture(), 640, 250, 10, 10, "Kokos3", 10);
        this.drevoLesne1 = new Drevo(vykreslovac.getDrevoTexture(), 500, 100, 10, 10, "DrevoLesne1");
        this.drevoLesne2 =  new Drevo(vykreslovac.getPatykTexture(), 200, 200, 50, 50, "patyk1");
    }

    private void mazacPredmetov() {
        predmetyNaVykreslenie.clear(); //posúvací zoznam keď sa vezmú veci na nakreslenie bude null.
        //hra tým padom padne + ošetriť null
        //ak je null tak na objekte by sa nemalo robiť nič.
    }

    public void naplnovac() {
        if (predmetyNaVykreslenie != null) {
            if (this.aktualnaLokalita == this.plaz) {
                mazacPredmetov();
                this.predmetyNaVykreslenie.put("KokosPlazovy1", this.kokosPlazovy1);
                this.predmetyNaVykreslenie.put("KokosPlazovy2", this.kokosPlazovy2);
                this.predmetyNaVykreslenie.put("KokosPlazovy3", this.kokosPlazovy3);
            } else if (aktualnaLokalita == this.les) {
                mazacPredmetov();
                this.predmetyNaVykreslenie.put("DrevoLesne1", this.drevoLesne1);
                this.predmetyNaVykreslenie.put("Patyk1", this.drevoLesne2);
            }
            else if (aktualnaLokalita == this.les) {
                mazacPredmetov();
                this.predmetyNaVykreslenie.put("DrevoLesne1", this.drevoLesne1);
                this.predmetyNaVykreslenie.put("Patyk1", this.drevoLesne2);
            }
        }
        System.out.println("Nie su tu ziadne predmety na vykreslenie. lokalita uz nema v sebe ziadne predmety. ");
    }


    //metoda na vyhodene predmety z ruksaku a odchyt predmetov:


    /**
     * (GeneratorLokalit) Zavolá si metódu na vykreslovanie predmetov z triedy GeneratorPredmetov.
     *
     * @param batch
     * @param vykreslovacPredmetov
     * @param generatorPredmetov
     */
    public void vykresliSa(SpriteBatch batch, VykreslovacPredmetov vykreslovacPredmetov, GeneratorPredmetov generatorPredmetov) {
        this.vykreslovac = vykreslovacPredmetov;
        generatorPredmetov.nakresliSa(batch);
    }

}