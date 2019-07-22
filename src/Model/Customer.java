package Model;

import Modules.Model;

public class Customer extends Model{
    private int idCustomer;
    private String namaPerusahaan;
    private String alamat;
    private String noTelp;

    public Customer() {
        super("Customer");
    }

    public Customer(int idCustomer, String namaPerusahaan, String alamat, String noTelp) {
        this.idCustomer = idCustomer;
        this.namaPerusahaan = namaPerusahaan;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
