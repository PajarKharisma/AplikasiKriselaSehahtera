package Model;

import Modules.Model;

public class JenisBarang extends Model{
    private String idBarang;
    private String namaBarang;
    private String jenisBarang;

    public JenisBarang() {
    }

    public JenisBarang(String idBarang, String namaBarang, String jenisBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }
}
