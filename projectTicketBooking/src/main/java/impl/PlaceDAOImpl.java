package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import antlr.debug.Event;
import dao.PlaceDAO;
import models.Place;
import org.hibernate.SessionException;
import util.HibernateUtil;

public class PlaceDAOImpl implements PlaceDAO{

	@Override
	public void addPlace(Place place) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(place);
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
	public void updatePlace(Place place) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(place);
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
	public Place getPlaceById(int id) throws SQLException {
		Session session = null;
		Place place = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            place = (Place) session.get(Place.class, id);
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return place;
	}

	@Override
	public List<Place> getAllPlace() throws SQLException {
		Session session = null;
        List<Place> place = new ArrayList<Place>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            place = session.createCriteria(Place.class).list();
        } catch (SessionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "no session I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return place;
	}

	@Override
	public void deletePlace(Place place) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(place);
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
