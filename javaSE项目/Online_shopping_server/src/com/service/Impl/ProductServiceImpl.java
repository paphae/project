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
		return pd.insert(p)?"添加成功":"添加失败";
	}

	@Override
	public String delete(int id) {
		return pd.delete(id)?"删除成功":"删除失败";
	}

	@Override
	public String update(Product p) {
		return pd.update(p)?"修改成功":"修改失败";
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
