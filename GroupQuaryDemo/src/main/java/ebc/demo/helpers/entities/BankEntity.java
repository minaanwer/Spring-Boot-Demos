package ebc.demo.helpers.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "admin", name = "bank")
public class BankEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "english_name" , length = 70 , nullable = false)
    private String englishName;
    @Column(name = "arabic_name" , length = 70 , nullable = false)
    private String arabicName;
    @Column(name = "short_name", length = 15, nullable = false)
    private String shortName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="bank_id", nullable=false)
    private Set<BankBranchEntity> branches;
    private BankEntity(int id){
        this.id = id;
    }
    public static BankEntity of(int id){
        return new BankEntity(id);
    }
}
