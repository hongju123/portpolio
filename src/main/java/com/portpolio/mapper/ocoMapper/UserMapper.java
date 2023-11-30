package com.portpolio.mapper.ocoMapper;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO findById(String userId);
	public UserDTO findByUser(String userId,String userPassword);
	public UserDTO findByEmail(String email);
	public UserDTO findByUserInfo(UserDTO user);
	int insertUser(UserDTO user);
	public boolean withdrawUser(String userId);
	public boolean withdrawBusinessUser(String userId);
}
