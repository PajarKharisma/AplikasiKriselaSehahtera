package DataAccessObject;

import Modules.DataAccessObject;
import Modules.Model;
import Model.JenisBarang;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class JenisBarangDao extends DataAccessObject {

    public JenisBarangDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        JenisBarang model = (JenisBarang) m;
        try {
            String sql = "INSERT INTO jenis_barang(nama_barang, jenis_barang) VALUES(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getNamaBarang());
            ps.setString(2, model.getJenisBarang());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        JenisBarang model = (JenisBarang) m;
        String sql = "UPDATE jenis_barang SET nama_barang='" + model.getNamaBarang()
                + "', jenis_barang='" + model.getJenisBarang()
                + "' WHERE id_barang=" + model.getIdBarang();
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
            String sql = "DELETE from jenis_barang WHERE id_barang=" + id;
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
        ArrayList<JenisBarang> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                JenisBarang model = new JenisBarang();
                model.setIdBarang(rs.getInt("id_barang"));
                model.setNamaBarang(rs.getString("nama_barang"));
                model.setJenisBarang(rs.getString("jenis_barang"));
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
        String query = "SELECT * FROM jenis_barang";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        String query = "SELECT * FROM jenis_barang WHERE id_barang=" + id;
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
        mdl.addColumn("Id Barang");
        mdl.addColumn("Nama Barang");
        mdl.addColumn("Jenis Barang");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_customer"),
                    rs.getString("nama_barang"),
                    rs.getString("jenis_barang")
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
        String query = "SELECT * FROM jenis_barang";
        return viewByParam(query);
    }
    
    public DefaultTableModel viewByNama(String param) {
        String query = "SELECT * FROM jenis_barang WHERE nama_barang LIKE '%" + param + "%'";
        return viewByParam(query);
    }
}
