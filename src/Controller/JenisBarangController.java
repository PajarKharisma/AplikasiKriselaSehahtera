package Controller;

import DataAccessObject.JenisBarangDao;
import Model.JenisBarang;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class JenisBarangController extends Controller {

    private final JenisBarangDao dao;

    public JenisBarangController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new JenisBarangDao();
    }

    @Override
    public void create(Object... obj) {
        String idBarang = (String) obj[0];
        String namaBarang = (String) obj[1];
        String jenisBarang = (String) obj[2];

        Model m = new JenisBarang();
        JenisBarang model = (JenisBarang) m;

        model.setIdBarang(idBarang);
        model.setNamaBarang(namaBarang);
        model.setJenisBarang(jenisBarang);
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        String idBarang = (String) obj[0];
        String namaBarang = (String) obj[1];
        String jenisBarang = (String) obj[2];

        Model m = new JenisBarang();
        JenisBarang model = (JenisBarang) m;

        model.setIdBarang(idBarang);
        model.setNamaBarang(namaBarang);
        model.setJenisBarang(jenisBarang);
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

    public DefaultTableModel viewByNama(String param){
        return dao.viewByNama(param);
    }
}
