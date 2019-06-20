package cn.spring.mvn.client.web.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JustTest {
	private static final Logger logger = LoggerFactory.getLogger(JustTest.class);
	@Test
	public void Test0001(){
		logger.info("====%s====%s====", "ABC", "abc");
	}
	@Test
	public void Test0002(){
//		String s = "{menu=[{auth_cd=10000000, auth_type=2, auth_url=, children=[{auth_cd=10200001, auth_type=2, auth_url=/system/user, children=[], haschild=, iconfg=fa fa-cog, menu_name=柜员设置, parent_auth_cd=10000000, rank=2, regist_cd=001, sortno=}, {auth_cd=10200002, auth_type=2, auth_url=/system/role, children=[], haschild=, iconfg=fa fa-cog, menu_name=角色设置, parent_auth_cd=10000000, rank=2, regist_cd=001, sortno=}, {auth_cd=10200003, auth_type=2, auth_url=/system/meun, children=[], haschild=, iconfg=fa fa-cog, menu_name=权限设置, parent_auth_cd=10000000, rank=2, regist_cd=001, sortno=}], haschild=Y, iconfg=fa fa-cogs, menu_name=系统设置, parent_auth_cd=, rank=1, regist_cd=001, sortno=}, {auth_cd=20000000, auth_type=2, auth_url=, children=[{auth_cd=20200001, auth_type=2, auth_url=/cust/custinfo, children=[], haschild=, iconfg=fa fa-user, menu_name=客户信息, parent_auth_cd=20000000, rank=2, regist_cd=001, sortno=}, {auth_cd=20200002, auth_type=2, auth_url=, children=[{auth_cd=20300001, auth_type=2, auth_url=/cust/rollin, children=[{auth_cd=203000011, auth_type=2, auth_url=, children=[], haschild=, iconfg=fa fa-book, menu_name=测试001, parent_auth_cd=20300001, rank=4, regist_cd=001, sortno=}], haschild=Y, iconfg=fa fa-gift, menu_name=转入, parent_auth_cd=20200002, rank=3, regist_cd=001, sortno=}, {auth_cd=20300002, auth_type=2, auth_url=/cust/rollout, children=[], haschild=, iconfg=fa fa-gift , menu_name=转出, parent_auth_cd=20200002, rank=3, regist_cd=001, sortno=}], haschild=Y, iconfg=fa fa-gift, menu_name=转帐处理, parent_auth_cd=20000000, rank=2, regist_cd=001, sortno=}], haschild=Y, iconfg=fa fa-users, menu_name=客户管理, parent_auth_cd=, rank=1, regist_cd=001, sortno=}]}";
//		HashMap<String, String> jsonObjmap = new HashMap<String, String>();
//        JSONObject jsonObject = JSONObject.fromObject(s);
//        Iterator it = jsonObject.keys();
//        while (it.hasNext()) {
//            String key = String.valueOf(it.next());
//            String value = jsonObject.get(key) == null ? "" : jsonObject.get(key).toString();
//            jsonObjmap.put(key, value);
//        }
	}
}
