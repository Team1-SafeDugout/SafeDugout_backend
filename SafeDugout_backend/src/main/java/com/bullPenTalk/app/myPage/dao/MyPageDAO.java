package com.bullPenTalk.app.myPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.dto.MyPageCommentDTO;
import com.bullPenTalk.app.dto.MyPageTradeListDTO;
import com.bullPenTalk.app.dto.PointChargeRecordDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class MyPageDAO {
	public SqlSession sqlSession;

	public MyPageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 포인트 충전 내역 조회
	public List<PointChargeRecordDTO> selectPoint(Map<String, Integer> map) {
		return sqlSession.selectList("myPage.selectMainlist", map);
	}

	// 포인트 충전
	public void chargePoint(MemberDTO memberDTO) {
		sqlSession.update("myPage.chargePoint", memberDTO);
	}

	// 게시글 조회
	public List<PostDTO> selectPostList(Map<String, Integer> map) {
		return sqlSession.selectList("myPage.selectPostList", map);
	}

	// 게시글 삭제
	public void deletePost(int postNumber) {
		sqlSession.delete("myPage.deletePost", postNumber);
	}
	
	public int getTotalPost(int memberNumber) {
		return sqlSession.selectOne("myPage.getTotalPost", memberNumber);
	}

	// 댓글 조회
	public List<MyPageCommentDTO> selectCommentList(Map<String, Integer> map) {
		return sqlSession.selectList("myPage.selectCommentList", map);
	}
	
	// 댓글 전체 수
	public int getTotalComment(int memberNumber) {
		return sqlSession.selectOne("myPage.getTotalComment", memberNumber);
	}

	// 댓글 삭제
	public void deleteComment(int commentNumber) {
		sqlSession.delete("myPage.deleteComment", commentNumber);
	}

	// 구매 목록 조회
	public List<MyPageTradeListDTO> selectTradeList(Map<String, Integer> map) {
		return sqlSession.selectList("myPage.selectTradeList", map);
	}
	
	// 구매 하나 선택
	public MyPageTradeListDTO selectDetailTrade(int sellPostNumber) {
		return sqlSession.selectOne("myPage.selectDetailTrade", sellPostNumber);
	}
	
	// 구매 목록 전체
	public int getTotalTrade(int memberNumber) {
		return sqlSession.selectOne("myPage.getTotalTrade", memberNumber);
	}

	// 구매 확정
	public boolean completeTrade(int sellPostNumber) {
		SqlSession completeSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
		try {
			// 판매자에게 입금
			System.out.println("여기까지는 왔어영");
			/*if 문으로 판매자가 존재하는지 확인
			 * sellpost 에 있는 가격을 판매가자에게 입금
			 * */
			completeSession.update("myPage.givePoint", sellPostNumber);
			System.out.println("돈입금 성공");
			// sellPost 구매 완료 처리
			completeSession.update("myPage.completeSell",sellPostNumber);
			/* sellpost 를 구매 완료 status id = 3 으로 처리
			 * */
			System.out.println("sellpost 변경 완료");
			// tradePost 구매 완료 처리
			completeSession.update("myPage.completeTrade", sellPostNumber);
			/* tradepost 를 구매환료 처리 status id =3 으로 처리
			 * */
			System.out.println("tradepost 변경 성공");
			// Transaction 구매 완료 처리
			completeSession.update("myPage.completeTransaction", sellPostNumber);
			/* Transaction 를 구매환료 처리 TRANSACTION_STATUS =3 으로 처리
			 * */
			System.out.println("transaction 변경 성공");
			// 위 내용요 모두 완료 될 경우 commit
			completeSession.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("거래가 완전히 끝나지 않았습니다");
			completeSession.rollback();
			return false;
		}	
	}

	// 여기도 트랜잭션 처리해야 할듯
	public boolean cancleTrade(int sellPostNumber) {
		SqlSession cancleSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
		try {
			// 구매자에게 환불
			cancleSession.update("myPage.canclePoint", sellPostNumber);
			System.out.println("황불완료");
			
			// 셀포스트에 있는 status id 1 로변경
			cancleSession.update("myPage.cancleTradeUpdate", sellPostNumber);
			System.out.println("tbl sellpost 변경 완료");
			
			// trade post 에 있는 디비 삭제
			cancleSession.delete("myPage.cancleTradeDelete", sellPostNumber);
			System.out.println("tbl trade 삭제 완료");

			// tbl transactino 에 있는 값 삭제
			cancleSession.delete("myPage.cancleTradeSaction",sellPostNumber);
			System.out.println("tbl transaction 삭제 완료");
			

			
			// 모두 완료 되면 커밋
			cancleSession.commit();
			System.out.println("거래 취소 완료");
			return true;
			
		} catch(Exception e) {
			System.out.println("거래가 완전히 끝나지 않았습니다");
			cancleSession.rollback();
			return false;
		}
	}

	// 판매 목록 조회
	public List<MyPageTradeListDTO> selectSellList(Map<String, Integer> map) {
		return sqlSession.selectList("myPage.selectSellList", map);
	}

	// 판매글 삭제
	public void deleteSell(int sellPostNumber) {
		sqlSession.delete("myPage.deleteSell", sellPostNumber);
	}
	
	// 판매글 전체 수
	public int getTotalSell(int memberNumber) {
		return sqlSession.selectOne("myPage.getTotalSell", memberNumber);
	}

	// 회원 정보 수정
	public void updateMember(MemberDTO memberDTO) {
		sqlSession.update("myPage.updateMember", memberDTO);
	}

	// 회원 탈퇴
	public void quit(int memberNumber) {
		sqlSession.delete("myPage.quit", memberNumber);
	}
	
	// 회원 포인트 조회
	public int getMemberPoint(int memberNumber) {
		return sqlSession.selectOne("myPage.getMemberPoint", memberNumber); 
	}
}
