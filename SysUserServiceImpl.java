package cn.bluemobi.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import cn.bluemobi.admin.dao.mybatis.SysUserMapper;
import cn.bluemobi.admin.model.SysUser;
import cn.bluemobi.admin.service.SysUserService;
import cn.bluemobi.admin.util.TimeHelper;

/***
 * 用户管理服务实现
 * @author hug
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;  //用户信息数据访问
	
	@Override
	public void insertSysUser(SysUser sysUser) {
		
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		sysUser.setPassword(sha.encodePassword(sysUser.getPassword(),sysUser.getUserName()));
		sysUser.setCreateDate(TimeHelper.getCurrentLocalTime());
		sysUserMapper.insertSysUser(sysUser);

	}

	@Override
	public void updateSysUser(SysUser sysUser) {
		
		if(null!=sysUser.getPassword()&&"".equals(sysUser.getPassword())){
			sysUser.setPassword(null);
		}
		if(null!=sysUser.getPassword()){
			ShaPasswordEncoder sha = new ShaPasswordEncoder();
			sysUser.setPassword(sha.encodePassword(sysUser.getPassword(),sysUser.getUserName()));
		}
		sysUserMapper.updateSysUser(sysUser);

	}

	@Override
	public SysUser getSysUser(String userId) {
		
		return sysUserMapper.getSysUser(userId);
		
	}

	@Override
	public void deleteSysUser(String userId) {
		
		sysUserMapper.deleteSysUser(userId);

	}

	@Override
	public SysUser getSysUserByName(String userName) {
		
		return sysUserMapper.getSysUserByName(userName);
		
	}

	@Override
	public List<SysUser> getSysUsersByPage(Map<String, Object> paramap) {
		
		return sysUserMapper.getSysUsersByPage(paramap);
		
	}

	@Override
	public long getSysUsersCount(Map<String, Object> paramap) {
		
		return sysUserMapper.getSysUsersCount(paramap);
		
	}

	@Override
	public void updateSysUserByUserName(SysUser sysUser) {
		
		if(null!=sysUser.getPassword()&&"".equals(sysUser.getPassword())){
			sysUser.setPassword(null);
		}
		if(null!=sysUser.getPassword()){
			ShaPasswordEncoder sha = new ShaPasswordEncoder();
			sysUser.setPassword(sha.encodePassword(sysUser.getPassword(),sysUser.getUserName()));
		}
		sysUserMapper.updateSysUserByUserName(sysUser);
		
	}

	@Override
	public void updateSysUserRoleToNull(long roleId) {
		
		sysUserMapper.updateSysUserRoleToNull(roleId);
		
	}

	@Override
	public boolean equalsUserNameAndPassword(String userName, String password) {
		
		SysUser sysUser = sysUserMapper.getSysUserByName(userName);
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		String encodePwd = sha.encodePassword(password, userName);
		return encodePwd.equals(sysUser.getPassword());
		
	}

}
