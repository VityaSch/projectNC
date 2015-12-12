package dao;

import models.Admin;
import models.Booking;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Виктор on 12.12.2015.
 */
public interface AdminDAO {
    public void addAdmin(Admin admin);
    public void updateAdmin(Admin admin);
    public Admin getAdminById(int id) throws SQLException;
    public List<Admin> getAllAdmin() throws SQLException;
    public void deleteAdmin(Admin admin);
}
