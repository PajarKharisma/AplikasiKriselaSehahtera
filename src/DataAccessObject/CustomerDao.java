package DataAccessObject;

import Modules.DataAccessObject;
import Modules.Model;
import Model.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class CustomerDao extends DataAccessObject{

    public CustomerDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }
    
    @Override
    public void create(Model m) {
        Customer model = (Customer) m;
        try {
            String sql = "INSERT INTO customer(nama_perusahaan, alamat, no_telepon) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getNamaPerusahaan());
            ps.setString(2, model.getAlamat());
            ps.setString(3, model.getNoTelp());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Customer model = (Customer) m;
        String sql = "UPDATE customer SET nama_perusahaan='" + model.getNamaPerusahaan()
                        + "', alamat='" + model.getAlamat()
                        + "', no_telepon='" + model.getNoTelp()
                        + "' WHERE id_customer=" + model.getIdCustomer();
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE from customer WHERE id_customer=" + id;
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<?> getByParam(String query) {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Customer model = new Customer();
                model.setIdCustomer(rs.getInt("id_customer"));
                model.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                model.setAlamat(rs.getString("alamat"));
                model.setNoTelp(rs.getString("no_telepon"));
                list.add(model);
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return list;    
    }

    @Override
    public ArrayList<?> getAllData() {
        String query = "SELECT * FROM customer";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        String query = "SELECT * FROM customer WHERE id_customer=" + id;
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Customer");
        mdl.addColumn("Nama Perusahaan");
        mdl.addColumn("Alamat");
        mdl.addColumn("No Telp");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_customer"),
                    rs.getString("nama_perusahaan"),
                    rs.getString("alamat"),
                    rs.getString("no_telepon")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;
    }

    @Override
    public DefaultTableModel viewAll() {
        String query = "SELECT * FROM customer";
        return viewByParam(query);
    }
    
    public DefaultTableModel viewByName(String param) {
        String query = "SELECT * FROM customer WHERE nama_perusahaan LIKE '%" + param + "%'";
        return viewByParam(query);
    }
}
