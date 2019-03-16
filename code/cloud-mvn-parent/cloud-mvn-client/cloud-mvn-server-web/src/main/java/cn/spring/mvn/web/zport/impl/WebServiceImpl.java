package cn.spring.mvn.web.zport.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.spring.mvn.comm.tools.MD5Tool;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.system.entity.SysAuth;
import cn.spring.mvn.system.entity.SysRoleAuth;
import cn.spring.mvn.system.entity.SysUser;
import cn.spring.mvn.system.entity.SysUserRole;
import cn.spring.mvn.system.entity.service.SysAuthService;
import cn.spring.mvn.system.entity.service.SysRoleAuthService;
import cn.spring.mvn.system.entity.service.SysUserRoleService;
import cn.spring.mvn.system.entity.service.SysUserService;
import cn.spring.mvn.web.zport.GtmenuInput;
import cn.spring.mvn.web.zport.GtmenuOutput;
import cn.spring.mvn.web.zport.ResetsInput;
import cn.spring.mvn.web.zport.ResetsOutput;
import cn.spring.mvn.web.zport.UserinInput;
import cn.spring.mvn.web.zport.UserinOutput;

/**
 * @Author LiuTao @Date 2019年1月2日 上午10:37:09
 * @ClassName: WebServiceImpl 
 * @Description: Web端柜员校验/登录,角色/权限控制的对应实现类
 */
public class WebServiceImpl extends SpringContextUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceImpl.class);
	private static String AUTHTYPE = "2";//菜单权限类型
	private static String[] STRARRAY = {};//user用    有权限AuthCd数组
	@SuppressWarnings("unused")
	private static final String PASSWD = MD5Tool.md5EncryptString("123456");
	
	private static SysUserService sysUserServiceImpl = (SysUserService) applicationContext.getBean(SysUserService.class);
	private static SysAuthService sysAuthServiceImpl = (SysAuthService) applicationContext.getBean(SysAuthService.class);
	private static SysUserRoleService sysUserRoleServiceImpl = (SysUserRoleService) applicationContext.getBean(SysUserRoleService.class);
	private static SysRoleAuthService sysRoleAuthServiceImpl = (SysRoleAuthService) applicationContext.getBean(SysRoleAuthService.class);
	/**
	 * @Author LiuTao @Date 2019年1月2日 上午10:45:52 
	 * @Title: resetUserStatus 
	 * @Description: 柜员重置登录状态 
	 * @param input
	 * @param output
	 */
	public static void resetUserStatus(ResetsInput input, ResetsOutput output){
		String status = "success";
		String mesage = "状态重置成功";
		SysUser resetSysUser = sysUserServiceImpl.selectOneByPrimeKey(input.getCropno(), input.getUserid());
		if(CommUtil.isNotNull(resetSysUser) || CommUtil.notEqual("1", resetSysUser.getStatus())){
			if(input.getIschck()){//
				if(CommUtil.equal(input.getPasswd(), resetSysUser.getPasswd())){//
					resetSysUser.setErrort(0);
					resetSysUser.setUserst("0");
					sysUserServiceImpl.update(resetSysUser);
				}else {
					status = "error";
					mesage = "状态重置失败,密码不正确";
				}
			}else {//
				resetSysUser.setErrort(0);
				resetSysUser.setUserst("0");
				sysUserServiceImpl.update(resetSysUser);
			}
		}else {
			status = "error";
			mesage = "状态重置失败,账户:" + input.getUserid() + "不存在,或未启用";
		}
		output.setStatus(status);
		output.setMesage(mesage);
	}
	/**
	 * @Author LiuTao @Date 2019年1月2日 上午10:45:52 
	 * @Title: loginCheck 
	 * @Description: 柜员登录 
	 * @param input
	 * @param output
	 * @throws Exception 
	 */
	public static void loginCheck(UserinInput input, UserinOutput output) throws Exception{
		boolean checkPasswdFlag = input.getPswdfg();
		SysUser checkSysUser = sysUserServiceImpl.selectOneByPrimeKey(input.getCropno(), input.getUserid());
		//账户存在未登录且密码错误次数不大于最大错误次数状态为启用状态
		if(CommUtil.isNotNull(checkSysUser) && CommUtil.equal(checkSysUser.getUserst(), "0") 
				&& CommUtil.compare(checkSysUser.getMaxert(), checkSysUser.getErrort()) >= 0 && CommUtil.equal("1", checkSysUser.getStatus())){
			if(checkPasswdFlag){
				if(CommUtil.notEqual(input.getPasswd(), checkSysUser.getPasswd())){
					int time = checkSysUser.getErrort() + 1;//密码错误次数加1
					checkSysUser.setErrort(time);
					sysUserServiceImpl.update(checkSysUser);
					throw new Exception("登录失败,密码错误:" + time + "次");
				}
			}
			checkSysUser.setErrort(0);
			checkSysUser.setUserst("1");
			sysUserServiceImpl.update(checkSysUser);
		}else {
			throw new Exception("登录失败");
		}
		output.setBrchno(checkSysUser.getBrchno());
		output.setSystdt("20190101");
		output.setUserna(checkSysUser.getUserna());
	}
	/**
	 * @author LiuTao @date 2019年2月25日 上午9:37:49 
	 * @Title: accessToTheMenu 
	 * @Description: 获取菜单
	 */
	public static void accessToTheMenu(GtmenuInput input, GtmenuOutput output) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRegist_cd(input.getCropno());
		sysUserRole.setAuth_type(AUTHTYPE);// 菜单权限为2
		sysUserRole.setUser_cd(input.getUserid());
		/**得到柜员的角色      
		 * 一个柜员可能对应多个角色
		 */
		List<SysUserRole> sysUserRoleList = sysUserRoleServiceImpl.queryEntitiesByEntityParamMap(sysUserRole);
		List<SysRoleAuth> sysRoleAuthList = new ArrayList<SysRoleAuth>();
		SysRoleAuth sysRoleAuth = new SysRoleAuth();
		for (SysUserRole theSysUserRole : sysUserRoleList) {
			/**通过角色来查询 角色权限
			 * 一个角色可能会有多个 权限
			 */
			sysRoleAuth.setRegist_cd(theSysUserRole.getRegist_cd());
			sysRoleAuth.setAuth_type(theSysUserRole.getAuth_type());
			sysRoleAuth.setRole_cd(theSysUserRole.getRole_cd());
			sysRoleAuthList.addAll(sysRoleAuthServiceImpl.selectAllEntities(sysRoleAuth));
		}
		//权限去重复
		HashSet<SysRoleAuth> hashSet = new HashSet<SysRoleAuth>(sysRoleAuthList);
		sysRoleAuthList.clear();
		sysRoleAuthList.addAll(hashSet);
		int k = 0;
		STRARRAY = new String[sysRoleAuthList.size()];
		for (SysRoleAuth theSysAuthRole : sysRoleAuthList) {
			STRARRAY[k] = theSysAuthRole.getAuth_cd();//菜单编号
			k++;
		}
		// 查询所有菜单
		SysAuth sysAuth = new SysAuth();
		sysAuth.setRegist_cd(input.getCropno());//机构号
		sysAuth.setAuth_type(AUTHTYPE);// 2 为菜单权限
		sysAuth.setRank(1);//从第一级开始取
		List<SysAuth> sysAuthList = new ArrayList<SysAuth>();
		sysAuthList.addAll(sysAuthServiceImpl.selectAllEntities(sysAuth));		
		Map<String, Object> sysAuthMap = new HashMap<String, Object>();
		sysAuthMap.put("menu", reGetMenu(sysAuth, sysAuthList, sysAuth.getRank(), true));
		LOGGER.info("---------菜单" + sysAuthMap.toString());
