package cn.spring.mvn.client.web.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.exception.SumpException;
import cn.spring.mvn.client.web.model.RoleAuth;
import cn.spring.mvn.client.web.model.SifSysRoleAuth;
import cn.spring.mvn.client.web.model.dao.SifSysRoleAuthDao;
import cn.spring.mvn.client.web.model.primarykey.SifSysRoleAuthPk;
import cn.spring.mvn.client.web.model.service.SifSysRoleAuthService;

@Service("SifSysRoleAuthService")
public class SifSysRoleAuthServiceImpl implements SifSysRoleAuthService {
	@Autowired
	SifSysRoleAuthDao sifSysRoleAuthDao;

	@Override
	public SifSysRoleAuth expandEntity(SifSysRoleAuth entity) {
		SifSysRoleAuthPk id = new SifSysRoleAuthPk(entity.getRegisterCd(), entity.getAuthType(), entity.getRoleCd(),  entity.getAuthCd());
		
		return sifSysRoleAuthDao.findOne(id);
	}

	@Override
	public boolean checkUnique(SifSysRoleAuthPk id) {
		return !sifSysRoleAuthDao.exists(id);
	}

	@Override
	public SifSysRoleAuth saveEntity(SifSysRoleAuth entity) throws Throwable {
		SifSysRoleAuthPk id = new SifSysRoleAuthPk(entity.getRegisterCd(), entity.getAuthType(), entity.getRoleCd(),  entity.getAuthCd());
		if(!checkUnique(id)){
			throw new SumpException("1001");
		}
		
		return sifSysRoleAuthDao.save(entity);
	}

	@Override
	public List<SifSysRoleAuth> saveEntities(List<SifSysRoleAuth> entities)
			throws Throwable {
		for(SifSysRoleAuth entity:entities){
			SifSysRoleAuthPk id = new SifSysRoleAuthPk(entity.getRegisterCd(), entity.getAuthType(), entity.getRoleCd(), entity.getAuthCd());
			if(!checkUnique(id)){
				throw new SumpException("1001");
			}
		}
		
		return sifSysRoleAuthDao.save(entities);
	}

	@Override
	public void deleteEntity(SifSysRoleAuth entity) {
		sifSysRoleAuthDao.delete(entity);
	}

	@Override
	public void deleteEntities(List<SifSysRoleAuth> entities) {
		sifSysRoleAuthDao.delete(entities);
	}

	@Override
	public void deleteAllInBatch() {
		sifSysRoleAuthDao.deleteAllInBatch();
	}

	@Override
	public List<SifSysRoleAuth> queryEntitiesByTemplate(RoleAuth tmp) {
		return sifSysRoleAuthDao.queryEntitiesByTemplate(tmp);
	}
	
	@Override
	public List<SifSysRoleAuth> queryEntitiesByTemplateWithSort(RoleAuth tmp, Sort sort) {
		return sifSysRoleAuthDao.queryEntitiesByTemplate(tmp, sort);
	}

	@Override
	public Page<SifSysRoleAuth> queryEntitiesByTemplateWithPage(
			RoleAuth tmp, Pageable pageable) {
		return sifSysRoleAuthDao.queryEntitiesByTemplate(tmp, pageable);
	}

}
