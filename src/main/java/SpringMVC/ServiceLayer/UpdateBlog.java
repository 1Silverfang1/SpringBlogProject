package SpringMVC.ServiceLayer;

import SpringMVC.Configuration.HibernateConfig;
import SpringMVC.Model.BlogModel;
import SpringMVC.ServiceLayer.Interface.UpdateBlogInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateBlog implements UpdateBlogInterface {
    @Autowired
    private HibernateConfig configuration;

    public HibernateConfig getConfiguration() {
        return configuration;
    }

    public void setConfiguration(HibernateConfig configuration) {
        this.configuration = configuration;
    }
    @Override
public String updateMyblog(BlogModel myBlog)
{
    SessionFactory sessionFactory= configuration.getSessionFactory();
    Session session= sessionFactory.openSession();
    Transaction transaction= session.beginTransaction();
    System.out.println(myBlog.getAuthorName()+myBlog.getId());
    int id= myBlog.getId();
    System.out.println(id);
    BlogModel UpdateBlog=session.find(BlogModel.class,id);
    System.out.println(UpdateBlog);
    UpdateBlog.setAuthorName(myBlog.getAuthorName());
    UpdateBlog.setBlogPost(myBlog.getBlogPost());
    UpdateBlog.setBlogTitle(myBlog.getBlogTitle());
    UpdateBlog.setCountry(myBlog.getCountry());
    session.update(UpdateBlog);
    System.out.println(myBlog.getAuthorName());
    transaction.commit();
    return "Blog Update Sucessfully";
}
}
