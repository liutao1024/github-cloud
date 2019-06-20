package cn.spring.mvn.basic.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.basic.util.BasicUtil;
//import cn.spring.mvn.basic.util.BasicUtilHqlFilter;

/**
 * @author LiuTao @date 2019年1月31日 下午8:15:09
 * @ClassName: HibernateServiceImpl 
 * @Description: 用@Service和@Repository同样的效果
 * @param <T>
 */
//@Service
@Repository("HibernateService")
@SuppressWarnings({"unchecked", "rawtypes"})
public class HibernateServiceImpl<T> implements HibernateService<T>{
	/**
	 * 实体类.class
	 */
	protected Class<T> entityClazz;
	/**
	 * 实体类名称
	 */
	protected String entityClazzName;
	/**
	 * 数据库方言
	 */
	private Dialect dialect;
	private Boolean booleanOne;
	private Boolean booleanTwo;
	private Boolean booleanThree;
	private Boolean booleanFour;
	
	@Autowired
	private HibernateDao<T> hibernateDaoImpl;
	/**
	 * <p>Title: </p> 
	 * <p>Description: 构造函数</p>
	 */
	public HibernateServiceImpl() {
		this.entityClazz = (Class<T>) getSuperClassGenricType(getClass(), 0);
		this.entityClazzName = this.entityClazz.getSimpleName();
	}
	
	
	@Override
	public Dialect getDialect() {
		return this.hibernateDaoImpl.getDialect();
	}
	@Override
	public boolean isMySQL() {
		if (this.booleanOne == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanOne = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "MySQL"));
			}
		}
		return this.booleanOne != null ? this.booleanOne.booleanValue() : false;
	}
	@Override
	public boolean isPostgreSQL() {
		if (this.booleanTwo == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanTwo = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "PostgreSQL"));
			}
		}
		return this.booleanTwo != null ? this.booleanTwo.booleanValue() : false;
	}
	@Override
	public boolean isOracle() {
		if (this.booleanThree == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanThree = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "Oracle"));
			}
		}
		return this.booleanThree != null ? this.booleanThree.booleanValue() : false;
	}
	@Override
	public boolean isSQLServer() {
		if (this.booleanFour == null) {
			if (this.dialect == null) {
				this.dialect = getDialect();
			}
			if (this.dialect != null) {
				String str = this.dialect.toString();
				this.booleanFour = Boolean.valueOf(StringUtils.containsIgnoreCase(str, "SQLServer"));
			}
		}
		return this.booleanFour != null ? this.booleanFour.booleanValue() : false;
	}
	//
	@Override
	public T saveEntity(T entity) throws Exception {
		return hibernateDaoImpl.saveEntity(entity);
	}
	@Override
	public List<T> saveEntities(List<T> entities) throws Exception {
		return hibernateDaoImpl.saveEntities(entities);
	}
	@Override
	public void saveOrUpdate(T entity) {
		this.hibernateDaoImpl.saveOrUpdate(entity);
	}
	@Override
	public void deleteEntity(T entity) {
		hibernateDaoImpl.deleteEntity(entity);
	}
	@Override
	public void deleteEntities(List<T> entities) {
		hibernateDaoImpl.deleteEntities(entities);
	}
	@Override
	public T selectOneEntity(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.findOneByHqlParamMap(hqlStr, paramMap);
	}
	@Override
	public List<T> selectAllEntities(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.findAllByHqlParamMap(hqlStr, paramMap);
	}
	@Override
	public List<T> selectAllEntitiesWihtPageSize(T entity, int page, int size) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.findAllByHqlParamMapPageSize(hqlStr, paramMap, page, size);
	}
	@Override
	public void updateEntity(T entity) {
		hibernateDaoImpl.updateEntity(entity);
	}
	@Override
	public void updateEntities(List<T> entities) {
		hibernateDaoImpl.updateEntities(entities);
	}

	
