package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import antlr.debug.Event;
import dao.EventDAO;
import util.HibernateUtil;

public class EventDAOImpl implements EventDAO{

	@Override
	public void addMovie(Event event) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(event);
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
	public void updateMovie(Event event) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(event);
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
	public Event getMovieById(int id) throws SQLException {
		Session session = null;
        Event event = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            event = (Event) session.get(Event.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return event;
	}

	@Override
	public List<Event> getAllMovie() throws SQLException {
		Session session = null;
        List<Event> events = new ArrayList<Event>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            events = session.createCriteria(Event.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return events;
	}

	@Override
	public void deleteMovie(Event event) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(event);
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
