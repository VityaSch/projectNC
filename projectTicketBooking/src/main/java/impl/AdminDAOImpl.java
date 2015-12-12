package impl;

import dao.AdminDAO;
import models.Admin;
import models.Booking;
import org.hibernate.Session;
import org.hibernate.SessionException;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Виктор on 12.12.2015.
 */
public class AdminDAOImpl implements AdminDAO {
    @Override
    public void addAdmin(Admin admin) {
        Session session = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        Session session = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(admin);
            session.getTransaction().commit();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Admin getAdminById(int id) throws SQLException {
        Session session = null;
        Admin admin = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            admin = (Admin) session.get(Admin.class, id);
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() throws SQLException {
        Session session = null;
        List<Admin> admins = new ArrayList<Admin>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            admins = session.createCriteria(Admin.class).list();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return admins;
    }

    @Override
    public void deleteAdmin(Admin admin) {
        Session session = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(admin);
            session.getTransaction().commit();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
