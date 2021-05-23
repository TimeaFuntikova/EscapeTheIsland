package ski.uniza.fri.hra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.mapa.Lokalita;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.predmety.Lod;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

import javax.swing.*;
import java.util.HashMap;

/**
 * Trieda Postava predstavuje virtuálnu postavu, ktorou je hŕač. Presúva sa na rôzne lokality a môže zbierať predmety,
 * vytvárať nové, ukladať ich do svojho batoha alebo ich vhodným spôsobom využiť vo svoj prospech na opustenie ostrova.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Postava {

    //------------------------------
    // Atribúty pre triedu Postava
    //------------------------------

    //pozicie
    private int x;
    private int y;
    private int skore;

    public boolean isHraBezi() {
        return hraBezi;
    }

    private boolean hraBezi = true;

    public int getSkore() {
        return this.skore;
    }

    public void setEnergy(int energy) {
        if(this.energy > 0) {
        this.energy += energy;
    } else {
            JOptionPane.showMessageDialog(null, "Umrel si od vyčerpania. Hra sa resetuje.");
            hraBezi = false; //resetuje hru.
        }
    }
    public void setSkore(int skore) {
        this.skore += skore;
    }

    private int energy;
    private Ruksak ruksak;
    private Ovladanie ovladanie;
    private Lokalita lokalita;
    private Sprite postavaTexture;
    private SpriteBatch batch;
    private VykreslovacPredmetov vykreslovacPredmetov;


    /**
     * (Postava) Konštruktor triedy Postava, inicializuje paramatre, textúru a nastaví hráčovi začiatočnú pozíciu.
     *
     * @param vykreslovacPredmetov
     * @param batch
     */
    public Postava(Lokalita lokalita, VykreslovacPredmetov vykreslovacPredmetov, SpriteBatch batch) {
        this.lokalita = lokalita;
        this.skore = 0;
        this.energy = 100;
        this.vykreslovacPredmetov = vykreslovacPredmetov;
        this.batch = batch;
        this.inicializujTexturu(this.postavaTexture);
        this.nastavPoziciuHraca((Gdx.graphics.getWidth() / 2), 0); //prvotne nastavenie pozicie hrača v novej miestnosti - zatial sa berie do úvahy len jedna

    }

    //------------------------------
    // Gettre a settre pre Postavu
    //------------------------------

    public Lokalita getAktualnaLokalita() {
        return this.lokalita.dajLokalituPostavy();
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void dajPostaveRuksak() {
        this.ruksak = new Ruksak(this);
    }

    public HashMap<String, IPredmet> dajPredmetyVRuksaku() {
        System.out.println(this.ruksak.dajZoznamPredmetovVRuksaku().keySet());
        return this.ruksak.dajZoznamPredmetovVRuksaku();
    }

    /**
     * (Postava) Druhý konštruktor na akutalizovanie ovládanie až po vytvorení postavy, ktorá ho používa.
     *
     * @param ovladanie
     */
    public void aktualizujOvladanie(Ovladanie ovladanie) {
        this.ovladanie = ovladanie;
    }

    /**
     * (Postava) Jednoduchý setter na pozíciu hráča.
     *
     * @param x
     * @param y
     */
    public void nastavPoziciuHraca(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * (Postava) Zavolá si z triedy OvladaniePostavy metódy, ktoré vykonávajú pohyb pomocou šípiek.
     */
    public void pohniSa() { //opravene
        this.ovladanie.nastavOvladaniePostavy();
    }

    /**
     * (Postava) Metóda na inicializovanie textúry postavy.
     * @param postavaTexture
     */
    private void inicializujTexturu(Sprite postavaTexture) {
        postavaTexture = this.vykreslovacPredmetov.getPlayerTexture();
        this.postavaTexture = postavaTexture;

    }

    /**
     * (Postava) prvotne nastavenie na poziciu a vykreslenie postavy a volanie metódy pohni sa()
     */
    public void vykresliSaNaZaciatok() {
        this.pohniSa();
        nastavPoziciuHraca(this.x, this.y);
        this.batch.draw(this.vykreslovacPredmetov.getPlayerTexture(), (float) getX(), (float) getY());

    }

    /**
     * (Postava) Vypíše na consolu energiu ..... nepotrebne af -----vypis cez font hre ako fpska
     */
    public String vypisEnergiu() {
        String s = "Energia : " + this.energy + " . Skóre : " + this.skore;
        return s;
    }

    /**
     * (Postava) Metódy na akciu postavy
     */
    //toto nejako graficky začleniť do priebehu hry--- pri prechode cez lokality
    public void odpocitavajEnergy() {
        this.energy = Integer.MAX_VALUE;
        this.energy -= 5;
        if (this.energy != 0) {           // ||
            if (this.energy > 100000 && this.energy < 2000) {
                System.out.println("Mal by si sa najesť.");
            } else if (this.energy <= 10) {
                System.out.println("Hladuješ.");
            } else {
                System.out.println("Umrel si. Nemáš žiadnu energiu."); //hra sa skončí vypísaním stavu a možnosťou začať hrať odznova
                //odkaz na hlavne menu? + prestat vykreslovať všetky v lokalite/ loklitach?
            }
        }
    }

    /**
     * (Postava) Metóda kolízie. Nastaví si rozsah, v ktorom vzniká kolízia.
     * nastaví predmetu vlastnosť, že s ním nastala kolízia a pokiaľ to nie je lodˇ, predmet pridá do ruksaku.
     */

    public boolean nastalaKolizia() {
        for (IPredmet predmet : this.getAktualnaLokalita().getPredmetyVLokalite().values()) {
            if ((this.x < predmet.getX() + predmet.getWidth() && this.x > predmet.getX() - predmet.getWidth())
                    && (this.y > predmet.getY() - predmet.getHeight() && this.y < predmet.getY() + predmet.getHeight())) {
                System.out.println("Detekoval som kolíziu.");// ak sa suradnice zhodli, do ruksaka sa prida predmet. pokracuje sa v metode pridaj do ruksaka.
                predmet.nastalaKolizia(true);
                if(predmet instanceof Lod) {
                    JOptionPane.showMessageDialog(null, "Úspešne si sa dostal z ostrova!" );
                    this.hraBezi = false;
                }
                this.pridajDoRuksaka(predmet);
                return true;
            }
        } return false;
    }

    /**
     * (Postava) Pridá predmet, na ktorý sa vzťahuje kolízia do ruksaka. Nastaví mu vlastnosť, že sa nedá použiť,
     * tým pádom sa už v loklaite opätovne nevykreslí.
     * @param predmet
     */
    public void pridajDoRuksaka(IPredmet predmet) {
        this.getAktualnaLokalita().vezmiPredmet(predmet); //
        this.ruksak.pridajDoRuksaku(predmet);
        predmet.daSaPouzit(false);
    }

    /**
     * (Postava) Metóda, ktorá sa volá z ruksaka. Posiela sa dalej do hry aby sa vedelo, kedy vznikla kolizia.
     * @return
     */
    public boolean mozemPostavitLod () {
        return this.ruksak.postavitLod();
    }
}
