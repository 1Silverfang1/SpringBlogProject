package SpringMVC.Configuration;

import SpringMVC.Model.BlogModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Component
public class HibernateConfig  {
    private  SessionFactory sessionFactory;
    public  SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration();
        Properties  databaseSetting = new Properties();
        databaseSetting.put(Environment.URL,"jdbc:postgresql://localhost:5432/frenzy");
        databaseSetting.put(Environment.USER,"postgres");
        databaseSetting.put(Environment.PASS,"toor");
        databaseSetting.put(Environment.DRIVER,"org.postgresql.Driver");
        databaseSetting.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQL9Dialect");
        databaseSetting.put(Environment.SHOW_SQL,"true");
        databaseSetting.put(Environment.HBM2DDL_AUTO,"update");
        configuration.setProperties(databaseSetting);
        configuration.addAnnotatedClass(BlogModel.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory= configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
