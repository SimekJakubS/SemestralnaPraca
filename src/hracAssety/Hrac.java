package hracAssety;

import predmety.Predmet;
import predmety.zbrane.Zbran;

import java.util.*;

public class Hrac {

    private final String meno;
    private int zivot;
    private int utok;
    private int obrana;
    private int level;
    private int skusenosti;
    private ArrayList<Predmet> inventar;
    private Zbran zbran;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Hrac (String meno, int zivot, int utok, int obrana, int level) {
        this.meno = meno;
        this.zivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.level = level;
        this.skusenosti = 0;
        this.inventar = new ArrayList<>();

        this.zivot += level * 17;
        this.utok += level + 5;
        this.obrana += level;

    }

    public void nasadPredmet(Predmet predmet) {
        if (predmet instanceof Zbran) {
            this.zbran = (Zbran)predmet;
            System.out.println("Nasadená nová zbraň: " + this.zbran.getNazov());
        } else {
            this.inventar.add(predmet);
            System.out.println("Predmet pridaný do inventára: " + predmet.getNazov());
        }
    }

    public void utoc(Hrac nepriatel) { //TODO: aplikuj obranu!
        int pridanyUtok = 0;

        if (this.zbran != null) {
            this.zbran.pouzi(this);
            pridanyUtok = this.zbran.getHodnota();
        }

        nepriatel.zivot -= (this.utok + pridanyUtok) - this.getObrana();
        System.out.println(this.meno + " útočí na " + nepriatel.meno + " za " + this.utok + " poškodenia.");
        if (!nepriatel.jeNazive()) {
            this.ziskajSkusenosti(nepriatel.getLevel() * 5);
        }
    }

    public int getObrana() {
        return this.random.nextInt(this.obrana + 1);
    }

    public boolean jeNazive() {
        return this.zivot > 0;
    }

    public void liec(int hp) {
        this.zivot += hp;
        System.out.println(this.meno + " sa lieči o " + hp + " životov.");
    }

    private void ziskajSkusenosti(int xp) {
        this.skusenosti += xp;
        if (this.skusenosti >= 100) {
            this.skusenosti -= 100;
            this.levelUp();
        }
    }

    private void levelUp() {
        this.level++;
        this.utok += 5;
        this.obrana += 3;
        this.zivot += 50;
        System.out.println(this.meno + " postúpil na úroveň " + this.level + "!");
        System.out.println("Útok: " + this.utok + ", Obrana: " + this.obrana + ", Život: " + this.zivot);
    }

    public void zvysUtok(int hodnota) {
        this.utok += hodnota;
    }

    public String getMeno() {
        return this.meno;
    }

    public int getZivot() {
        return this.zivot;
    }

    public int getLevel() {
        return this.level;
    }

    public int getUtok() {
        return this.utok;
    }

    public void upravObranu(int hodnota) {
        this.obrana += hodnota;
    }

    @Override
    public String toString() {
        return ("Útok: " + this.utok + ", Obrana: " + this.obrana + ", Život: " + this.zivot);
    }

    public void sposobPoskodenie(int dmg) {
        this.zivot -= dmg;
    }

    public List<Predmet> getInventar () {
        return Collections.unmodifiableList(this.inventar);
    }

    public void spravujInventar() {
        if (this.inventar.isEmpty()) {
            System.out.println("Inventár je prázdny.");
            return;
        }

        System.out.println("\n===== Inventár =====");
        for (int i = 0; i < this.inventar.size(); i++) {
            System.out.println((i + 1) + ". " + this.inventar.get(i).getNazov());
        }

        System.out.print("Vyber predmet na použitie, inak stlač čokoľvek iné:");
        if (this.scanner.hasNextInt()) {
            int volba = this.scanner.nextInt();
            this.scanner.nextLine();

            if (volba > 0 && volba <= this.inventar.size()) {
                Predmet vybranyPredmet = this.inventar.get(volba - 1);
                vybranyPredmet.pouzi(this);
                this.inventar.remove(volba - 1);
                System.out.println("Používam: " + vybranyPredmet.getNazov());
            } else {
                System.out.println("Neplatná voľba.");
            }
        } else {
            System.out.println("Neplatný vstup! Zadajte číslo.");
            this.scanner.nextLine();
        }
    }
}
