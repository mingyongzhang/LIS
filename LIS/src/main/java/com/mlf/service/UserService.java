package com.mlf.service;

import java.util.List;

import com.mlf.entity.UserInfo;

/**
 * 用户信息业务逻辑操作接口
 * 
 * @author MINGYONGZHANG
 *
 */
public interface UserService {

	UserInfo getUserInfoById(String userId);

	List<UserInfo> getUserInfoList();

//	UserInfo insertUserEntity(UserInfo userInfo);
}
