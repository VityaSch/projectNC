package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import antlr.debug.Event;
import dao.HallDAO;
import models.Hall;
import org.hibernate.SessionException;
import util.HibernateUtil;

public class HallDAOImpl implements HallDAO{

	@Override
	public void addHall(Hall hall) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(hall);
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
	public void updateHall(Event hall) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(hall);
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
	public Hall getHallById(int id) throws SQLException {
		Session session = null;
		Hall hall = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            hall = (Hall) session.get(Hall.class, id);
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return hall;
	}

	@Override
	public List<Hall> getAllHall() throws SQLException {
		Session session = null;
        List<Hall> hall = new ArrayList<Hall>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            hall = session.createCriteria(Hall.class).list();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return hall;
	}

	@Override
	public void deleteHall(Hall hall) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(hall);
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
