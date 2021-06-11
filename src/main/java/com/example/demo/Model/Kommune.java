package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kommune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long kommunekode;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sogne> sogne;
    private String navn;


    public Kommune(long kommunekode, String navn) {
        this.kommunekode = kommunekode;
        this.navn = navn;
    }

    public Kommune(){

    }

    public long getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(long kommunekode) {
        this.kommunekode = kommunekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
