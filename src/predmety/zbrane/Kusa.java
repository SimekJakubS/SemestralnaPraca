package predmety.zbrane;

import hracAssety.Hrac;

public class Kusa implements Zbran {

    private int pocetSipov;
    private final String nazov;
    private final int hodnota;

    public Kusa(int pocetSipov) {
        this.pocetSipov = 10;
        this.nazov = "Štitokopia, každý útok zvyšuje obranu o 1";
        this.hodnota = 25;
    }

    @Override
    public void pouzi(Hrac hrac) {

    }

    @Override
    public int getHodnota() {
        return this.hodnota;
    }

    @Override
    public int getUtokModifier() {
        if (this.pocetSipov > 0) {
            this.pocetSipov -= 1;
            return 25;
        } else {
            System.out.println("Došli ti šípy, udieraš kušou");
            return 5;
        }
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }
}
