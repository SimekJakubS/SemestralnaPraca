package nepriatelia;

import hracAssety.Hrac;
import predmety.zbrane.Ingrid;

public class Sliz extends Nepriatel {
    public Sliz(String meno, int zivot, int utok, int obrana, int uroven) {
        super(meno, zivot, utok, obrana, uroven);

        this.nasadPredmet(new Ingrid());

    }

    @Override
    public void utoc(Hrac nepriatel) {
        super.utoc(nepriatel);
        this.zvysUtok(1);
    }
}
