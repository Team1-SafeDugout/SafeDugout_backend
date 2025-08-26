package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AdminTradeListDTO;
import com.bullPenTalk.app.dto.TradePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTradeDAO {

	public SqlSession sqlSession;

	public AdminTradeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}


	// 목록 조회

	public List<TradePostDTO> select() {
		return sqlSession.selectList("adminTrade.selectAll");
	}
	
	public List<AdminTradeListDTO> selectInfo(Map<String, Integer> pageMap){
		return sqlSession.selectList("adminTrade.selectAllInfo", pageMap);
	}
	
	// 상세조회
	public TradePostDTO selectDetail(int tradingPostNumber) {
		return sqlSession.selectOne("adminTrade.selectSellPostDetail", tradingPostNumber);
	}


	public int getTotal() {
		return select().size();
	}
}
