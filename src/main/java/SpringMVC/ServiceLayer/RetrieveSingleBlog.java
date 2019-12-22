package SpringMVC.ServiceLayer;

import SpringMVC.Model.BlogModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetrieveSingleBlog {
    public BlogModel getMyBlog(int myBlogId)
    {
        BlogModel blogModel= null;
        Configuration configuration= new Configuration().configure().addAnnotatedClass(BlogModel.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        blogModel=session.find(BlogModel.class,myBlogId);
        transaction.commit();
        session.close();
        return  blogModel;
    }
}
