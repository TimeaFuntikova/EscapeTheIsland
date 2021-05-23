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
 * Vytvára inštacie potrebné na začatiem priebeh a ukončenie hry.
 *
 * @author Timea Funtíková
 * @version 1.0 (4.4.2021)
 */
public class Hra extends ApplicationAdapter { // len tu. kde sa extenduje ApplicationAdapter sa dakjú urobiť GDX inputy.

    //--------------------------
    // Atribúty pre triedu Hra
    //--------------------------

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

    /**
     * (Hra) Metóda na vytvorenie novej hry. Prepíš všetko, čo doteraz bolo uložené a spustí hru odznovu.
     *
     */
    @Override
    public void create() {
        this.font = new BitmapFont();
        this.vykreslovacPredmetov = new VykreslovacPredmetov();
        this.vykreslovacPozadiLokalit = new VykreslovacPozadiLokalit();
        this.batch = new SpriteBatch();
        this.generatorPredmetov = new GeneratorPredmetov();
        this.generatorLokalit = new GeneratorLokalit(this.generatorPredmetov);
        this.ovladanie = new Ovladanie();
        this.lokalita = new Lokalita(this.generatorLokalit); //vytvori sa lokalita bez nazvu
        this.generatorLokalit.vytvorLokality(); // vytvori prazdne konkretne lokality
        this.lokalita = new Lokalita(this.generatorLokalit); //vytvori sa lokalita bez nazvu
        this.generatorLokalit.nastavAktualnuLokalitu(this.generatorLokalit.getLes()); //za aktualnu sa na zaciatok nastavi uvodna lokalita

        //treba najskor zavolat vytvorenie lokalit inak generator predmetov pracuje s prázdnou inštanciou

        this.postava = new Postava(this.lokalita, this.vykreslovacPredmetov, this.batch); //postava bez aktualnej lokality ale schopna sa neskor vykreslit
        this.generatorPredmetov.initGeneratorPredmetov(this.vykreslovacPredmetov, this.generatorLokalit, this.postava); //len init 3 parametrov

        this.postava.dajPostaveRuksak();
        this.ovladanie = new Ovladanie(this.postava, this.batch, this.vykreslovacPredmetov, this.generatorLokalit, this.vykreslovacPozadiLokalit);
        this.generatorPredmetov.naplnLokality(); //do vytvorených inštancii sa pridajú predmety na pozíciach ale ešte sa nevykreslia.
        this.postava.aktualizujOvladanie(this.ovladanie);
        //this.hlavneMenu = new HlavneMenu(this);

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
        this.postava.nastalaKolizia();

        //pomoc debug:
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            this.hlavneMenu = new HlavneMenu(this); //ukaze sa menu pri odchode z hry.
            //System.exit(0);
        }
        this.font.draw(this.batch, this.postava.vypisEnergiu(), 10,Gdx.graphics.getHeight() - 20);
        this.font.draw(this.batch, "Predmety v ruksaku: " + this.postava.dajPredmetyVRuksaku().keySet(), 10, Gdx.graphics.getHeight() - 40);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
