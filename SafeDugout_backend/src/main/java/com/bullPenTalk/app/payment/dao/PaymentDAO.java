package com.bullPenTalk.app.payment.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.config.MyBatisConfig;

public class PaymentDAO {
	public SqlSession sqlSession;
	
	public PaymentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
	}
	
	// 결제 트랜젝션 처리
	public boolean processPayment(Map<String, Object> param, int sellPostNumber) {
	    PaymentDAO dao = new PaymentDAO();
	    try {
	        dao.insertTradePost(param);
	        dao.decreaseBuyerPoint(param);
	        dao.increaseSellerPoint(param);
	        dao.updateSellPostStatus(sellPostNumber);

	        dao.sqlSession.commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        dao.sqlSession.rollback();
	        return false;
	    } finally {
	        dao.sqlSession.close();
	    }
	}
	
	
	// 구매자 포인트 차감
    public int decreaseBuyerPoint(Map<String, Object> param) {
        return sqlSession.update("payment.decreaseBuyerPoint", param);
    }

    // 판매자 포인트 증가
    public int increaseSellerPoint(Map<String, Object> param) {
        return sqlSession.update("payment.increaseSellerPoint", param);
    }

    // 거래 기록 생성
    public int insertTradePost(Map<String, Object> param) {
        return sqlSession.insert("payment.insertTradePost", param);
    }

    // 거래 상태 변경
    public int updateSellPostStatus(int sellPostNumber) {
        return sqlSession.update("payment.updateSellPostStatus", sellPostNumber);
    }
    
    // 구매자에게 포인트 환불
    public int refundBuyerPoint(Map<String, Object> param) {
        return sqlSession.update("trade.refundBuyerPoint", param);
    }

    // 판매글 상태를 판매중으로 변경
    public int updateSellPostStatusAfterCancel(Map<String, Object> param) {
        return sqlSession.update("trade.updateSellPostStatusAfterCancel", param);
    }
    
    // 포인트 충전
    public int chargeMemberPoint(Map<String, Object> param) {
        return sqlSession.update("trade.chargeMemberPoint", param);
    }
}

