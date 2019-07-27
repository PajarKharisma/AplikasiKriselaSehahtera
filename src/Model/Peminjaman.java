package Model;

import Modules.Model;

public class Peminjaman extends Model{
    private int idPeminjaman;
    private int idCustomer;
    private int idBarang;
    private String berat;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String lokasi;
    private int harga;

    public Peminjaman() {
        super("Peminjaman");
    }

    public Peminjaman(int idPeminjaman, int idCustomer, int idBarang, String berat, String tanggalPinjam, String tanggalKembali, String lokasi, int harga) {
        this.idPeminjaman = idPeminjaman;
        this.idCustomer = idCustomer;
        this.idBarang = idBarang;
        this.berat = berat;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.lokasi = lokasi;
        this.harga = harga;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
