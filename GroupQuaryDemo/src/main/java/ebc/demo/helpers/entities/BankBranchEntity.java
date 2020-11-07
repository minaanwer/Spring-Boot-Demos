package ebc.demo.helpers.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "admin", name = "bank_branch")
public class BankBranchEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name" , length = 64 , nullable = false)
    private String name;
    @Column(name = "location", length =  128, nullable = true)
    private String location;
    @Column(name = "is_cbe", nullable = false)
    private Boolean isCBE;
    @Column(name = "is_main_branch", nullable = false)
    private Boolean isMainBranch;
    private BankBranchEntity(int id){
        this.id = id;
    }
    public static BankBranchEntity of(int id){
        return new BankBranchEntity(id);
    }
}
