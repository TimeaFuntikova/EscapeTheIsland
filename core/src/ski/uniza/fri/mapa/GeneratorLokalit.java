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


    public HashMap<String, Lokalita> getVsetkyLokality() {
        this.naplnZoznamLokalit();
        return this.vsetkyLokality;
    }

    /**
     * (GeneratorLokalit) Nastavi novú aktualnu lokalitu
     */
    public Lokalita nastavAktualnuLokalitu(Lokalita paNova) {
        if(paNova != null) {
            this.aktualnaLokalita = paNova;
            System.out.println("--------------Nastavila sa nová lokalita");
            return this.aktualnaLokalita;
        } System.out.println("--------------Nenastavila sa nová lokalita...");
        return null;
    }

    /**
     * (GeneratorLokalit) Vrati aktualnu lokalitu, v ktorej sa nachadza hrac.
     */
    public Lokalita getAktualnaLokalita() {
        return this.aktualnaLokalita;
    }

    /**
     * (GeneratorLokalit) predmety na vykreslenie z generatora predmetov
     */
    public HashMap<String, IPredmet> dajPredmetyNaVykreslenie() {
        return generatorPredmetov.getPredmetyNaVykreslenie();
    }

    /**
     * (GeneratorLokalit)) Metóda, ktorá vloží do zoznamu všetky lokality, ktoré exstujú. Slúži na to, aby sa z neho dala metódou určiť
     * aktuálna lokalita.
     */
    public void naplnZoznamLokalit() {
        this.vsetkyLokality.put(this.les.getNazovLokality(), this.les);
        this.vsetkyLokality.put(this.plaz.getNazovLokality(), this.plaz);
        this.vsetkyLokality.put(this.vodopad.getNazovLokality(), this.vodopad);
        this.vsetkyLokality.put(this.lietadlo.getNazovLokality(), this.lietadlo);
        this.vsetkyLokality.put(this.cesta.getNazovLokality(), this.cesta);
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
     * (GeneratorLokalit) Nastaví lokalitam ich pozadia a vykresli ich.
     */
    public void vykresliPozadieLokality(VykreslovacPozadiLokalit vykreslovacPozadiLokalit, SpriteBatch batch) {

        this.vykreslovacPozadiLokalit = vykreslovacPozadiLokalit;
        this.batch = batch;

        if (this.aktualnaLokalita == this.les) {
            batch.draw(this.vykreslovacPozadiLokalit.getLesTexture(), 0, 0);
        } else if (this.aktualnaLokalita == this.plaz) {
            batch.draw(this.vykreslovacPozadiLokalit.getPlazTexture(), 0, 0);
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
     * (Lokalita) Metóda ny vyhladanie lokality podla nazvu s návratovou hodnotou hladanej lokality
     * @param hladanaLokalita
     * @return
     */
    public Lokalita hladajLokalitu(String hladanaLokalita) {
        if (this.getVsetkyLokality().containsKey(hladanaLokalita))
            for (Lokalita lokalita : this.getVsetkyLokality().values()) { //opravene!
                return lokalita;
            } return null;
    }

    public void naplnovacPosunuty() {
        this.generatorPredmetov.naplnovac();
        this.generatorPredmetov.odstranPredmet();
    }

    /**
     * (GeneratorLokalit) Zavolá si metódu na vykreslovanie predmetov z triedy GeneratorPredmetov.
     */
    public void vykresliSa(SpriteBatch batch, VykreslovacPredmetov vykreslovacPredmetov, GeneratorPredmetov generatorPredmetov) {
        this.vykreslovac = vykreslovacPredmetov;
        generatorPredmetov.nakresliSa(batch);
    }

}