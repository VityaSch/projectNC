package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import antlr.debug.Event;
import dao.BookingDAO;
import tables.Booking;
import util.HibernateUtil;

public class BookingDAOImpl implements BookingDAO {

	@Override
	public void addBooking(Booking booking) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(booking);
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
	public void updateBooking(Booking booking) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(booking);
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
	public Booking getBookingById(int id) throws SQLException {
		Session session = null;
		Booking booking = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            booking = (Booking) session.get(Booking.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booking;
	}

	@Override
	public List<Booking> getAllBooking() throws SQLException {
		Session session = null;
        List<Booking> booking = new ArrayList<Booking>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            booking = session.createCriteria(Booking.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booking;
	}

	@Override
	public void deleteBooking(Booking booking) {
		Session session = null;
        try {
       	 Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(booking);
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
