package nepriatelia;

import hracAssety.Hrac;
import predmety.Predmet;

public class Nepriatel extends Hrac {

    public Nepriatel(String meno, int zivot, int utok, int obrana, int uroven) {
        super(meno, zivot, utok, obrana, uroven);

    }

    public Predmet zoberPredmety() {
        return this.getInventar().get(0);
    }
}
