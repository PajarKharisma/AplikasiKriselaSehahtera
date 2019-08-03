package DataAccessObject;

import Model.Peminjaman;
import Modules.DataAccessObject;
import Modules.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;

public class PeminjamanDao extends DataAccessObject {

    public PeminjamanDao() throws SQLException, IOException, FileNotFoundException, ParseException {
        super();
    }

    @Override
    public void create(Model m) {
        Peminjaman model = (Peminjaman) m;
        try {
            String sql = "INSERT INTO peminjaman(id_customer, id_barang, berat, tanggal_pinjam, tanggal_kembali, lokasi, harga) VALUES(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIdCustomer());
            ps.setInt(2, model.getIdBarang());
            ps.setString(3, model.getBerat());
            ps.setString(4, model.getTanggalPinjam());
            ps.setString(5, model.getTanggalKembali());
            ps.setString(6, model.getLokasi());
            ps.setInt(7, model.getHarga());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (SQLException e) {
            System.out.println("#Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
    }

    @Override
    public void update(Model m) {
        Peminjaman model = (Peminjaman) m;
        String sql = "UPDATE peminjaman SET id_customer=" + model.getIdCustomer()
                + ", id_barang=" + model.getIdBarang()
                + ", berat='" + model.getBerat()
                + "', tanggal_pinjam='" + model.getTanggalPinjam()
                + "', tanggal_kembali='" + model.getTanggalKembali()
                + "', lokasi='" + model.getLokasi()
                + "', harga=" + model.getHarga()
                + " WHERE id_peminjaman=" + model.getIdPeminjaman();
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
            String sql = "DELETE from peminjaman WHERE id_peminjaman=" + id;
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
        ArrayList<Peminjaman> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Peminjaman model = new Peminjaman();
                model.setIdPeminjaman(rs.getInt("id_peminjaman"));
                model.setIdCustomer(rs.getInt("id_customer"));
                model.setIdBarang(rs.getInt("id_barang"));
                model.setBerat(rs.getString("berat"));
                model.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                model.setTanggalKembali(rs.getString("tanggal_kembali"));
                model.setLokasi(rs.getString("lokasi"));
                model.setHarga(rs.getInt("harga"));
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
        String query = "SELECT * FROM peminjaman";
        return getByParam(query);
    }

    @Override
    public ArrayList<?> getById(int id) {
        String query = "SELECT * FROM peminjaman WHERE id_peminjaman=" + id;
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
        mdl.addColumn("Id Peminjaman");
        mdl.addColumn("Id Customer");
        mdl.addColumn("Nama Perusahaan");
        mdl.addColumn("Id Barang");
        mdl.addColumn("Nama Barang");
        mdl.addColumn("Berat");
        mdl.addColumn("Tanggal Pinjam");
        mdl.addColumn("Tanggal Kembali");
        mdl.addColumn("Lokasi");
        mdl.addColumn("Harga");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_peminjaman"),
                    rs.getInt("id_customer"),
                    rs.getString("nama_perusahaan"),
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("berat"),
                    rs.getString("tanggal_pinjam"),
                    rs.getString("tanggal_kembali"),
                    rs.getString("lokasi"),
                    rs.getInt("harga")
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
        String query = "SELECT "
                + "p.id_peminjaman,"
                + "c.id_customer,"
                + "c.nama_perusahaan,"
                + "j.id_barang,"
                + "j.nama_barang,"
                + "p.berat,"
                + "p.tanggal_pinjam,"
                + "p.tanggal_kembali,"
                + "p.lokasi,"
                + "p.harga "
                + "FROM "
                + "peminjaman p "
                + "INNER JOIN customer c ON c.id_customer = p.id_customer "
                + "INNER JOIN jenis_barang j ON j.id_barang = p.id_barang ";
        return viewByParam(query);
    } 

    private DefaultTableModel viewByParamUmum(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Peminjamanan");
        mdl.addColumn("Id Customer");
        mdl.addColumn("Nama Perusahaan");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_peminjaman"),
                    rs.getInt("id_customer"),
                    rs.getString("nama_perusahaan")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;
    }
    
    public DefaultTableModel viewAllUmum() {
        String query = "SELECT "
                + "p.id_peminjaman, "
                + "c.id_customer, "
                + "c.nama_perusahaan "
                + "FROM "
                + "peminjaman p "
                + "INNER JOIN customer c ON c.id_customer = p.id_customer "
                + "INNER JOIN jenis_barang j ON j.id_barang = p.id_barang "
                + "GROUP BY c.id_customer";
        return viewByParamUmum(query);
    }
    
    public DefaultTableModel viewByNameUmum(String name) {
        String query = "SELECT "
                + "p.id_peminjaman, "
                + "c.id_customer, "
                + "c.nama_perusahaan "
                + "FROM "
                + "peminjaman p "
                + "INNER JOIN customer c ON c.id_customer = p.id_customer  "
                + "INNER JOIN jenis_barang j ON j.id_barang = p.id_barang "
                + "WHERE c.nama_perusahaan LIKE '%" + name + "%' "
                + "GROUP BY c.id_customer";
        return viewByParamUmum(query);
    }

    private DefaultTableModel viewByParamDetail(String query) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id Peminjaman");
        mdl.addColumn("Id Barang");
        mdl.addColumn("Nama Barang");
        mdl.addColumn("Berat");
        mdl.addColumn("Tanggal Pinjam");
        mdl.addColumn("Tanggal Kembali");
        mdl.addColumn("Lokasi");
        mdl.addColumn("Harga");
        int no = 1;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    (Object) no,
                    rs.getInt("id_peminjaman"),
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("berat"),
                    rs.getString("tanggal_pinjam"),
                    rs.getString("tanggal_kembali"),
                    rs.getString("lokasi"),
                    rs.getInt("harga")
                });
                no++;
            }
        } catch (SQLException e) {
            System.out.println("#ERROR " + e.getMessage());
            JOptionPane.showMessageDialog(null, "#Error " + e.getMessage());
        }
        return mdl;
    }

    public DefaultTableModel viewAllDetail(int idCustomer) {
        String query = "SELECT "
                + "p.id_peminjaman, "
                + "j.id_barang, "
                + "j.nama_barang, "
                + "p.berat, "
                + "p.tanggal_pinjam, "
                + "p.tanggal_kembali, "
                + "p.lokasi, "
                + "p.harga "
                + "FROM "
                + "peminjaman p "
                + "INNER JOIN customer c ON c.id_customer = p.id_customer "
                + "INNER JOIN jenis_barang j ON j.id_barang = p.id_barang "
                + "WHERE c.id_customer =" + idCustomer;
        return viewByParamDetail(query);
    }

    public DefaultTableModel viewByNameDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
