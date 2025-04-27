package hlavneCasti;

import hracAssety.Hrac;
import nepriatelia.Clovek;
import nepriatelia.Humanoid;
import nepriatelia.Nepriatel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hra {

    private final JFrame okno;
    private JTextArea textSuboj;
    private JPanel panelHra;
    private Hrac hrac;
    private Clovek clovek;
    private Humanoid humanoid;
    private boolean pomocnaPremenna = false;
    private Timer timer;
    private Nepriatel aktualnyNepriatel;

    public Hra() {
        this.okno = new JFrame("Vesmírny Súboj");
        this.textSuboj = new JTextArea(10, 30);
        this.textSuboj.setEditable(false);

        this.panelHra = new JPanel();
        this.panelHra.add(new JScrollPane(Hra.this.textSuboj));
        this.okno.setContentPane(this.panelHra);
        this.okno.setSize(400, 300);
        this.okno.setVisible(true);
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.hrac = new Hrac();
        this.clovek = new Clovek();
        this.humanoid = new Humanoid(1200);

        this.spustiSuboj(this.clovek);
        this.spustiSuboj(this.humanoid);

    }

    private void spustiSuboj(Nepriatel nepriatel) {
        Hra.this.aktualnyNepriatel = nepriatel;

        Hra.this.timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Hra.this.hrac.getHp() > 0 && Hra.this.aktualnyNepriatel.getHp() > 0) {
                    Hra.this.hrac.setHp(Hra.this.hrac.getHp() - 220);
                    Hra.this.aktualnyNepriatel.setHp(Hra.this.aktualnyNepriatel.getHp() - 200);

                    Hra.this.textSuboj.append(Hra.this.aktualnyNepriatel.utokHlaska() + "\n");
                    Hra.this.textSuboj.append(
                            "hrac hp: " + Hra.this.hrac.getHp() + " | enemy hp: " + Hra.this.aktualnyNepriatel.getHp() + "\n");
                } else {
                    Hra.this.timer.stop();
                    if (!Hra.this.pomocnaPremenna) {
                        if (Hra.this.hrac.getHp() <= 0 && Hra.this.aktualnyNepriatel.getHp() <= 0) {
                            Hra.this.textSuboj.append("\n remiza \n");
                        } else if (Hra.this.hrac.getHp() <= 0) {
                            Hra.this.textSuboj.append("\n prehral si \n");
                        } else if (Hra.this.aktualnyNepriatel.getHp() <= 0) {
                            Hra.this.textSuboj.append("\n vyhra! \n");
                        }
                        Hra.this.pomocnaPremenna = true;
                    }




                }
            }
        });

        Hra.this.timer.start();
    }

}




//    private final JFrame okno;
//    private JLabel textSuboj;
//    private JPanel panelHra;
//    private Hrac hrac;
//    private Clovek clovek;
//    private Humanoid humanoid;
//
//    public Hra() {
//        this.okno = new JFrame("Vesmirny Suboj"); //TODO pohraj sa s tymto ptm
//        this.okno.setContentPane(this.panelHra);
//        this.okno.setSize(350, 300);
//        this.okno.setVisible(true);
//        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        this.hrac = new Hrac();
//        this.clovek = new Clovek();
//        this.humanoid = new Humanoid(1200);
//        this.suboj(this.clovek);
//        this.suboj(this.humanoid);
//    }
//
//    private void suboj(Nepriatel nepriatel) { //TU JE POLYMORFIZMUS
//
//        while (this.hrac.getHp() > 0 && nepriatel.getHp() > 0) {
//            this.hrac.setHp(this.hrac.getHp() - 220);
//            nepriatel.setHp(nepriatel.getHp() - 200);
//            this.textSuboj.setText(nepriatel.utokHlaska());
//            this.okno.revalidate();
//
//            System.out.println("hrac hp:" + this.hrac.getHp());
//            System.out.println("npc hp:" + nepriatel.getHp());
//
//        }
//    }



