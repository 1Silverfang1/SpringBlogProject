package SpringMVC.ServiceLayer;

import SpringMVC.Model.BlogModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class RetrieveBlog {
    public List<BlogModel> getBlogData()
    {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(BlogModel.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Query resultQuery=session.createQuery("from BlogModel");
        List<BlogModel> blogModelArrayList= resultQuery.list();

        return  blogModelArrayList;
    }
}
