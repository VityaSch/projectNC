package impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import dao.NewsDAO;
import models.Movie;
import models.News;
import util.HibernateUtil;

public class NewsDAOImpl implements NewsDAO{

	@Override
	public void addNews(News news) {
		 Session session = null;
         try {
       	  Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.save(news);
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
	public void updateNews(News news) {
		Session session = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(news);
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
	public News getNewsById(int id) throws SQLException {
		Session session = null;
        News news = null;
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            news = (News) session.get(News.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return news;
	}

	@Override
	public List<News> getAllNews() throws SQLException {
		Session session = null;
        List<News> news = new ArrayList<News>();
        try {
        	Locale.setDefault(Locale.ENGLISH);
            session = HibernateUtil.getSessionFactory().openSession();
            news = session.createCriteria(News.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return news;
	}

	@Override
	public void deleteNews(News news) {
		 Session session = null;
         try {
        	 Locale.setDefault(Locale.ENGLISH);
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(news);
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
