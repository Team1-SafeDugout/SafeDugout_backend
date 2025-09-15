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
	public bool completeTrade(int tradeNumber, int sellPostNumber,int buyMember, int sellMember) {
		SqlSession completeSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
		try {
			// 판매자에게 입금
			
			/*if 문으로 판매자가 존재하는지 확인
			 * sellpost 에 있는 가격을 판매가자에게 입금
			 * */
			Map<String, Integer> pointCheckMapper;
			pointCheckMapper.put("memberNumber", sellMember);
			pointCheckMapper.put("sellPostNumber", sellPostNumber);
			completeSession.update("myPage.givePoint", pointCheckMapper);
			
			// sellPost 구매 완료 처리
			if()
			completeSession.update("myPage.completeSell",sellPostNumber);
			/* sellpost 를 구매 완료 status id = 3 으로 처리
			 * */
			
			// tradePost 구매 완료 처리
			completeSession.update("myPage.completeTrade", tradeNumber);
			/* tradepost 를 구매환료 처리 status id =3 으로 처리
			 * */
			
			// 위 내용요 모두 완료 될 경우 commit
			completeSession.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			completeSession.rollback();
			return false;
		}	
	}

	// 구매 취소(거래 상태 변경)
	public void cancelTradeUpdate(int sellPostNumber) {
		sqlSession.update("myPage.cancelTradeUpdate", sellPostNumber);
	}

	// 구매 취소(거래글 테이블에서 삭제)
	public void cancelTradeDelete(int sellPostNumber) {
		sqlSession.delete("myPage.cancelTradeDelete", sellPostNumber);
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
}
