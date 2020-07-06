package test.zlogger.com.demo;

public class Tele {

    String num ;
    String numMain;
    Tele2 tele2;

    public Tele() {

    }

    public Tele(String num, String numMain , Tele2 tele2) {
        this.num = num;
        this.numMain = numMain;
        this.tele2 = tele2;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNumMain() {
        return numMain;
    }

    public void setNumMain(String numMain) {
        this.numMain = numMain;
    }

    public Tele2 getMyTele() {
        return tele2;
    }

    public void setMyTele(Tele2 myTele) {
        this.tele2 = myTele;
    }


}
