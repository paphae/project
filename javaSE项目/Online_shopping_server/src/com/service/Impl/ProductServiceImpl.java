package com.service.Impl;

import java.util.List;

import com.Dao.ProductDao;
import com.Dao.Impl.ProductDaoImpl;
import com.entity.Product;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao pd = new ProductDaoImpl();
	@Override
	public String insert(Product p) {
		return pd.insert(p)?"��ӳɹ�":"���ʧ��";
	}

	@Override
	public String delete(int id) {
		return pd.delete(id)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(Product p) {
		return pd.update(p)?"�޸ĳɹ�":"�޸�ʧ��";
	}

	@Override
	public List<Product> selectAll() {
		return pd.selectAll();
	}

	@Override
	public Product selectById(int id) {
		return pd.selectById(id);
	}

	@Override
	public Product selectByName(String name) {
		return pd.selectByName(name);
	}

	@Override
	public List<Product> selectByCid(int cid) {
		return pd.selectByCid(cid);
	}

}
