package ski.uniza.fri.hra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.mapa.Lokalita;
import ski.uniza.fri.predmety.IPredmet;
import ski.uniza.fri.predmety.Potraviny;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

import java.util.HashMap;

/**
 * Trieda Postava predstavuje virtuálnu postavu, ktorou je hŕač. Presúva na na rôzne lokality a môže zbierať predmety,
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

    public int getSkore() {
        return skore;
    }

    public void setSkore(int skore) {
        this.skore = skore;
    }

    private int skore;
    private int energy;
    private Ruksak ruksak;
    private Ovladanie ovladanie;
    private Lokalita lokalita;
    private Sprite postavaTexture;
    private SpriteBatch batch;
    private VykreslovacPredmetov vykreslovacPredmetov;


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * (Postava) Getteer na aktálnu lokaltu, v ktorej je hráč, vypýta si to od Lokality, ktorej to posunie generator lokalit.
     *
     * @return
     */
    public Lokalita getAktualnaLokalita() {
        return this.lokalita.dajLokalituHraca();
    }

    /**
     * (Postava) Konštruktor, ktorý si v sebe inicializuje parametre.
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

    public void dajPostaveRuksak() {
        this.ruksak = new Ruksak(this);
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

    public void dajPoziciuPostavy() {
        System.out.println("Pozicia X: " + this.x + " Pozícia Y: " + this.y);
    }

    /**
     * (Postava) Getter na y-ovú súradnicu.
     *
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * (Postava) Getter na x-ovú súradnicu.
     *
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * (Postava) Zavolá si z triedy OvladaniePostavy metódy, ktoré vykonávajú pohyb pomocou šípiek.
     */
    public void pohniSa() { //opravene
        this.ovladanie.nastavOvladaniePostavy();
        // odpocitavajEnergy(); poriešiť vzhladom na sprite(s)...
    }

    /**
     * (Postava) Metóda na inicializovanie textúry postavy.
     *
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
    public void vypisEnergiu() {
        System.out.println("Aktuálna energia hráča: " + this.energy + "a jeho aktuálne skóre: " + this.skore);
    }

    //nedorobené!


   /* public void zjedzPredmet(IPredmet predmet) {
        if (predmet instanceof Potraviny) {
            predmet = this.lokalita.vezmiPredmet();
            this.energy += ((Potraviny) predmet).getEnergy();
        } else {
            System.out.println("čosi s predmetom je zle. Bud sa neda zjest alebo nie je instanciou triedy potraviny a nevie dat energiu");
        }
    }
    public void vyberZRuksaku(IPredmet predmet) {
        this.ruksak.vyberZRuksaku(predmet);
    }

 */

    /**
     * (Postava) Metódy na akciu postavy
     */
    //toto nejako graficky začleniť do priebehu hry--- pri prechode cez lokality
    public void odpocitavajEnergy() {
        this.energy -= 5;
        if (this.energy != 0) {           // ||
            if (this.energy > 10 && this.energy < 20) {
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
     * (Postava) Zavola metodu z Ruksaku na polozenie predmetu z ruksaku do miestnosti.
     *
     * @param predmet
     */
    /*
    public void polozPredmet(IPredmet predmet) {
        this.ruksak.vyberZRuksaku(predmet);
        //vlozit ho do miestnosti a zaroven ho vymazat z ruksaka.
    }
    */

    /**
     * (Postava) Zavola metodu z Ruksaku na vzatie predmetu do Ruksaku z miestnosti.
     */

    public boolean nastalaKolizia() {
        for (IPredmet predmet : this.getAktualnaLokalita().getPredmetyVLokalite().values()) {
            if ((this.x < predmet.getX() + predmet.getWidth() && this.x > predmet.getX() - predmet.getWidth())
                    && (this.y > predmet.getY() - predmet.getHeight() && this.y < predmet.getY() + predmet.getHeight())) {
                System.out.println("Detekoval som kolíziu.");// ak sa suradnice zhodli, do ruksaka sa prida predmet. pokracuje sa v metode pridaj do ruksaka.
                predmet.nastalaKolizia(true);
                predmet.daSaPouzit(false);
                this.pridajDoRuksaka(predmet);
                return true; //ak sa zhodujúc suradnice btw su urobene zle tak sa vrati true, inak false, znamena ze pri flase normalne s vsetko nakresli
            }
        } return false;
    }

    public void pridajDoRuksaka(IPredmet predmet) {
        this.getAktualnaLokalita().vezmiPredmet(predmet); ///tuto sa pozriet ci tam nie su veci zbytovned navyse
        this.ruksak.pridajDoRuksaku(predmet);
    }



   public HashMap<String, IPredmet> dajPredmetyVRuksaku() {
       System.out.println(this.ruksak.dajZoznamPredmetovVRuksaku().keySet());
       return this.ruksak.dajZoznamPredmetovVRuksaku();
   }

    //skladanie lode
}
