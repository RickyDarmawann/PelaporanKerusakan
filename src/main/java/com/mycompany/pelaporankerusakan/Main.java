package com.mycompany.pelaporankerusakan;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<LaporanFasilitas> daftarLaporan = new ArrayList<>();
            
            int nomorLaporan = 1;
            String pilihan;
            
            do {
                System.out.println("\n=== SMART GOVERNANCE ===");
                System.out.println("1. Tambah Laporan");
                System.out.println("2. Lihat Laporan");
                System.out.println("3. Selesaikan Laporan");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu: ");
                
                pilihan = input.nextLine();
                
                switch (pilihan) {
                    case "1":
                        System.out.println("\n=== TAMBAH LAPORAN ===");
                        
                        System.out.print("Nama Pelapor: ");
                        String nama = input.nextLine();
                        
                        System.out.print("Lokasi Kerusakan: ");
                        String lokasi = input.nextLine();
                        
                        System.out.print("Jenis Fasilitas: ");
                        String fasilitas = input.nextLine();
                        
                        System.out.print("Deskripsi Kerusakan: ");
                        String kerusakan = input.nextLine();
                        
                        LaporanFasilitas laporan =
                                new LaporanFasilitas(
                                        nomorLaporan, nama, lokasi,
                                        fasilitas, kerusakan
                                );
                        
                        daftarLaporan.add(laporan);
                        nomorLaporan++;
                        
                        System.out.println("Laporan berhasil ditambahkan!");
                        break;
                        
                    case "2":
                        if (daftarLaporan.isEmpty()) {
                            System.out.println("Belum ada laporan.");
                        } else {
                            for (LaporanFasilitas data : daftarLaporan) {
                                data.tampilkanLaporan();
                            }
                        }
                        break;
                        
                    case "3":
                        System.out.print("Masukkan ID laporan: ");
                        String id = input.nextLine();
                        
                        boolean ditemukan = false;
                        
                        for (LaporanFasilitas data : daftarLaporan) {
                            if (String.valueOf(data.getIdLaporan()).equals(id)) {
                                data.setStatus("Selesai");
                                ditemukan = true;
                                System.out.println("Status berhasil diperbarui.");
                                break;
                            }
                        }
                        
                        if (!ditemukan) {
                            System.out.println("Laporan tidak ditemukan.");
                        }
                        break;
                        
                    case "4":
                        System.out.println("Terima kasih!");
                        break;
                        
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
                
            } while (!pilihan.equals("4"));
        }
    }
}
