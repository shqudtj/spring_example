package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewMapper;
import com.example.lesson03.domain.Review;

@Service
public class ReviewBO {

	// field
	@Autowired
	private ReviewMapper reviewMapper;

	// input: id
	// output: id에 일치하는 Review 단건 => Controller한테
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}

	// input: Review
	// output: 성공된 행의 개수 int
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
//	addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛있다!!");
	// 밑 처럼 파라미터에 변수를 해당하는 클래스만 일치시키면 됨 매퍼나 xml restController의 변수명과 달라도 됨
	public int addReviewAsField(int storeId123, String menu123, String userName123, 
			double point321, String review321) {
		
		return reviewMapper.insertReviewAsField(storeId123, menu123, userName123, point321, review321);
	}
	
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}

