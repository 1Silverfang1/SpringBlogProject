package SpringMVC.ServiceLayer;

import SpringMVC.Configuration.HibernateConfig;
import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.Interface.SaveBlogInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistBlog implements SaveBlogInterface {
    @Autowired
    private HibernateConfig configuration;

    public HibernateConfig getConfiguration() {
        return configuration;
    }

    public void setConfiguration(HibernateConfig configuration) {
        this.configuration = configuration;
    }
    @Override
    public String addThis(BlogModel blogModel)
    {

        SessionFactory sessionFactory= configuration.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println(blogModel.getBlogPost()+blogModel.getCountry()+blogModel.getAuthorName());
        session.save(blogModel);
        transaction.commit();
        return "Blog Submitted Sucessfully";
    }
}
