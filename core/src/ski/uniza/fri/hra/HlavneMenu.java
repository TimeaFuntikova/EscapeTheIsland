package ski.uniza.fri.hra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://stackoverflow.com/questions/23034675/how-to-build-a-java-main-menu

public class HlavneMenu extends JFrame implements ActionListener {

    //--------------------------------
    // Atribúty pre triedu HlavneMenu
    //--------------------------------

    private final Hra hra;
    private final int width = 300;
    private final int height = 100;
    private CardLayout layout = new CardLayout();
    private JButton play = new JButton("play");
    private JButton exit = new JButton("exit");
    private JPanel okno = new JPanel();
    private JPanel menu = new JPanel();

    /**
     * (HlavneMenu) Vytvorenie inštanciií buttonov. Nastavenie layoutu na CardLayout.
     */
    public HlavneMenu(Hra hra) {
        this.hra = hra;
        this.okno.setLayout(layout);
        this.layout.addLayoutComponent(okno, "Menu");
        this.pridajButtony();
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Escape The Island");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.requestFocus();
    }

    private void pridajButtony() {
        this.menu.add(this.play);
        this.menu.add(this.exit);
        this.menu.setBackground(new Color(24, 44, 18, 255));

        //nastavenie listenerov :
        this.play.addActionListener(this);
        this.exit.addActionListener(this);
        this.okno.add(this.menu, "Menu");
        this.add(this.okno);
        layout.show(okno, "Menu");

    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == exit) {
            System.exit(0);
        } else if (source == play) {
            this.setVisible(false);
        }
    }

}