package com.example.demo.model;


public class Mahasiswa {

    private Integer nip;
    private String nama;
    private Integer nilaiAbsen;
    private Integer nilaiMidTes;
    private Integer nilaiUas;

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNilaiAbsen() {
        return nilaiAbsen;
    }

    public void setNilaiAbsen(Integer nilaiAbsen) {
        this.nilaiAbsen = nilaiAbsen;
    }

    public Integer getNilaiMidTes() {
        return nilaiMidTes;
    }

    public void setNilaiMidTes(Integer nilaiMidTes) {
        this.nilaiMidTes = nilaiMidTes;
    }

    public Integer getNilaiUas() {
        return nilaiUas;
    }

    public void setNilaiUas(Integer nilaiUas) {
        this.nilaiUas = nilaiUas;
    }

    public Integer getNilaiAkhir() {
        return (int) ((0.2 * this.nilaiAbsen) + (0.4 * this.nilaiMidTes) + (0.4 * nilaiUas));
    }

    public String getGrade() {
        if (getNilaiAkhir() >= 85 && getNilaiAkhir() <= 100) {
            return "A";
        } else if (getNilaiAkhir() >= 76 && getNilaiAkhir() <= 84) {
            return "B";
        } else if (getNilaiAkhir() >= 61 && getNilaiAkhir() <= 75) {
            return "C";
        } else if (getNilaiAkhir() >= 46 && getNilaiAkhir() <= 60) {
            return "D";
        } else if (getNilaiAkhir() >= 0 && getNilaiAkhir() <= 45) {
            return "E";
        }
        return "Nilai tidak valid";
    }

    public Boolean isLulus() {
        return getGrade().equals("A") || getGrade().equals("B") || getGrade().equals("C");
    }
}
