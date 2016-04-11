package com.mlf.mapper;

import java.util.List;

import com.mlf.entity.UserInfo;

/**
 * 用户信息接口
 * 
 * @author MINGYONGZHANG
 *
 */
public interface UserInfoMapper {

	UserInfo getUserInfoById(int userId);

	List<UserInfo> getUserInfoList();

	int insertUser(UserInfo userInfo);
}
