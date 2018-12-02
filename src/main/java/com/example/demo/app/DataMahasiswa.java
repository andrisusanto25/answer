package com.example.demo.app;

import com.example.demo.model.Mahasiswa;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The answer java basic A
 */
public class DataMahasiswa {

    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    Integer jumlahLulus = 0;
    Integer jumlahTidakLulus = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("/mahasiswa.nilai");
        DataMahasiswa dataMahasiswa = new DataMahasiswa();

        System.out.print("Masukan jumlah mahasiswa : ");
        Integer jumlahMahasiswa = scanner.nextInt();

        for (int i=0; i<jumlahMahasiswa; i++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            System.out.print("Masukan NIP : ");
            mahasiswa.setNip(scanner.nextInt());

            System.out.print("Masukan Nama : ");
            scanner.nextLine();
            mahasiswa.setNama(scanner.nextLine());

            System.out.print("Masukan Nilai Absen : ");
            mahasiswa.setNilaiAbsen(scanner.nextInt());

            System.out.print("Masukan Nilai Mid tes : ");
            mahasiswa.setNilaiMidTes(scanner.nextInt());

            System.out.print("Masukan Nilai UAS : ");
            mahasiswa.setNilaiUas(scanner.nextInt());

            if (mahasiswa.isLulus()) {
                dataMahasiswa.jumlahLulus++;
            } else {
                dataMahasiswa.jumlahTidakLulus++;
            }

            dataMahasiswa.mahasiswaList.add(mahasiswa);
        }

        printWriter.println();
        printWriter.println("No. NIM Nama Nilai Akhir Grade");
        printWriter.println("=========================================================");
        Integer no = 1;
        for (Mahasiswa mahasiswa : dataMahasiswa.mahasiswaList) {
            printWriter.println(no + ". " + mahasiswa.getNip() + " " + mahasiswa.getNama() + " "
                    + mahasiswa.getNilaiAkhir() + " " + mahasiswa.getGrade());
            no++;
        }
        printWriter.println("=========================================================");
        printWriter.println("Jumlah Mahasiswa : "+ dataMahasiswa.mahasiswaList.size());
        printWriter.println("Jumlah Mahasiswa lulus : " + dataMahasiswa.jumlahLulus);
        printWriter.println("Jumlah Mahasiswa tidak lulus : " + dataMahasiswa.jumlahTidakLulus);
        printWriter.println("=========================================================");

        // close connection print writer
        printWriter.close();

    }
}
