package ski.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.vykreslovace.VykreslovacPozadiLokalit;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

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

    public Lokalita getUtes() {
        return utes;
    }

    public Lokalita getJaskyna() {
        return jaskyna;
    }

    public Lokalita getMore() {
        return more;
    }

    public Lokalita getSopka() {
        return sopka;
    }

    public HashMap<String, Lokalita> getVsetkyLokality() {
        this.naplnZoznamLokalit();
        return vsetkyLokality;
    }

    /**
     * (GeneratorLokalit) Vrati aktualnu lokalitu, v ktorej sa nachadza hrac.
     */
    public Lokalita getAktualnaLokalita() {
        return this.aktualnaLokalita;
    }

    /**
     * (GeneratorLokalit) predmety na vykreslenie
     */
    public HashMap<String, IPredmet> dajPredmetyNaVykreslenie() {
        IPredmet vymaz = null;
        for (IPredmet predmet : this.generatorPredmetov.getPredmetyNaVykreslenie().values()) {
            if (predmet.nastalaKolizia() && !predmet.daSaPouzit()) {
                predmet = vymaz;
            }
        }
        this.generatorPredmetov.getPredmetyNaVykreslenie().remove(vymaz.dajNazov(), vymaz);
        return generatorPredmetov.getPredmetyNaVykreslenie();
    }

    /**
     * (GeneratorLokalit)) Metóda, ktorá vloží do zoznamu všetky lokality, ktoré exstujú. Slúži na to, aby sa z neho dala metódou určiť
     * aktuálna lokalita.
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
     * (GeneratorLokalit) Nastavi aktualnu lokalitu
     */
    public Lokalita nastavAktualnuLokalitu(Lokalita paNova) {  // zaciatku sa zavola z hry, kde sa za začiatok bude povazovať pláž.
        this.aktualnaLokalita = paNova;
        System.out.println("--------------Nastavila sa nová lokalita");
        return this.aktualnaLokalita;
    }

    /**
     * (GeneratorLokalit) Nastaví lokalitam ich pozadia a vykresli ich.
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

    public void naplnovacPosunuty() {
        this.generatorPredmetov.naplnovac();
    }


    //metoda na vyhodene predmety z ruksaku a odchyt predmetov:

    /**
     * (GeneratorLokalit) Zavolá si metódu na vykreslovanie predmetov z triedy GeneratorPredmetov.
     */
    public void vykresliSa(SpriteBatch batch, VykreslovacPredmetov vykreslovacPredmetov, GeneratorPredmetov generatorPredmetov) {
        this.vykreslovac = vykreslovacPredmetov;
        generatorPredmetov.nakresliSa(batch);
    }

}