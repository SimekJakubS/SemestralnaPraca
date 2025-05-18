package predmety.jedleVeci;

import hracAssety.Hrac;

public class Pozehnanie implements LiecivyPredmet {
    private final int hodnota;
    private final String nazov;

    public Pozehnanie() {
        this.nazov = "Požehnanie";
        this.hodnota = 10;
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.specialnyEfekt(hrac);
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public int getHodnota() {
        return this.hodnota;
    }

    @Override
    public void specialnyEfekt(Hrac hrac) {
        hrac.zvysUtok(this.getHodnota());
        System.out.println(hrac.getMeno()
                + " použil " + this.getNazov() + " a zvýšil útok o " + this.getHodnota() + " na jednu bitku.");
    }
}
