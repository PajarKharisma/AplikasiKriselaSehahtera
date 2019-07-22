package Controller;

import DataAccessObject.TunggakanDao;
import Model.Tunggakan;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class TunggakanController extends Controller {

    private final TunggakanDao dao;

    public TunggakanController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new TunggakanDao();
    }

    @Override
    public void create(Object... obj) {
        int idPeminjaman = (int) obj[0];
        String tanggalTempo = (String) obj[1];
        int totalTunggakan = (int) obj[2];

        Model m = new Tunggakan();
        Tunggakan model = (Tunggakan) m;

        model.setIdPeminjaman(idPeminjaman);
        model.setTanggalTempo(tanggalTempo);
        model.setTotalTunggakan(totalTunggakan);

        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idTunggakan = (int) obj[0];
        int idPeminjaman = (int) obj[1];
        String tanggalTempo = (String) obj[2];
        int totalTunggakan = (int) obj[3];

        Model m = new Tunggakan();
        Tunggakan model = (Tunggakan) m;

        model.setIdTunggakan(idTunggakan);
        model.setIdPeminjaman(idPeminjaman);
        model.setTanggalTempo(tanggalTempo);
        model.setTotalTunggakan(totalTunggakan);

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
