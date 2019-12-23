package SpringMVC.ServiceLayer.Interface;

import SpringMVC.Model.BlogModel;

import java.util.List;

public interface RetrieveInterface {
    List<BlogModel> getBlogData();
    BlogModel getMyBlog(int myBlogId);
}