//		output.setMeumap(sysAuthMap.toString());//返回的菜单内容
	}
	
	
	/**---------------------------------------20190225----------------------------------------------------*/
	/**
	 * @author LiuTao @date 2018年5月7日 下午7:46:26 
	 * @Title: reGetMenu 
	 * @Description: TODO(根据sysAuth查询子项) 
	 * @param entity 权限模板
	 * @param parentMenu 父级菜单权限
	 * @param rank 层级
	 * @param flag 是否控制权限 true控制权限 false不控制
	 * @return
	 */
	private static List<SysAuth> reGetMenu(SysAuth entity, List<SysAuth> parentMenu, int rank, Boolean flag) {
		// 取1级菜单		
		List<SysAuth> removeList = new ArrayList<SysAuth>();// list 遍历元素时不允许删除元素,创建一个List用于储存删除的元素,遍历后集中集中删除
		/**
		 * 循环遍历这一级菜单,分别获取下一级级菜单
		 */
		for (SysAuth sysAuth : parentMenu) {// 循环处理父菜单
			/**
			 * 判断user是否拥有权限
			 * 无父级菜单权限,子菜单权限无效
			 */
			if (strInArray(sysAuth.getAuth_cd(), STRARRAY) && flag) { 
				removeList.add(sysAuth);// 放入删除List中
				continue;
			}
			entity.setRank(rank + 1);// 取下一级菜单级菜单
			entity.setParent_auth_cd(sysAuth.getAuth_cd());// 设置父级cored
			List<SysAuth> childMenu = new ArrayList<SysAuth>();
			
			childMenu.addAll(sysAuthServiceImpl.selectAllEntities(entity));
			if (childMenu.size() > 0) {
				sysAuth.setChildren(reGetMenu(entity, childMenu, entity.getRank(), flag));// 递归处理
				sysAuth.setHaschild("Y");
			}
		}
		parentMenu.removeAll(removeList);
		return parentMenu;
	}
	/**
	 * @author LiuTao @date 2018年5月7日 下午7:45:42 
	 * @Title: strInArray 
	 * @Description: TODO(判断字符串数组是否包含字符串) 
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean strInArray(String str, String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (str.equals(strs[i])) {
				return false;
			}
		}
		return true;
	}
	
}
