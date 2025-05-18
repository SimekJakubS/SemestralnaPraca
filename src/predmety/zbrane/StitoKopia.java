package predmety.zbrane;

import hracAssety.Hrac;

public class StitoKopia implements Zbran {
    private final int hodnota;
    private final String nazov;

    public StitoKopia() {
        this.nazov = "Štitokopia, každý útok zvyšuje obranu o 1";
        this.hodnota = 9;
    }

    @Override
    public void pouzi(Hrac hrac) {
        hrac.upravObranu(1);
    }

    @Override
    public int getHodnota() {
        return this.hodnota;
    }

    @Override
    public int getUtokModifier() {
        return this.getHodnota();
    }

    @Override
    public String getNazov() {
        return this.getNazov();
    }
}
