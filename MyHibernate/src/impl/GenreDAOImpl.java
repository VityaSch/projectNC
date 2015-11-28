package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import dao.GenreDAO;
import models.Genre;
import util.HibernateUtil;

public class GenreDAOImpl implements GenreDAO{

	@Override
	public void addGenre(Genre genre){
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.save(genre);
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
	public List<Genre> getAllGenre() throws SQLException {
		Session session = null;
        List<Genre> genres = new ArrayList<Genre>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            genres = session.createCriteria(Genre.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genres;
	}

	@Override
	public void deleteGenre(Genre genre) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(genre);
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
	public void updateGenre(Genre genre) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(genre);
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
	public Genre getGenreById(int id) throws SQLException {
		Session session = null;
        Genre genre = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            genre = (Genre) session.get(Genre.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genre;
	}

}
