package Controller;

import DataAccessObject.PiutangDao;
import Model.Piutang;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PiutangController extends Controller {

    private final PiutangDao dao;

    public PiutangController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new PiutangDao();
    }

    @Override
    public void create(Object... obj) {
        int idPeminjaman = (int) obj[0];

        if (dao.getKeterangan(idPeminjaman)) {
            JOptionPane.showMessageDialog(null, "Piutang sudah lunas");
        } else {
            String tanggalBayar = (String) obj[1];
            int jumlahBayar = (int) obj[2];
            int saldoPiutangSebelum = dao.getSaldoTerakhir(idPeminjaman);
            int saldoPiutang = saldoPiutangSebelum - jumlahBayar;
            String keterangan = (saldoPiutang > 0) ? "BELUM LUNAS" : "LUNAS";

            Model m = new Piutang();
            Piutang model = (Piutang) m;

            model.setIdPeminjaman(idPeminjaman);
            model.setTanggalBayar(tanggalBayar);
            model.setJumlahBayar(jumlahBayar);
            model.setSaldoPiutang(saldoPiutang);
            model.setKeterangan(keterangan);

            dao.create(model);
        }
    }

    @Override
    public void update(Object... obj) {
        int idPiutang = (int) obj[0];
        int idPeminjaman = (int) obj[1];
        String tanggalBayar = (String) obj[2];
        int jumlahBayar = (int) obj[3];

        int saldoPiutangSebelum = dao.getSaldoTerakhir(idPeminjaman);
        int saldoPiutang = saldoPiutangSebelum - jumlahBayar;
        String keterangan = (saldoPiutang > 0) ? "BELUM LUNAS" : "LUNAS";

        Model m = new Piutang();
        Piutang model = (Piutang) m;

        model.setIdPiutang(idPiutang);
        model.setIdPeminjaman(idPeminjaman);
        model.setTanggalBayar(tanggalBayar);
        model.setJumlahBayar(jumlahBayar);
        model.setSaldoPiutang(saldoPiutang);
        model.setKeterangan(keterangan);

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

    public DefaultTableModel viewAllByName(String name){
        return dao.viewAllByName(name);
    }
}
