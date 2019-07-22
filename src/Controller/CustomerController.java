package Controller;

import DataAccessObject.CustomerDao;
import Model.Customer;
import Modules.Controller;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class CustomerController extends Controller {

    private final CustomerDao dao;

    public CustomerController() throws SQLException, IOException, FileNotFoundException, ParseException {
        dao = new CustomerDao();
    }

    @Override
    public void create(Object... obj) {
        String namaPerusahaan = (String) obj[0];
        String alamat = (String) obj[1];
        String noTelp = (String) obj[2];
        
        Model m = new Customer();
        Customer model = (Customer) m;
        
        model.setNamaPerusahaan(namaPerusahaan);
        model.setAlamat(alamat);
        model.setNoTelp(noTelp);
        
        dao.create(model);
    }

    @Override
    public void update(Object... obj) {
        int idCustomer = (int) obj[0];
        String namaPerusahaan = (String) obj[1];
        String alamat = (String) obj[2];
        String noTelp = (String) obj[3];
        
        Model m = new Customer();
        Customer model = (Customer) m;
        
        model.setIdCustomer(idCustomer);
        model.setNamaPerusahaan(namaPerusahaan);
        model.setAlamat(alamat);
        model.setNoTelp(noTelp);
        
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
    
    public DefaultTableModel viewByName(String param){
        return dao.viewByName(param);
    }
}
