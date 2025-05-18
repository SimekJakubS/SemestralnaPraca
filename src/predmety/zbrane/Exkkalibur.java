package predmety.zbrane;
import hracAssety.Hrac;
import predmety.Predmet;

public class Exkkalibur implements Zbran, Predmet {

    private final int hodnota;
    private final String nazov;

    public Exkkalibur() {
        this.hodnota = 10;
        this.nazov = "EXkkalibur, lieči počas útoku";
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("XKalibur lieči!");
        hrac.liec(8);
    }

    @Override
    public String getNazov() {
        return "Exkkalibur";
    }

    @Override
    public int getHodnota() {
        return this.hodnota;
    }

    @Override
    public int getUtokModifier() {
        return this.getHodnota() + 1;
    }

    @Override
    public String toString() {
        return "Mec ktory lieci pri kazdom udere 20 hp";
    }
}
