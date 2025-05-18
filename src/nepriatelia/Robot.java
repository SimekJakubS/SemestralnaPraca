package nepriatelia;

import hracAssety.Hrac;

public class Robot extends Nepriatel {

    public Robot(String meno, int zivot, int utok, int obrana, int uroven) {
        super(meno, zivot, utok, obrana, uroven);
    }

    @Override
    public void utoc(Hrac nepriatel) {
        //System.out.println(this.utok);
        System.out.println(getMeno() + " útočí na " + nepriatel.getMeno() + " dvojitou strelbou!");
        System.out.println("Spôsobuje " + getUtok() + " bodov poškodenia.");
        nepriatel.sposobPoskodenie(getUtok());
        System.out.println("Spôsobuje " + getUtok() + " bodov poškodenia.");
        nepriatel.sposobPoskodenie(getUtok());
    }


}
