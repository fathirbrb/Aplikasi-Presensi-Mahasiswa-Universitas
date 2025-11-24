package com.presensimahasiswa.base;

public class Mahasiswa {
    private String nama;
    private String npm;

    public Mahasiswa(String nama, String npm) {
        this.nama = nama;
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public String getNpm() {
        return npm;
    }
}