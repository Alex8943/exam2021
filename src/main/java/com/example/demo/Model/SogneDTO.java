package com.example.demo.Model;

public class SogneDTO { //DTO = data trancfer object

    private long sognekode;
    private long kommunekode;

    public SogneDTO(long sognekode, long kommunekode) {
        this.sognekode = sognekode;
        this.kommunekode = kommunekode;
    }

    public long getSognekode() {
        return sognekode;
    }

    public long getKommunekode() {
        return kommunekode;
    }

    public void setSognekode(long sognekode) {
        this.sognekode = sognekode;
    }

    public void setKommunekode(long kommunekode) {
        this.kommunekode = kommunekode;
    }
}
