package Model;

import Modules.Model;

public class Piutang extends Model{
    private int idPiutang;
    private int idPeminjaman;
    private String tanggalBayar;
    private int jumlahBayar;
    private int saldoPiutang;
    private String keterangan;

    public Piutang() {
        super("Piutang");
    }

    public Piutang(int idPiutang, int idPeminjaman, String tanggalBayar, int jumlahBayar, int saldoPiutang, String keterangan) {
        this.idPiutang = idPiutang;
        this.idPeminjaman = idPeminjaman;
        this.tanggalBayar = tanggalBayar;
        this.jumlahBayar = jumlahBayar;
        this.saldoPiutang = saldoPiutang;
        this.keterangan = keterangan;
    }

    public int getIdPiutang() {
        return idPiutang;
    }

    public void setIdPiutang(int idPiutang) {
        this.idPiutang = idPiutang;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(String tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public int getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(int jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public int getSaldoPiutang() {
        return saldoPiutang;
    }

    public void setSaldoPiutang(int saldoPiutang) {
        this.saldoPiutang = saldoPiutang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
