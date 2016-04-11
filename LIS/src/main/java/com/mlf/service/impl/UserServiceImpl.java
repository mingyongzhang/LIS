package com.mlf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mlf.entity.UserInfo;
import com.mlf.mapper.UserInfoMapper;
import com.mlf.service.IUserService;

/**
 * 用户信息业务逻辑操作接口实现
 * 
 * @author MINGYONGZHANG
 *
 */
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfoMapper getUserInfoMapper() {
		return userInfoMapper;
	}

	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}

	@Override
	public UserInfo getUserInfoById(int userId) {
		return this.userInfoMapper.getUserInfoById(userId);
	}

	@Override
	public List<UserInfo> getUserInfoList() {
		return this.userInfoMapper.getUserInfoList();
	}

	@Override
	public UserInfo insertUserEntity(UserInfo userInfo) {
		this.userInfoMapper.insertUser(userInfo);

		return getUserInfoById(userInfo.getUserId());
	}

}
