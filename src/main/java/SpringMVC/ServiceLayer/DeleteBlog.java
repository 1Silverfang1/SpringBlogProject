package SpringMVC.ServiceLayer;

import SpringMVC.Model.BlogModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DeleteBlog implements SpringMVC.ServiceLayer.Interface.DeleteBlog {
    @Override
    public String deleteBlog(int blogId)
    {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(BlogModel.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        BlogModel deleteBlog= session.find(BlogModel.class,blogId);
        session.delete(deleteBlog);
        transaction.commit();
        session.close();
        return "Blog deleted Successfully";
    }
}
