package com.bullPenTalk.app.payment.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.PointPaymentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class PaymentDAO {
	public SqlSession sqlSession;
	
	public PaymentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
	}
	
    // 결제 트랜잭션 처리
    public boolean processPayment(Map<String, Object> param, int sellPostNumber) {
        try {
            int buyer = decreaseBuyerPoint(param);
            int seller = increaseSellerPoint(param);
            int trade = insertTradePost(param);
            int updateStatus = updateSellPostStatus(sellPostNumber);

            System.out.println("buyer update = " + buyer);
            System.out.println("seller update = " + seller);
            System.out.println("trade insert = " + trade);
            System.out.println("status update = " + updateStatus);

            // 모두 성공해야 commit
            if(buyer > 0 && seller > 0 && trade > 0 && updateStatus > 0) {
            	System.out.println("성공 커밋");
                sqlSession.commit();
                return true;
            } else {
            	System.out.println("실패 롤백");
                sqlSession.rollback();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
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
        return sqlSession.update("payment.refundBuyerPoint", param);
    }

    // 판매글 상태를 판매중으로 변경
    public int updateSellPostStatusAfterCancel(Map<String, Object> param) {
        return sqlSession.update("payment.updateSellPostStatusAfterCancel", param);
    }
    
    // 포인트 충전
    public int chargeMemberPoint(Map<String, Object> param) {
        return sqlSession.update("payment.chargeMemberPoint", param);
    }
    
    // 결제 기록 저장 
    public int insertPointPayment(PointPaymentDTO payment) {
        return sqlSession.insert("payment.insertPayment", payment);
    }
    
}

