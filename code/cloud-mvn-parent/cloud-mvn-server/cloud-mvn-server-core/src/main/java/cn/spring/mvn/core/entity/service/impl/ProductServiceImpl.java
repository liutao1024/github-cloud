package cn.spring.mvn.core.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.entity.Product;
import cn.spring.mvn.core.entity.dao.ProductDao;
import cn.spring.mvn.core.entity.service.ProductService;


@Service("ProductService")
public class ProductServiceImpl extends IBatisServiceImpl<Product> implements ProductService{
	@Resource
	private ProductDao dao;
	@Override
	public List<Product> selectAll() {
		return dao.selectAll();
	}

}
