package com.portpolio.mapper.ocoMapper;

import org.apache.ibatis.annotations.Mapper;

import com.portpolio.domain.dto.ocoDto.KakaoUserDTO;


@Mapper
public interface KakaoUserMapper {
	public KakaoUserDTO findByUser(String kakaoidx);
	public int insertUser(KakaoUserDTO kakaoUser);
}
