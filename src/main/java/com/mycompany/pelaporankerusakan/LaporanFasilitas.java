package com.mycompany.pelaporankerusakan;

class LaporanFasilitas extends Laporan {
    private String jenisFasilitas;
    private String deskripsiKerusakan;
    private String status;

    public LaporanFasilitas(int idLaporan, String namaPelapor,
            String lokasi, String jenisFasilitas,
            String deskripsiKerusakan) {

        super(idLaporan, namaPelapor, lokasi);
        this.jenisFasilitas = jenisFasilitas;
        this.deskripsiKerusakan = deskripsiKerusakan;
        this.status = "Menunggu";
    }

    public String getJenisFasilitas() {
        return jenisFasilitas;
    }

    public void setJenisFasilitas(String jenisFasilitas) {
        this.jenisFasilitas = jenisFasilitas;
    }

    public String getDeskripsiKerusakan() {
        return deskripsiKerusakan;
    }

    public void setDeskripsiKerusakan(String deskripsiKerusakan) {
        this.deskripsiKerusakan = deskripsiKerusakan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanLaporan() {
        System.out.println("----------------------------");
        System.out.println("ID Laporan : " + getIdLaporan());
        System.out.println("Pelapor    : " + getNamaPelapor());
        System.out.println("Lokasi     : " + getLokasi());
        System.out.println("Fasilitas  : " + jenisFasilitas);
        System.out.println("Kerusakan  : " + deskripsiKerusakan);
        System.out.println("Status     : " + status);
        System.out.println("----------------------------");
    }
}
