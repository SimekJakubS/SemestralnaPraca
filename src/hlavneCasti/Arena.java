package hlavneCasti;

import hracAssety.Hrac;
import nepriatelia.Clovek;
import nepriatelia.Nepriatel;
import nepriatelia.Robot;
import predmety.Predmet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arena {

    private ArrayList<Nepriatel> nepriatelia = new ArrayList<>();
    private Hrac hrac;
    private int skore;
    private Scanner scanner = new Scanner(System.in);

    public Arena(Hrac hrac) {
        this.hrac = hrac;
        System.out.println(this.hrac.toString());
        this.nepriatelia.add(new Clovek("Rytier Jano", 90, 13, 20, 10));
        this.nepriatelia.add(new Robot("Robot Xw23!", 20, 13, 20, 10));
        this.nepriatelia.add(new Robot("Robot KKww2", 79, 15, 20, 10));
        this.nepriatelia.add(new Robot("Robot 33!de", 57, 20, 20, 10));

        this.hraj();
    }

    private void hraj() {
        this.zobrazMenu();
        for (Nepriatel n : this.nepriatelia) {
            this.suboj(n);
            this.zobrazMenu();
        }
    }

    private void suboj(Nepriatel nepriatel) {
        System.out.println("Začína súboj medzi " + this.hrac.getMeno() + " a " + nepriatel.getMeno());
        //System.out.println(nepriatel.toString());

        while (this.hrac.jeNazive() && nepriatel.jeNazive()) {
            this.hrac.utoc(nepriatel);

            if (!nepriatel.jeNazive()) {
                this.zobrazLootMenu(this.hrac, nepriatel.getInventar());
                break;
            }

            nepriatel.utoc(this.hrac);
        }

        String vitaz = this.hrac.jeNazive() ? this.hrac.getMeno() : nepriatel.getMeno();
        System.out.println("Víťaz: " + vitaz);

        this.skusCiJeKoniec();
    }

    private void zobrazLootMenu(Hrac hrac, List<Predmet> loot) {
        if (loot.isEmpty()) {
            System.out.println("Nepriateľ nemá žiadne poklady.");
            return;
        }

        this.scanner = new Scanner(System.in);
        System.out.println("\n===== Poklady od porazeného =====");
        System.out.print("Chceš lootovať predmety od porazeného nepriateľa? Stlač 1");

        if (this.scanner.hasNextInt()) {
            int volba = this.scanner.nextInt();
            this.scanner.nextLine();

            if (volba == 1) {
                if (!loot.isEmpty()) {
                    for (Predmet predmet : loot) {
                        hrac.nasadPredmet(predmet);
                        System.out.println("Získal si: " + predmet.getNazov());
                    }
                } else {
                    System.out.println("Nezobral si žiadny loot.");
                }

            } else {
                System.out.println("Nezobral si žiadny loot.");
            }
        } else {
            System.out.println("Kradnutie zrušené.");
            this.scanner.nextLine();
        }
    }

    private void zobrazMenu() {
        boolean bezat = true;

        while (bezat) {
            System.out.println("\n===== Hlavné Menu =====");
            System.out.println("1. Zobraziť Inventár");
            System.out.println("2. Zobraziť Štatistiky");
            System.out.println("3. Boj!!!");
            System.out.println("4. Ukončiť Hru");
            System.out.print("Vyber možnosť: ");

            if (this.scanner.hasNextInt()) {
                int volba = this.scanner.nextInt();
                this.scanner.nextLine();

                switch (volba) {
                    case 1:
                        this.hrac.spravujInventar();
                        break;
                    case 2:
                        System.out.println("----------");
                        System.out.println("-> " + this.hrac.toString());
                        break;
                    case 3:
                        System.out.println("Boj pokračuje...");
                        bezat = false;
                        // TODO: sprav suboje tu

                        break;
                    case 4:
                        System.out.println("Ukončujem hru...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Neplatný vstup! Zadajte číslo od 1 do 4.");
                        break;
                }
            } else {
                System.out.println("Neplatný vstup! Zadajte číslo od 1 do 4.");
                this.scanner.nextLine();
            }
        }
    }

    private void skusCiJeKoniec() {
        if (!this.hrac.jeNazive()) {
            System.out.println("--------------------------------");
            System.out.println("->>> Koniec hry <<<-");
            System.out.println("->>> Dosiahol si skóre " + this.skore + " <<<-");
            System.exit(0);
        } else {
            this.skore += 1;
        }
    }

}
