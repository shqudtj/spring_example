package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service	// Spring Bean
public class UsedGoodsBO {
	
	// input: X		컨트롤러 한테 주는게 없음
	
	// output: List<UsedGoods>		컨트롤러 한테
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList;
	}
	
}
