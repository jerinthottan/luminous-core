package com.luminous.dao;
import java.util.List;
import com.luminous.model.Category;
public interface CategoryDAO {
	 boolean addCategory(Category category);
	 boolean deleteCategory(Category category);
	 boolean updateCategory(Category category);
	List<Category> listCategories();
	 Category getCategory(int categoryID);

}
