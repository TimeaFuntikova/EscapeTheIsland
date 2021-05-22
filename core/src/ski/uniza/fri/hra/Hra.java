package ski.uniza.fri.hra;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.mapa.GeneratorLokalit;
import ski.uniza.fri.mapa.GeneratorPredmetov;
import ski.uniza.fri.mapa.Lokalita;
import ski.uniza.fri.vykreslovace.VykreslovacPozadiLokalit;
import ski.uniza.fri.vykreslovace.VykreslovacPredmetov;

/**
 * Trieda Hra je kompozit všetkých tried v programe "Escape the Island".
 * Spúšťa sa v nej nová hra, ukončuje sa v nej rozohratá hra a rovnako poskytuje
 * pomocníka, ktorý hráčovi priblíži, čo má v hre vlastne robiť.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Hra extends ApplicationAdapter { // len tu. kde sa extenduje ApplicationAdapter sa dakjú urobiť GDX inputy.

    //--------------------------
    // Atribúty pre triedu Hra
    //--------------------------

    //cas
    private boolean hraZacala = false;
    private Postava postava;
    private GeneratorLokalit generatorLokalit;
    private GeneratorPredmetov generatorPredmetov;
    private VykreslovacPredmetov vykreslovacPredmetov;
    private VykreslovacPozadiLokalit vykreslovacPozadiLokalit;
    private Lokalita lokalita;
    private HlavneMenu hlavneMenu;
    private SpriteBatch batch;
    private Ovladanie ovladanie;
    private BitmapFont font;

    //private Ruksacik ruksacik;
    // private Pomocnik pomocnik;

    /**
     * (Hra) Metóda na vytvorenie novej hry. Prepíš všetko, čo doteraz bolo uložené a spustí hru odznovu.
     * Metóda by mohla rozlišovať medzi novou hrou a pokračovaním v hre.
     */
    @Override
    public void create() {
        this.font = new BitmapFont();
        this.vykreslovacPredmetov = new VykreslovacPredmetov();
        this.vykreslovacPozadiLokalit = new VykreslovacPozadiLokalit();
        this.batch = new SpriteBatch();
        this.generatorPredmetov = new GeneratorPredmetov();
        this.generatorLokalit = new GeneratorLokalit(this.generatorPredmetov);
        this.lokalita = new Lokalita(this.generatorLokalit); //vytvori sa lokalita bez nazvu
        this.ovladanie = new Ovladanie();
        //treba najskor zavolat vytvorenie lokalit inak generator predmetov pracuje s prázdnou inštanciou
        this.generatorLokalit.vytvorLokality(); // vytvori prazdne konkretne lokality

        this.postava = new Postava(this.lokalita, this.vykreslovacPredmetov, this.batch); //postava bez aktualnej lokality ale schopna sa neskor vykreslit
        this.generatorPredmetov.initGeneratorPredmetov(this.vykreslovacPredmetov, this.generatorLokalit, this.postava);
        this.generatorLokalit.nastavAktualnuLokalitu(this.lokalita.hladajLokalitu("plaz")); //za aktualnu sa na zaciatok nastavi v tejto triede plaz
        this.postava.getAktualnaLokalita();  //pláž
        this.generatorPredmetov.naplnLokality(this.vykreslovacPredmetov); //do vytvorených inštancii sa pridajú predmety na pozíciach ale ešte sa nevykreslia. // iba ta aktualna
        this.ovladanie = new Ovladanie(this.postava, this.batch, this.vykreslovacPredmetov, this.generatorLokalit, this.vykreslovacPozadiLokalit);
        this.postava.aktualizujOvladanie(this.ovladanie);
        this.hlavneMenu = new HlavneMenu(this); // --- po kliknutí na ok by sa okno mohlo minimalizoivať.

    }

    /**
     * (Hra) Vykreslenie + Metóda na ukončenie hry.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        this.generatorLokalit.vykresliPozadieLokality(this.vykreslovacPozadiLokalit, this.batch);
        this.postava.vykresliSaNaZaciatok(); // pre postavu
        this.generatorLokalit.vykresliSa(this.batch, this.vykreslovacPredmetov, this.generatorPredmetov);

        //pomoc debug:
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
        }
        this.font.draw(this.batch, "Predmety v ruksaku: " + this.postava.dajPredmetyVRuksaku(), 10,Gdx.graphics.getHeight() - 20);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    /**
     * (Hra) Settery využité v triede HlavneMenu
     * @param hraZacala
     */
    public void setHraZacala(boolean hraZacala) {
        this.hraZacala = hraZacala;
    }

    public boolean isHraZacala() {
        return hraZacala;
    }

}

/**
 * (Hra) Getter na pomocníka.
 */


/**
 * (Hra) Metóda na vytvorenie novej hry. Prepíš všetko, čo doteraz bolo uložené a spustí hru odznovu.
 */


/**
 * (Hra) Metóda na pokračovanie v už uloženej hre. Načíta si z pamäte uloženú hru.
 */


/**
 * (Hra) Pomocník pre hráča, slúži ako zoznam pravidiel a textovy úvod do samotnej hry.
 */
