package DataAccessObject;

import Model.Piutang;
import Modules.DataAccessObject;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PiutangDao extends DataAccessObject {

    public PiutangDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        Piutang model = (Piutang) m;
        try {
            String sql = "INSERT INTO piutang(id_peminjaman, tanggal_bayar, jumlah_piutang, jumlah_bayar, saldo_piutang, keterangan) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdPeminjaman());
            ps.setString(2, model.getTanggalBayar());
            ps.setInt(3, model.getJumlahPiutang());
            ps.setInt(4, model.getJumlahBayar());
            ps.setInt(5, model.getSaldoPiutang());
            ps.setString(6, model.getKeterangan());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Piutang model = (Piutang) m;
        String sql = "UPDATE piutang SET id_peminjaman=" + model.getIdPeminjaman()
                + ", tanggal_bayar='" + model.getTanggalBayar()
                + "', jumlah_piutang=" + model.getJumlahPiutang()
                + ", jumlah_bayar=" + model.getJumlahBayar()
                + ", saldo_piutang=" + model.getSaldoPiutang()
                + ", keterangan='" + model.getKeterangan()
                + "' WHERE id_piutang=" + model.getIdPiutang();
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
            String sql = "DELETE from piutang WHERE id_piutang=" + id;
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
        ArrayList<Piutang> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Piutang model = new Piutang();
                model.setIdPiutang(rs.getInt("id_piutang"));
                model.setIdPeminjaman(rs.getInt("id_peminjaman"));
                model.setTanggalBayar(rs.getString("tanggal_bayar"));
                model.setJumlahPiutang(rs.getInt("jumlah_piutang"));
                model.setJumlahBayar(rs.getInt("jumlah_bayar"));
                model.setSaldoPiutang(rs.getInt("jumlah_bayar"));
                model.setKeterangan(rs.getString("keterangan"));
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
        String query = "SELECT * FROM piutang";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        String query = "SELECT * FROM piutang WHERE id_piutang=" + id;
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
