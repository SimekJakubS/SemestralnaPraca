package hlavneCasti;

import hlavnaPonuka.Menu;
import hlavneCasti.Hra;

public class Main {
    public static void main(String[] args) {

        Menu m = new Menu();

        //starting new game
        Hra hra = new Hra();
        hra.spusti();
    }
}