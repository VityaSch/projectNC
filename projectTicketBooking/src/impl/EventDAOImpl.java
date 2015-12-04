package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import antlr.debug.Event;
import dao.EventDAO;
import models.Events;
import org.hibernate.SessionException;
import util.HibernateUtil;

public class EventDAOImpl implements EventDAO{

	@Override
	public void addMovie(Events event) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(event);
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
	public void updateMovie(Events event) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(event);
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
	public Events getMovieById(int id) throws SQLException {
		Session session = null;
		Events event = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            event = (Events) session.get(Events.class, id);
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return event;
	}

	@Override
	public List<Events> getAllMovie() throws SQLException {
		Session session = null;
        List<Events> events = new ArrayList<Events>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            events = session.createCriteria(Event.class).list();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return events;
	}

	@Override
	public void deleteMovie(Events event) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(event);
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
