package com.mycompany.pelaporankerusakan;

class Laporan {
    private int idLaporan;
    private String namaPelapor;
    private String lokasi;

    public Laporan(int idLaporan, String namaPelapor, String lokasi) {
        this.idLaporan = idLaporan;
        this.namaPelapor = namaPelapor;
        this.lokasi = lokasi;
    }

    public int getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(int idLaporan) {
        this.idLaporan = idLaporan;
    }

    public String getNamaPelapor() {
        return namaPelapor;
    }

    public void setNamaPelapor(String namaPelapor) {
        this.namaPelapor = namaPelapor;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
