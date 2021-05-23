package ski.uniza.fri.vykreslovace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * (Vykreslovac predmetov) Sluzi na zobrazenie objektov, ktorymi je mozne pocas hry manipulovat.
 *
 * @author Timea Funtíková
 * @version 1.0 (12.4.2021)
 *
 */
public class VykreslovacPredmetov extends ApplicationAdapter {
    private Texture texture;

    public VykreslovacPredmetov() {}

    /**
     * ------------------------REFAKTORING TEXTURY HRACA ____________________________________
     *
     */

    public Sprite getPlayerTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("postavaspredu1.png")));
    }

    public Sprite[] getPlayerMovingDown() {
        return new Sprite[]{(new Sprite(this.texture = new Texture("postavaspredu3.png"))),
                new Sprite(this.texture = new Texture("postavaspredu2.png"))
        };
    }

    public Sprite[] getPlayerMovingUp() {
        return new Sprite[]{(new Sprite(this.texture = new Texture("postavazozadu3.png"))),
                new Sprite(this.texture = new Texture("postavazozadu2.png"))
        };
    }

    public Sprite[] getPlayerMovingRight() {
        return new Sprite[]{(new Sprite(this.texture = new Texture("postavaVpravo1.png"))),
                new Sprite(this.texture = new Texture("postavaVpravo2.png")),
                new Sprite(this.texture = new Texture("postavavpravo3.png"))
        };
    }

    public Sprite[] getPlayerMovingLeft() {
        return new Sprite[]{(new Sprite(this.texture = new Texture("postavaVlavo3.png"))),
                new Sprite(this.texture = new Texture("postavaVlavo2.png")),
        };
    }

    public Sprite getKokosTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("kokos.png")));
    }

    public Sprite getDrevoTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("drevo.png")));
    }

    public Sprite getPatykTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("patyk.png")));
    }

    public Sprite getKamenTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("kamen.png")));
    }

    public Sprite getLodTexture() {
        return new Sprite (new Sprite(this.texture = new Texture("lod.png")));
    }



    public void dispose() {
        this.texture.dispose();
    }

}
