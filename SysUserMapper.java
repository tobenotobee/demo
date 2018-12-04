package cn.bluemobi.admin.dao.mybatis;

import java.util.List;
import java.util.Map;

import cn.bluemobi.admin.model.SysUser;

/***
 * 用户管理数据访问Mapper
 * @author hug
 *
 */
public interface SysUserMapper {

	/**
	 * 新增用户信息
	 * @param sysUser
	 * @return
	 */
	public int insertSysUser(SysUser sysUser);
	
	/**
	 * 修改用户信息
	 * @param sysUser
	 * @return
	 */
	public int updateSysUser(SysUser sysUser);
	
	/**
	 * 根据登录用户名修改用户信息
	 * @param sysUser
	 * @return
	 */
	public int updateSysUserByUserName(SysUser sysUser);
	
	/**
	 * 根据用户ID获取用户信息
	 * @param userId
	 * @return
	 */
	public SysUser getSysUser(String userId);
	
	/**
	 * 根据用户ID删除用户信息
	 * @param userId
	 * @return
	 */
	public int deleteSysUser(String userId);
	
	/**
	 * 根据登陆用户名获取用户信息
	 * @param userName
	 * @return
	 */
	public SysUser getSysUserByName(String userName);
	
	/**
	 * 分页查询用户信息
	 * @param paramap 查询条件以及分页参数map
	 * @return
	 */
	public List<SysUser> getSysUsersByPage(Map<String,Object> paramap);
	
	/**
	 * 分页查询记录统计
	 * @param paramap 查询条件map
	 * @return
	 */
	public long getSysUsersCount(Map<String,Object> paramap);
	
	/**
	 * 设置对应角色ID的用户所属角色ID为空
	 * @param roleId
	 */
	public int updateSysUserRoleToNull(long roleId);
	
}
