package test.zlogger.com.demo.Model;

public class UserDTO {

    String name ;
    String age ;
    String nationality ;
    ChildOne myTele ;


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

    public ChildOne getMyTele() {
        return myTele;
    }

    public void setMyTele(ChildOne myTele) {
        this.myTele = myTele;
    }

    public UserDTO() {
    }

    public UserDTO(String name, String age, String nationality, ChildOne myTele) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.myTele = myTele;
    }
}





