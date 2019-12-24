package SpringMVC.ServiceLayer;

import SpringMVC.Configuration.HibernateConfig;
import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.Interface.DeleteBlogInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBlog implements DeleteBlogInterface {
    @Autowired
    private HibernateConfig configuration;

    public HibernateConfig getConfiguration() {
        return configuration;
    }

    public void setConfiguration(HibernateConfig configuration) {
        this.configuration = configuration;
    }

    @Override
    public String deleteBlog(int blogId)
    {
        SessionFactory sessionFactory =configuration.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        BlogModel deleteBlog= session.find(BlogModel.class,blogId);
        session.delete(deleteBlog);
        transaction.commit();
        session.close();
        return "Blog deleted Successfully";
    }
}
