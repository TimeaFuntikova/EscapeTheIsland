package ski.uniza.fri.hra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://stackoverflow.com/questions/23034675/how-to-build-a-java-main-menu

public class HlavneMenu extends JFrame implements ActionListener {

    private final Hra hra;
    private final int width = 300;
    private final int height = 100;


    /**
     * (HlavneMenu) Vytvorenie inštanciií buttonov. Nastavenie layoutu na CardLayout.
     */
    JButton play = new JButton("play");
    JButton exit = new JButton("exit");

    CardLayout layout = new CardLayout();

    JPanel okno = new JPanel();
    JPanel menu = new JPanel();

    public HlavneMenu(Hra hra) {
        this.hra = hra;

       this.okno.setLayout(layout);
        this.layout.addLayoutComponent(okno, "Menu");

        this.pridajButtony();

        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Escape The Island");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        requestFocus();
    }

    private void pridajButtony() {
        this.menu.add(this.play);
        this.menu.add(this.exit);

        //background colors
        this.menu.setBackground(new Color(24, 44, 18, 255));

        //nastavenie listenerov :
        this.play.addActionListener(this);
        this.exit.addActionListener(this);
       // this.okno.add(this.menu, "Menu");

        add(this.okno);
        layout.show(okno, "Menu");

    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == exit) {
            System.exit(0);
        } else if (source == play) {
            JOptionPane.showInternalMessageDialog(null, "Hra sa začala.");
            this.zacniHrat();
        }

    }

    // treba vyriesit aby sa zmenial textura po zacati hry na plaz
    public void zacniHrat() {

        System.out.println("hra zacala.");
    }

}