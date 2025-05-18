package nepriatelia;

import predmety.Predmet;
import predmety.jedleVeci.Rozok;
import predmety.zbrane.Exkkalibur;
import predmety.zbrane.Zbran;

public class Clovek extends Nepriatel {

    private Predmet poklad = new Rozok();
    private Zbran ex = new Exkkalibur();

    public Clovek(String meno, int zivot, int utok, int obrana, int uroven) {
        super(meno, zivot, utok, obrana, uroven);

        this.nasadPredmet(this.poklad);
        this.nasadPredmet(this.ex);
    }



}
