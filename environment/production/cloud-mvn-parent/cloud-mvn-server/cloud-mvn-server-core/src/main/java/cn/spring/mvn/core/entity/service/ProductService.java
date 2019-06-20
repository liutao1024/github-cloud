package cn.spring.mvn.core.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.entity.Product;

public interface ProductService extends IBatisService<Product>{
	public List<Product> selectAll();
}
