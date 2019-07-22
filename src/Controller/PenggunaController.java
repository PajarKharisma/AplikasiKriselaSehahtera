package Controller;

import DataAccessObject.PenggunaDao;
import Model.Pengguna;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PenggunaController extends Controller {

    private final PenggunaDao dao;

    public PenggunaController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new PenggunaDao();
    }

    @Override
    public void create(Object... obj) {
        Model m = new Pengguna();
        Pengguna model = (Pengguna) m;

        model.setUsername((String) obj[0]);
        model.setPassword((String) obj[1]);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        Model m = new Pengguna();
        Pengguna model = (Pengguna) m;

        model.setUsername((String) obj[0]);
        model.setPassword((String) obj[1]);
        
        dao.update(model);
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ArrayList<?> getAllData() {
        return dao.getAllData();
    }

    @Override
    public ArrayList<?> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getById(String id) {
        return dao.getById(id);
    }

    @Override
    public DefaultTableModel viewAll() {
        return dao.viewAll();
    }

    public DefaultTableModel viewByNama(String param){
        return dao.viewByNama(param);
    }
}
