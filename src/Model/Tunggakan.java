package Model;

import Modules.Model;

public class Tunggakan extends Model {

    private int idTunggakan;
    private int idPeminjaman;
    private String tanggalTempo;
    private int totalTunggakan;

    public Tunggakan() {
        super("Tunggakan");
    }

    public Tunggakan(int idTunggakan, int idPeminjaman, String tanggalTempo, int totalTunggakan) {
        this.idTunggakan = idTunggakan;
        this.idPeminjaman = idPeminjaman;
        this.tanggalTempo = tanggalTempo;
        this.totalTunggakan = totalTunggakan;
    }

    public int getIdTunggakan() {
        return idTunggakan;
    }

    public void setIdTunggakan(int idTunggakan) {
        this.idTunggakan = idTunggakan;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getTanggalTempo() {
        return tanggalTempo;
    }

    public void setTanggalTempo(String tanggalTempo) {
        this.tanggalTempo = tanggalTempo;
    }

    public int getTotalTunggakan() {
        return totalTunggakan;
    }

    public void setTotalTunggakan(int totalTunggakan) {
        this.totalTunggakan = totalTunggakan;
    }
}
