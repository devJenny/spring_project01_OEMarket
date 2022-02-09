package com.OEMarket.service;

import java.util.List;

import com.OEMarket.dto.CommentDTO;

/** 
 * @author 강경모
 * 2021-12-13
 */
public interface CommentService {
	
	// 작성과 수정을 registerComment에서 모두 구현
	public boolean registerComment(CommentDTO params);
	
	public boolean deleteComment(Long idx);
	
	public List<CommentDTO> getCommentList(CommentDTO params);
	
}
