package hlavnaPonuka;

import hlavneCasti.UrovneSuboja;
import hracAssety.Hrac;
import java.util.Scanner;

public class HerneMenu {
    public HerneMenu() {
        Scanner scanner = new Scanner(System.in);
        String meno = "";
        int obtiaznost;

        while (true) {
            System.out.println("=== Herné menu ===");
            System.out.println("1. Zadať meno hráča");
            System.out.println("2. Ukončiť hru");
            System.out.print("Vyberte možnosť: ");
            int volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
                    System.out.print("Zadajte meno hráča: ");
                    meno = scanner.nextLine();
                    System.out.println("Meno hráča nastavené na: " + meno);

                    System.out.print("Zadajte úroveň obtiažnosti (1 - ľahká, 2 - stredná, 3 - ťažká): ");
                    obtiaznost = scanner.nextInt();
                    scanner.nextLine();

                    if (obtiaznost >= 1 && obtiaznost <= 3) {
                        System.out.println("Obtiažnosť nastavená na: " + obtiaznost);

                        Hrac hrac = new Hrac(meno, 100, 20, 5, (4 - obtiaznost) * 9);
                        System.out.println(hrac.toString());
                        UrovneSuboja uroven = new UrovneSuboja();

                        System.out.println("Hráč " + hrac.getMeno() + " je pripravený na úroveň: " + obtiaznost);
                        return;
                    } else {
                        System.out.println("Neplatná úroveň obtiažnosti.");
                    }
                    break;

                case 2:
                    System.out.println("Hra ukončená.");
                    return;

                default:
                    System.out.println("Neplatná voľba. Skúste znova.");
            }
        }
    }
}