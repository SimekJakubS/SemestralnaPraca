package predmety.jedleVeci;

import hracAssety.Hrac;

public class LiecivyKoktejl implements LiecivyPredmet {

    private final String nazov;
    private final int hodnota;

    public LiecivyKoktejl() {
        this.nazov = "Liečivý koktejl";
        this.hodnota = 30;
    }

    @Override
    public void specialnyEfekt(Hrac hrac) {
        hrac.liec(this.getHodnota());
        System.out.println(hrac.getMeno()
                + " použil " + this.getNazov());
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
}
