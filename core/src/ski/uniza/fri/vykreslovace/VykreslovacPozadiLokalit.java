package ski.uniza.fri.vykreslovace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Trieda VykreslovacPozadiLokalit slúži na vykreslenie pozadia akutálnej lokality, v ktorej sa postava nachádza.
 * textúry sa potom načítavajú v metóde vykresliPozadieLokality v triede GeneratorLokalit.
 */
public class VykreslovacPozadiLokalit extends ApplicationAdapter {

    //----------------------------------------------
    // Atribúty pre triedu VykreslovacPozadiLokalit
    //----------------------------------------------

    private Texture texture;

    /**
     * (VykreslovacPozadiLokalit) Bezparametricky konstruktor triedy VykreslovacPozadiLokalit.
     */
    public VykreslovacPozadiLokalit() {}

    public Sprite getPlazTexture() {
        return new Sprite(new Sprite(this.texture = new Texture("plaz.png")));
    }

    public Sprite getLesTexture() {
        return new Sprite(new Sprite(this.texture = new Texture("les.png")));
    }

    public Sprite getLietadloTexture() {
        return new Sprite(new Sprite(this.texture = new Texture("lietadlo.png")));
    }

    public Sprite getVodopadTexture() {
        return new Sprite(new Sprite(this.texture = new Texture("vodopad.png")));
    }

    public Sprite getCestaTexture() {return new Sprite (new Sprite(this.texture = new Texture("cesta.png")));}

    public Sprite getUtesTexture() {return new Sprite (new Sprite(this.texture = new Texture("utes.jpg")));}

    public Sprite getSecretTexture() {return new Sprite (new Sprite(this.texture = new Texture("secret.png")));}

    /**
     * (VykreslovacPozadiLokalit) Metóda dispose z Cdx knižnice na prácu s texturou.
     */
    public void dispose() {
        this.texture.dispose();
    }


}
