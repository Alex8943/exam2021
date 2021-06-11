package com.example.demo.Model;

public class SogneDTO { //DTO = data trancfer object

    private long sognekode;
    private String navn;
    private long kommunekode;

    public SogneDTO(long sognekode, String navn, long kommunekode) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.kommunekode = kommunekode;
    }

    public long getSognekode() {
        return sognekode;
    }

    public String getNavn() {
        return navn;
    }

    public long getKommunekode() {
        return kommunekode;
    }

    public void setSognekode(long sognekode) {
        this.sognekode = sognekode;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setKommunekode(long kommunekode) {
        this.kommunekode = kommunekode;
    }
}