//	@Override
//	public List<T> findByFilter(BasicUtilHqlFilter hqlFilter) {
//		String str1 = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
//		String str2 = "select distinct t from " + str1 + " t";
//		return hibernateDaoImpl.findAllByHqlParamMap(str2 + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams());
//	}
//	@Override
//	public List<T> findByFilter(BasicUtilHqlFilter hqlFilter, int page, int size) {
//		String str1 = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
//		String str2 = "select distinct t from " + str1 + " t";
//		return hibernateDaoImpl.findAllByHqlParamMapPageSize(str2 + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), page, size);
//	}
	
	@Override
	public long countByFilter() {
		return 0;
//		return countByFilter(new BasicUtilHqlFilter());
	}
	@Override
	public void commit() {
		this.hibernateDaoImpl.commit();
	}
	@Override
	public void rollback() {
		this.hibernateDaoImpl.rollback();
	}

	

	@Override
	public long count(T entity) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.countByHqlParamMap(hqlStr, paramMap);
	}

//	@Override
//	public long countByFilter(BasicUtilHqlFilter paramHqlFilter) {
//		return 0;
//	}
	
	@Override
	public List<T> findAllByHql(String hqlStr) {
		return hibernateDaoImpl.findAllByHql(hqlStr);
	}
	@Override
	public T findOneByHql(String hqlStr) {
		return hibernateDaoImpl.findOneByHql(hqlStr);
	}


	@Override
	public List<T> findAllBySql(String sqlStr) {
		return (List<T>) hibernateDaoImpl.findAllBySql(sqlStr);
	}
	/**
	 * @author LiuTao 
	 */
	@Override
	public T findOneBySql(String sqlStr) {
		return hibernateDaoImpl.findOneBySql(sqlStr);
	}
	
	@Override
	public List<T> findAll(T entity){
		String hqlStr = "from " + entity.getClass().getSimpleName() ;
		return hibernateDaoImpl.findAllByHql(hqlStr);
	}
	
	@Override
	public List<T> findAllByEntity(T entity){
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.findAllByHqlParamMap(hqlStr, paramMap);
	}
	
	/**
	 * @author LiuTao @date 2018年5月30日 下午2:38:22 
	 * @Title: getSuperClassGenricType 
	 * @Description: 
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class<Object> getSuperClassGenricType(Class clazz, int index) {
		Type localType = clazz.getGenericSuperclass();
		if (!(localType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] arrayOfType = ((ParameterizedType) localType).getActualTypeArguments();
		if ((index >= arrayOfType.length) || (index < 0)) {
			return Object.class;
		}
		if (!(arrayOfType[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) arrayOfType[index];
	}


	@Override
	public List<T> findAllByEntityPageSize(T entity, int page, int size) {
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getSqlStrByEntityNameAndParamMap(entityName, paramMap);
		return hibernateDaoImpl.findAllByHqlParamMapPageSize(hqlStr, paramMap, page, size);
	}


	@Override
	public List<T> findAllByHqlPageSize(String hqlStr, int page, int size) {
		List<T> list = hibernateDaoImpl.findAllByHqlPageSize(hqlStr, page, size);
		return list;
	}


	@Override
	public List<T> findAllBySqlPageSize(String sqlStr, int page, int size) {
		return (List<T>) hibernateDaoImpl.findAllBySqlPageSize(sqlStr, page, size);
	}
	
	@Override
	public Map<String, Object> findAllByEntityPageSizeWithCount(T entity, int page, int size) {
		Map<String, Object> rstMap = new HashMap<String, Object>();
		List<T> list = findAllByEntityPageSize(entity, page, size);
		String entityName = entity.getClass().getSimpleName();
		Map<String, Object> paramMap = BasicReflection.getMapByReflectWithOutNullValueObject(entity);
		String hqlStr = BasicUtil.getHqlByEntityNameAndParamMap(entityName, paramMap);
		long count = findAllByHql(hqlStr).size();
		rstMap.put("count", count);
		rstMap.put("result", list);
		rstMap.put("page", page);
		rstMap.put("size", size);
		return rstMap;
	}

	@Override
	public Map<String, Object> findAllByHqlPageSizeWithCount(String hqlStr, int page, int size) {
		Map<String, Object> rstMap = new HashMap<String, Object>();
		List<T> list = findAllByHqlPageSize(hqlStr, page, size);
		long count = findAllByHql(hqlStr).size();
		rstMap.put("count", count);
		rstMap.put("result", list);
		rstMap.put("page", page);
		rstMap.put("size", size);
		return rstMap;
	}

}
