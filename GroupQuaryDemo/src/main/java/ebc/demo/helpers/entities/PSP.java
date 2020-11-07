package ebc.demo.helpers.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(schema = "dbo", name = "\"PSP\"")
@JacksonXmlRootElement(localName = "PSP")
public class PSP {
    @JsonIgnore
    @Column(name = "\"Id\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"ArName\"", length = 100)
    public String arName;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"EnName\"", length = 100)
    public String enName;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"Handles\"", length = 100)
    public String handles;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"isActive\"", length = 1)
    public String active;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"Url\"", length = 50)
    public String url;
    @JacksonXmlProperty(isAttribute = true)
    @Column(name = "\"SupVersions\"", length = 100)
    public String supVersions;
}