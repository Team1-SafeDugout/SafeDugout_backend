package com.bullPenTalk.app.payment.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.config.MyBatisConfig;

public class PaymentDAO {
	public SqlSession sqlSession;
	
	public PaymentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
    public int decreaseBuyerPoint(Map<String, Object> param) {
        return sqlSession.update("trade.decreaseBuyerPoint", param);
    }

    public int increaseSellerPoint(Map<String, Object> param) {
        return sqlSession.update("trade.increaseSellerPoint", param);
    }

    public int insertTradePost(Map<String, Object> param) {
        return sqlSession.insert("trade.insertTradePost", param);
    }

    public int updateSellPostStatus(int sellPostNumber) {
        return sqlSession.update("trade.updateSellPostStatus", sellPostNumber);
    }
}

