package ski.uniza.fri.hra;

import javax.swing.*;
import java.awt.*;

public class Ruksacik {
    private JFrame jFrame;
    private JPanel panel;
    private JList zoznamPredmetovList;
    private JButton poskladajNovyButton;
    private JButton zatvorRuksakButton;

    public Ruksacik() {
        this.jFrame = new JFrame("Zoznam predmetov v ruksaciku");
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jFrame.add(this.panel); //pridávam panel, ktorý nikdy neinicializujem
        this.jFrame.pack(); //window sa spraví do normálne požadovanej velkosti a komponenty sa tam zmestia

        this.jFrame.setResizable(true);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setMinimumSize(new Dimension(400, 300));

        this.jFrame.setVisible(true);

    }
}
