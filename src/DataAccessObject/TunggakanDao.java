package DataAccessObject;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Model m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<?> getByParam(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DefaultTableModel viewByParam(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Piutang");
        mdl.addColumn("Id Peminjaman");
        mdl.addColumn("Id Customer");
        mdl.addColumn("nama perusahaan");
        mdl.addColumn("id barang");
        mdl.addColumn("nama barang");
        mdl.addColumn("harga");
        mdl.addColumn("tanggal kembali");
        mdl.addColumn("saldo piutang");
        mdl.addColumn("keterangan");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_piutang"),
                    rs.getInt("id_peminjaman"),
                    rs.getInt("id_customer"),
                    rs.getString("nama_perusahaan"),
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("harga"),
                    rs.getString("tanggal_kembali"),
                    rs.getInt("saldo_piutang"),
                    rs.getString("keterangan"),});
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
        String query = "SELECT "
                + "piu.id_piutang, "
                + "p.id_peminjaman, "
                + "c.id_customer, "
                + "c.nama_perusahaan, "
                + "j.id_barang, "
                + "j.nama_barang, "
                + "p.harga, "
                + "p.tanggal_kembali, "
                + "piu.saldo_piutang, "
                + "piu.keterangan "
                + "FROM ( "
                + "SELECT "
                + "MAX(id_piutang) AS id_piutang "
                + "FROM "
                + "piutang "
                + "GROUP BY id_peminjaman "
                + ") x "
                + "INNER JOIN piutang piu ON x.id_piutang = piu.id_piutang "
                + "INNER JOIN peminjaman p ON p.id_peminjaman = piu.id_peminjaman "
                + "INNER JOIN customer c ON c.id_customer = p.id_customer "
                + "INNER JOIN jenis_barang j ON j.id_barang = p.id_barang "
                + "WHERE  CURDATE() > date_add(p.tanggal_kembali, INTERVAL 1 MONTH) "
                + "AND piu.keterangan = 'BELUM LUNAS' ";
        return viewByParam(query);
    }

}
