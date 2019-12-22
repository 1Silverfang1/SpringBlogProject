package SpringMVC.ServiceLayer;

import SpringMVC.Model.BlogModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateBlog {
public String updateMyblog(BlogModel myBlog)
{
    Configuration configuration= new Configuration().configure().addAnnotatedClass(BlogModel.class);
    SessionFactory sessionFactory= configuration.buildSessionFactory();
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
