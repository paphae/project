package com.service.Impl;

import java.util.List;

import com.Dao.CategoryDao;
import com.Dao.Impl.CategoryDaoImpl;
import com.entity.Category;
import com.entity.Product;
import com.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao cd = new CategoryDaoImpl();
	@Override
	public String insert(Category p) {
		return cd.insert(p)?"��ӳɹ�":"���ʧ��";
	}

	@Override
	public String delete(int id) {
		return cd.delete(id)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(Category p) {
		return cd.update(p)?"�޸ĳɹ�":"�޸�ʧ��";
	}

	@Override
	public List<Category> selectAll() {
		return cd.selectAll();
	}

	@Override
	public List<Product> selectById(int id) {
		return cd.selectById(id);
	}

	@Override
	public List<Product> selectByName(String name) {
		return cd.selectByName(name);
	}

	@Override
	public Category selectByCid(int cid) {
		return cd.selectByCid(cid);
	}

}
