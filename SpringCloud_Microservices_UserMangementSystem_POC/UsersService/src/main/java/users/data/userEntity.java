package users.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table()
public class userEntity implements Serializable {




    private static final long serialVersionUID = -6655522883488945895L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false,length = 50)
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String firstname ;

    @Column(nullable = false,length = 50)
    private String lastname;

    @Column(nullable = false,length = 50)
    private String  email;

    @Column(nullable = false,length = 500)
    private String password;

    @Column(nullable = false,length = 50)
    private String userId;

    @Column(nullable = false,length = 50)
    private String encryptedPassword;


    public userEntity() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
