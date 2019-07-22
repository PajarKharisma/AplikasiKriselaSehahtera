package DataAccessObject;

import Model.Tunggakan;
import Modules.DataAccessObject;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class TunggakanDao extends DataAccessObject {

    public TunggakanDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        Tunggakan model = (Tunggakan) m;
        try {
            String sql = "INSERT INTO tunggakan(id_peminjaman, tangal_tempo, total_tunggakan) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdPeminjaman());
            ps.setString(2, model.getTanggalTempo());
            ps.setInt(3, model.getTotalTunggakan());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Tunggakan model = (Tunggakan) m;
        String sql = "UPDATE piutang SET id_peminjaman=" + model.getIdPeminjaman()
                + ", tanggal_tempo='" + model.getTanggalTempo()
                + "', total_tunggakan=" + model.getTotalTunggakan()
                + " WHERE id_tunggakan=" + model.getIdTunggakan();
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
            String sql = "DELETE from tunggakan WHERE id_tunggakan=" + id;
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
        ArrayList<Tunggakan> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Tunggakan model = new Tunggakan();
                model.setIdTunggakan(rs.getInt("id_tunggakan"));
                model.setIdPeminjaman(rs.getInt("id_peminjaman"));
                model.setTanggalTempo(rs.getString("tanggal_tempo"));
                model.setTotalTunggakan(rs.getInt("total_tunggakan"));
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
        String query = "SELECT * FROM tunggakan";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        String query = "SELECT * FROM tunggakan WHERE id_tunggakan=" + id;
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel viewAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
