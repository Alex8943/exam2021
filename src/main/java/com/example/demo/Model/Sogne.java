package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Sogne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long sognekode;
    private String navn;

    @ManyToOne
    private Kommune kommunekode;
    private long smittetryk;
    private Date nedlukningsdato;

    public Sogne(long sognekode, String navn, Kommune kommunekode, long smittetryk, Date nedlukningsdato) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.kommunekode = kommunekode;
        this.smittetryk = smittetryk;
        this.nedlukningsdato = nedlukningsdato;
    }

    public Sogne(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSognekode() {
        return sognekode;
    }

    public void setSognekode(long sognekode) {
        this.sognekode = sognekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kommune getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(Kommune kommune) {
        this.kommunekode = kommune;
    }

    public long getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(long smittetryk) {
        this.smittetryk = smittetryk;
    }

    public Date getNedlukningsdato() {
        return nedlukningsdato;
    }

    public void setNedlukningsdato(Date nedlukningsdato) {
        this.nedlukningsdato = nedlukningsdato;
    }
}
