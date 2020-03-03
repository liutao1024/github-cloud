package cn.spring.mvn.web.test;

//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.spring.mvn.system.entity.SysAuth;

import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;


public class JustTest {
	private static final Logger logger = LoggerFactory.getLogger(JustTest.class);
	@Test
	public void Test0001(){
		logger.info("====%s====%s====", "ABC", "abc");
	}
	@Test
	public void Test0002(){
		String s = "[SysAuth [regist_cd=001, auth_type=2, auth_cd=10000000, menu_name=系统设置, auth_url=, parent_auth_cd=, rank=1, sortno=null, iconfg=fa fa-cogs, target_flag=null, children=[SysAuth [regist_cd=001, auth_type=2, auth_cd=10200001, menu_name=柜员设置, auth_url=/system/user, parent_auth_cd=10000000, rank=2, sortno=null, iconfg=fa fa-cog, target_flag=null, children=null, haschild=null], SysAuth [regist_cd=001, auth_type=2, auth_cd=10200002, menu_name=角色设置, auth_url=/system/role, parent_auth_cd=10000000, rank=2, sortno=null, iconfg=fa fa-cog, target_flag=null, children=null, haschild=null], SysAuth [regist_cd=001, auth_type=2, auth_cd=10200003, menu_name=权限设置, auth_url=/system/meun, parent_auth_cd=10000000, rank=2, sortno=null, iconfg=fa fa-cog, target_flag=null, children=null, haschild=null]], haschild=Y], SysAuth [regist_cd=001, auth_type=2, auth_cd=20000000, menu_name=客户管理, auth_url=, parent_auth_cd=, rank=1, sortno=null, iconfg=fa fa-users, target_flag=null, children=[SysAuth [regist_cd=001, auth_type=2, auth_cd=20200001, menu_name=客户信息, auth_url=/cust/custinfo, parent_auth_cd=20000000, rank=2, sortno=null, iconfg=fa fa-user, target_flag=null, children=null, haschild=null], SysAuth [regist_cd=001, auth_type=2, auth_cd=20200002, menu_name=转帐处理, auth_url=, parent_auth_cd=20000000, rank=2, sortno=null, iconfg=fa fa-gift, target_flag=null, children=[SysAuth [regist_cd=001, auth_type=2, auth_cd=20300001, menu_name=转入, auth_url=/cust/rollin, parent_auth_cd=20200002, rank=3, sortno=null, iconfg=fa fa-gift, target_flag=null, children=[SysAuth [regist_cd=001, auth_type=2, auth_cd=203000011, menu_name=测试001, auth_url=, parent_auth_cd=20300001, rank=4, sortno=null, iconfg=fa fa-book, target_flag=null, children=null, haschild=null]], haschild=Y], SysAuth [regist_cd=001, auth_type=2, auth_cd=20300002, menu_name=转出, auth_url=/cust/rollout, parent_auth_cd=20200002, rank=3, sortno=null, iconfg=fa fa-gift , target_flag=null, children=null, haschild=null]], haschild=Y]], haschild=Y]]";
//		HashMap<String, String> jsonObjmap = new HashMap<String, String>();
        List<SysAuth> jsonObject = JSONArray.parseArray(s, SysAuth.class);
        System.out.println(jsonObject.toString());
//        Iterator it = jsonObject.keys();
//        while (it.hasNext()) {
//            String key = String.valueOf(it.next());
//            String value = jsonObject.get(key) == null ? "" : jsonObject.get(key).toString();
//            jsonObjmap.put(key, value);
//        }
	}
}
