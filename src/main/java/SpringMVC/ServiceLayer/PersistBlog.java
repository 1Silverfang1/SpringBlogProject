package SpringMVC.ServiceLayer;

import SpringMVC.Model.BlogModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PersistBlog {
    public String addThis(BlogModel blogModel)
    {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(BlogModel.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println(blogModel.getBlogPost()+blogModel.getCountry()+blogModel.getAuthorName());
        session.save(blogModel);
        transaction.commit();
        return "Blog Submitted Sucessfully";
    }
}
