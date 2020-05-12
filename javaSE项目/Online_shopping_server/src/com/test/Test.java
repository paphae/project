package com.test;

import java.util.Date;
import java.util.List;

import com.Dao.Impl.CategoryDaoImpl;
import com.Dao.Impl.OrderDaoImpl;
import com.Dao.Impl.OrderItemDaoImpl;
import com.Dao.Impl.ProductDaoImpl;
import com.Dao.Impl.UserDaoImpl;
import com.entity.Category;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.User;
import com.util.DButil;

public class Test {
	
	public static void main(String args[]) {
		UserDaoImpl a = new UserDaoImpl();
		ProductDaoImpl p = new ProductDaoImpl();
		CategoryDaoImpl c = new CategoryDaoImpl();
		OrderItemDaoImpl oid = new OrderItemDaoImpl();
		OrderDaoImpl od = new OrderDaoImpl();
		
//		System.out.println(oid.selectById(1));
		
//		System.out.println(od.selectStatus("待发货"));
//		for (Order o : od.selectAll()) {
//			System.out.println(o);
//		}
		
		Product product = p.selectById(1);
		System.out.println(product);
//		od.insert(new OrderItem(1,product.getId(),1,5));
		
//		c.insert(new Category(1,"食品"));
//		System.out.println(c.selectById(1));
//		c.update(new Category(1,"生鲜"));
//		
//		for (Product i : c.selectById(1)) {
//			System.out.println(i);
//		}
//		c.delete(1);
		
		
//		p.insert(new Product(1, "辣条", 10.0f,30.0f, 10, 1, DButil.d2t(new Date())));
//		System.out.println(p.selectById(1));
//		Product product = p.selectById(1);
//		product.setName("饼干");
//		System.out.println(p.update(product));
		
//		a.insert(new User(1,"张博","zhangbo","lh0812",1));
//		a.insert(new User(2,"阿斯弗","lisi","123456",10));
//		User user = a.selectById(1);
//		System.out.println(user.getName());
//		a.update(new User(3,"爱睡觉的","lisi","123456",10));
//		a.deleteById(3);
//		List<User> list = a.selectAll();
//		for (User user : list) {
//			System.out.println(user.getName());
//		}
//		System.out.println(a.selectByAccount("zhangbo"));
//		System.out.println(a.selectByName("张博"));
//		System.out.println(a.selectByAccountAndPassword("zhangbo", "lh0812"));
	}
}
