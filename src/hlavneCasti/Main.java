package hlavneCasti;

//import hlavnaPonuka.HerneMenu;

import hracAssety.Hrac;
import predmety.Predmet;
import predmety.jedleVeci.LiecivyKoktejl;
import predmety.zbrane.Exkkalibur;
import predmety.zbrane.Zbran;

public class Main {
    public static void main(String[] args) {
        Hrac hrac = new Hrac("Jakub", 200, 20, 4, 10);
        Zbran e = new Exkkalibur();
        hrac.nasadPredmet(e);
        Predmet l = new LiecivyKoktejl();
        hrac.nasadPredmet(l);

        Arena a = new Arena(hrac);


        //HerneMenu h = new HerneMenu();
    }
}