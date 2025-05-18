package predmety.zbrane;
import hracAssety.Hrac;
import predmety.jedleVeci.LiecivyPredmet;

public class Ingrid implements Zbran, LiecivyPredmet {
    private final int hodnota;
    private final String nazov;

    public Ingrid() {
        this.hodnota = 10;
        this.nazov = "Ingrid, pozehnanie utoku";
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.specialnyEfekt(hrac);
    }

    @Override
    public int getHodnota() {
        return this.hodnota;
    }

    @Override
    public int getUtokModifier() {
        return this.hodnota;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void specialnyEfekt(Hrac hrac) {
        hrac.zvysUtok(2);
    }
}
