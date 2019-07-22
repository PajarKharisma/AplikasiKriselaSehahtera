package DataAccessObject;

import Modules.DataAccessObject;
import Modules.Model;
import Model.Pengguna;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PenggunaDao extends DataAccessObject{

    public PenggunaDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }
    
    @Override
    public void create(Model m) {
        Pengguna model = (Pengguna) m;
        try {
            String sql = "INSERT INTO pengguna(username, password, akses) VALUES(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Pengguna model = (Pengguna) m;
        String sql = "UPDATE pengguna SET username='" + model.getUsername()
                        + "', password='" + model.getPassword()
                        + "' WHERE username='" + model.getUsername() + "'";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE from pengguna WHERE username='" + id + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    protected ArrayList<?> getByParam(String query) {
        ArrayList<Pengguna> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Pengguna model = new Pengguna();
                model.setUsername(rs.getString("username"));
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
        String query = "SELECT * FROM pengguna";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getById(String id) {
        String query = "SELECT * FROM pengguna WHERE username='" + id + "'";
        return getByParam(query);
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Username");
        mdl.addColumn("password");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("username"),
                    rs.getString("password")
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
        String query = "SELECT * FROM pengguna";
        return viewByParam(query);
    }
    
    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM pengguna WHERE username LIKE '%" + param + "%'";
        return viewByParam(query);
    }
}
