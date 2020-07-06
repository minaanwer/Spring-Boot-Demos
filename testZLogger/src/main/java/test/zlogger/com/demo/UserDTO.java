package test.zlogger.com.demo;

public class UserDTO {

    String name ;
    String age ;
    String nationality ;
    Tele myTele ;




    public Tele getMyTele() {
        return myTele;
    }

    public void setMyTele(Tele myTele) {
        this.myTele = myTele;
    }

    public UserDTO(String name, String age, String nationality, Tele myTele) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.myTele = myTele;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}





