package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysRoleAuth;
import cn.spring.mvn.client.web.model.primarykey.SifSysRoleAuthPk;

@Service("SifSysRoleAuthRepository")
public interface SifSysRoleAuthRepository extends Repository<SifSysRoleAuth, SifSysRoleAuthPk> {

	/**
	 * 获取系统角色下的不同权限类型的权限列表
	 * @param registerCd
	 * @param authType: 1--操作权限  2--菜单权限
	 * @param roleCd
	 * @return the list of authCd
	 */
	@Query(value = "select distinct(ra.authCd) from SifSysRoleAuth ra where ra.registerCd = ?1 and ra.authType = ?2 and ra.roleCd = ?3")
	public List<String> getAuthCdListByRegisterCdAndAuthTypeAndRoleCd(String registerCd, String authType, String roleCd);
}
