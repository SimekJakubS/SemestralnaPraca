package nepriatelia;

public class Clovek extends Humanoid implements Nepriatel {

    public Clovek() {
        super(2000);


    }


    @Override
    public String smrtHlaska() {
        return "NIEEE MOJ LUDSKY KMEN, OPUSTAM VAS!";
    }

    @Override
    public String utokHlaska() {
        return "MOJA SMRT NIEJE KONIEC!";
    }
}
