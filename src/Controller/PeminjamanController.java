package Controller;

import DataAccessObject.JenisBarangDao;
import DataAccessObject.PeminjamanDao;
import Model.Peminjaman;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PeminjamanController extends Controller {

    private final PeminjamanDao dao;
    private final JenisBarangDao daoBarang;

    public PeminjamanController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new PeminjamanDao();
        daoBarang = new JenisBarangDao();
    }

    @Override
    public void create(Object... obj) {
        int idCustomer = (int) obj[0];
        int idBarang = (int) obj[1];
        String berat = (String) obj[2];
        String tanggalPinjam = (String) obj[3];
        String tanggalKembali = (String) obj[4];
        String lokasi = (String) obj[5];
        int harga = (int) obj[6];

        Model m = new Peminjaman();
        Peminjaman model = (Peminjaman) m;

        model.setIdCustomer(idCustomer);
        model.setIdBarang(idBarang);
        model.setBerat(berat);
        model.setTanggalPinjam(tanggalPinjam);
        model.setTanggalKembali(tanggalKembali);
        model.setLokasi(lokasi);
        model.setHarga(harga);

        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idPeminjaman = (int) obj[0];
        int idCustomer = (int) obj[1];
        int idBarang = (int) obj[2];
        String berat = (String) obj[3];
        String tanggalPinjam = (String) obj[4];
        String tanggalKembali = (String) obj[5];
        String lokasi = (String) obj[6];
        int harga = (int) obj[7];

        Model m = new Peminjaman();
        Peminjaman model = (Peminjaman) m;

        model.setIdPeminjaman(idPeminjaman);
        model.setIdCustomer(idCustomer);
        model.setIdBarang(idBarang);
        model.setBerat(berat);
        model.setTanggalPinjam(tanggalPinjam);
        model.setTanggalKembali(tanggalKembali);
        model.setLokasi(lokasi);
        model.setHarga(harga);

        dao.update(model);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAllData() {
        return dao.getAllData();
    }

    @Override
    public ArrayList<?> getById(int id) {
        return dao.getById(id);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }
    
    public DefaultTableModel viewAllUmum() {
        return dao.viewAllUmum();
    }

    public DefaultTableModel viewByNameUmum(String name) {
        return dao.viewByNameUmum(name);
    }

    public DefaultTableModel viewAllDetail(int idCustomer) {
        return dao.viewAllDetail(idCustomer);
    }
}
