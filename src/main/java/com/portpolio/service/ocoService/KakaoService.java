package com.portpolio.service.ocoService;

import com.portpolio.domain.dto.ocoDto.KakaoUserDTO;

public interface KakaoService {
	// kakao로그인시 먼저 idx 찾음
	public boolean findKakao(String kakao_idx);

	// idx 없을경우 isert
	public boolean insert(KakaoUserDTO kakaoUser);

}
