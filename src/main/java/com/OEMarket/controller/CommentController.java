package com.OEMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.OEMarket.dto.CommentDTO;
import com.OEMarket.service.CommentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author 강경모 2021-12-13
 */
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = { "/comments", "/comments/{commentNo}" }, method = { RequestMethod.POST,
			RequestMethod.PATCH })
	public JsonObject registerComment(@PathVariable(value = "commentNo", required = false) Long commentNo,
			@RequestBody final CommentDTO params) {

		JsonObject jsonObj = new JsonObject();

		try {
			if (commentNo != null) {
				params.setCommentNo(commentNo);
			}

			boolean isRegistered = commentService.registerComment(params);
			jsonObj.addProperty("result", isRegistered);
		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");
		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}
		
		return jsonObj;
	}

	@GetMapping(value = "/comments/{boardNo}")
	public JsonObject getCommentList(@PathVariable("boardNo") Long boardNo,
			@ModelAttribute("params") CommentDTO params) {

		JsonObject jsonObj = new JsonObject();

		List<CommentDTO> commentList = commentService.getCommentList(params);
		
		if (CollectionUtils.isEmpty(commentList) == false) {
			JsonArray jsonArr = new Gson().toJsonTree(commentList).getAsJsonArray();
			jsonObj.add("commentList", jsonArr);
		}
		return jsonObj;
	}

	@DeleteMapping(value = "/comments/{commentNo}")
	public JsonObject deleteComment(@PathVariable("commentNo") final Long commentNo) {
		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = commentService.deleteComment(commentNo);
			jsonObj.addProperty("result", isDeleted);
			
		} catch (DataAccessException e) {
			jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");
		} catch (Exception e) {
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}

}
