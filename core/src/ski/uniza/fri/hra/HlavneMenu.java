package ski.uniza.fri.hra;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ski.uniza.fri.mapa.GeneratorLokalit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://stackoverflow.com/questions/23034675/how-to-build-a-java-main-menu

public class HlavneMenu extends JFrame implements ActionListener {

    private final Hra hra;
    private final int width = 300; // okamžitá inicializácia
    private final int height = 100;

    private GeneratorLokalit generatorLokalit;
    private Texture plazTexture;

    /**
     * (HlavneMenu) Vytvorenie inštanciií buttonov. Nastavenie layoutu na CardLayout.
     */
    JButton play = new JButton("play");
    JButton settings = new JButton("settings");
    JButton exit = new JButton("exit");
    //JButton mainMenu = new JButton("main menu");

    CardLayout layout = new CardLayout();

    JPanel okno = new JPanel();
    JPanel menu = new JPanel();
    private SpriteBatch batch;

    public HlavneMenu(Hra hra) {
        this.hra = hra;

        this.okno.setLayout(layout);
        this.layout.addLayoutComponent(okno, "Menu");
        this.addButtons();

        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Escape The Island");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        requestFocus();
    }

    private void addButtons() {
        //menu buttons
        this.menu.add(this.play);
        this.menu.add(this.settings);
        this.menu.add(this.exit);

        //background colors
        this.menu.setBackground(new Color(24, 44, 18, 255));

        //nastavenie listenerov :
        this.play.addActionListener(this);
        this.settings.addActionListener(this);
        this.exit.addActionListener(this);
        //mainMenu.addActionListener(this);

        //adding children to parent Panel
        this.okno.add(this.menu, "Menu");

        add(this.okno);
        layout.show(okno, "Menu");

    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == exit) {
            System.exit(0);
        } else if (source == play) {
            //layout.show(panel, "Game");
            JOptionPane.showInternalMessageDialog(null, "Hra sa začala.");
            this.zacniHrat();
        } else if (source == settings) {
        }

    }

    // treba vyriesit aby sa zmenial textura po zacati hry na plaz
    public void zacniHrat() {
        if (this.hra.isHraZacala()) {
            //Gdx.input.isKeyPressed(Input.Keys.ENTER);
            System.out.println("hra zacala.");
            this.hra.setHraZacala(false);

            plazTexture = new Texture("plaz.png");
            plazTexture.dispose();
        }
    }

}