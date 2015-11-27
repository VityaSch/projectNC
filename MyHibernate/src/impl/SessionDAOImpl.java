package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import antlr.debug.Event;
import dao.SessionDAO;
import tables.Sesion;
import util.HibernateUtil;

public class SessionDAOImpl implements SessionDAO {

	@Override
	public void addSession(Sesion sessions) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	@Override
	public void updateSession(Sesion sessions) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	@Override
	public Sesion getSessionById(int id) throws SQLException {
		Session session = null;
		Sesion sesion = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            sesion = (Sesion) session.get(Sesion.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sesion;
	}

	@Override
	public List<Sesion> getAllSession() throws SQLException {
		Session session = null;
        List<Sesion> sesion = new ArrayList<Sesion>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            sesion = session.createCriteria(Sesion.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sesion;
	}

	@Override
	public void deleteSession(Sesion sessions) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}


}
