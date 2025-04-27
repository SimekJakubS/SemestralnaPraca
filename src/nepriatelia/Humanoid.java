package nepriatelia;

public class Humanoid implements Nepriatel {

    private int hp;

    public Humanoid(int hp) {

        this.hp = hp;

    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String smrtHlaska() {
        return "AAAAAH ZOMREL SOM";
    }

    @Override
    public String utokHlaska() {
        return "AAAAAH!";
    }
}
