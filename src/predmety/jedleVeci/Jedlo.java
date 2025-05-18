package predmety.jedleVeci;


import hracAssety.Hrac;

public class Jedlo implements LiecivyPredmet {

    private String nazov;
    private int hodnota;

    public Jedlo() {
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
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
        hrac.liec(this.hodnota);
    }
}
