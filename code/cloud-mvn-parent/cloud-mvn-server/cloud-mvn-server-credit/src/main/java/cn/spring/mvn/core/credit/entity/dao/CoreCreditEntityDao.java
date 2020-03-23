package cn.spring.mvn.core.credit.entity.dao;

import java.util.List;

import cn.spring.mvn.core.credit.entity.CoreCreditEntity;

public interface CoreCreditEntityDao {
	public List<CoreCreditEntity> selectCoreCreditEntityList();
}
