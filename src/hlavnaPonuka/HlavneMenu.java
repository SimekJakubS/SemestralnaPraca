package hlavnaPonuka;
import hlavneCasti.Hra;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HlavneMenu {
    private JPanel panelMenu;
    private JPanel panelHra;
    private JButton buttonMenu;
    private JFrame okno;
    private Hra hra;

    public HlavneMenu() {
        this.okno = new JFrame("Hlavne menu");
        this.okno.setContentPane(this.panelMenu);
        this.okno.setSize(350, 300);
        this.okno.setVisible(true);
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.buttonMenu.addActionListener(e -> {

            this.okno.dispose();
            this.hra = new Hra();

        });


    }
}
