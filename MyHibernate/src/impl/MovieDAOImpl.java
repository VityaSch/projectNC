package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;
import dao.MovieDAO;
import models.Movie;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public void addMovie(Movie movie) {
		  Session session = null;
          try {
        	  Locale.setDefault(Locale.ENGLISH);
              session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
              session.save(movie);
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
	public void updateMovie(Movie movie) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movie);
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
	public Movie getMovieById(int id) throws SQLException {
		Session session = null;
        Movie movie = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            movie = (Movie) session.get(Movie.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return movie;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMovie() throws SQLException {
		Session session = null;
        List<Movie> movies = new ArrayList<Movie>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            movies = session.createCriteria(Movie.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return movies;
	}

	@Override
	public void deleteMovie(Movie movie) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(movie);
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
