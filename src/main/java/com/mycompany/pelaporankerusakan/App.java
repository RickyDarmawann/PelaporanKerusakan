
package com.mycompany.pelaporankerusakan;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private final ArrayList<LaporanFasilitas> daftarLaporan = new ArrayList<>();
    private final ObservableList<String> tampilanLaporan =
            FXCollections.observableArrayList();

    private int nomorLaporan = 1;

    @Override
    public void start(Stage stage) {
        Label judul = new Label("SMART GOVERNANCE");
        Label subjudul = new Label(
                "Aplikasi Pelaporan Kerusakan Fasilitas Umum Kampus");

        TextField inputNama = new TextField();
        TextField inputLokasi = new TextField();
        TextField inputFasilitas = new TextField();
        TextField inputKerusakan = new TextField();

        inputNama.setPromptText("Masukkan nama pelapor");
        inputLokasi.setPromptText("Contoh: Gedung FMIPA");
        inputFasilitas.setPromptText("Contoh: Lampu");
        inputKerusakan.setPromptText("Jelaskan kerusakan fasilitas");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(12);

        form.add(new Label("Nama Pelapor"), 0, 0);
        form.add(inputNama, 1, 0);
        form.add(new Label("Lokasi Kerusakan"), 0, 1);
        form.add(inputLokasi, 1, 1);
        form.add(new Label("Jenis Fasilitas"), 0, 2);
        form.add(inputFasilitas, 1, 2);
        form.add(new Label("Deskripsi Kerusakan"), 0, 3);
        form.add(inputKerusakan, 1, 3);

        Button tombolTambah = new Button("Tambah Laporan");

        ListView<String> daftarTampilan = new ListView<>(tampilanLaporan);
        daftarTampilan.setPrefHeight(220);

        tombolTambah.setOnAction(event -> {
            String nama = inputNama.getText().trim();
            String lokasi = inputLokasi.getText().trim();
            String fasilitas = inputFasilitas.getText().trim();
            String kerusakan = inputKerusakan.getText().trim();

            if (nama.isEmpty() || lokasi.isEmpty()
                    || fasilitas.isEmpty() || kerusakan.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Data belum lengkap");
                alert.setContentText(
                        "Silakan isi semua kolom terlebih dahulu.");
                alert.showAndWait();

            } else if (!nama.matches("[a-zA-Z ]+")) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Nama tidak valid");
                alert.setContentText(
                        "Nama pelapor hanya boleh berisi huruf dan spasi.");
                alert.showAndWait();

            } else {

                LaporanFasilitas laporan = new LaporanFasilitas(
                        nomorLaporan, nama, lokasi, fasilitas, kerusakan);

                daftarLaporan.add(laporan);

                String hasil = "ID: " + laporan.getIdLaporan()
                        + " | Pelapor: " + laporan.getNamaPelapor()
                        + " | Lokasi: " + laporan.getLokasi()
                        + " | Fasilitas: " + laporan.getJenisFasilitas()
                        + " | Kerusakan: " + laporan.getDeskripsiKerusakan()
                        + " | Status: " + laporan.getStatus();

                tampilanLaporan.add(hasil);
                nomorLaporan++;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Laporan berhasil ditambahkan");
                alert.setContentText(
                        "Terima kasih telah melaporkan kerusakan fasilitas.");
                alert.showAndWait();

                inputNama.clear();
                inputLokasi.clear();
                inputFasilitas.clear();
                inputKerusakan.clear();
            }
        });

        VBox root = new VBox(12);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                judul,
                subjudul,
                new Label("Form Pelaporan"),
                form,
                tombolTambah,
                new Label("Daftar Laporan"),
                daftarTampilan
        );

        Scene scene = new Scene(root, 700, 600);

        stage.setTitle("Smart Governance - Pelaporan Kerusakan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
