package com.bullPenTalk.app.myPage.dao;

import java.util.List;

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
	public PointChargeRecordDTO selectPoint(int memberNumber) {
		return sqlSession.selectOne("myPage.selectMainlist", memberNumber);
	}

	// 포인트 충전
	public void chargePoint(MemberDTO memberDTO) {
		sqlSession.update("myPage.chargePoint", memberDTO);
	}

	// 게시글 조회
	public List<PostDTO> selectPostList(int memberNumber) {
		return sqlSession.selectList("myPage.selectPostList", memberNumber);
	}

	// 게시글 삭제
	public void deletePost(int postNumber) {
		sqlSession.delete("myPage.deletePost", postNumber);
	}

	// 댓글 조회
	public List<MyPageCommentDTO> selectCommentList(int memberNumber) {
		return sqlSession.selectList("myPage.selectCommentList", memberNumber);
	}

	// 댓글 삭제
	public void deleteComment(int commentNumber) {
		sqlSession.delete("myPage.deleteComment", commentNumber);
	}

	// 구매 목록 조회
	public List<MyPageTradeListDTO> selectTradeList(int memberNumber) {
		return sqlSession.selectList("myPage.selectTradeList", memberNumber);
	}

	// 구매 확정
	public void completeTrade(int tradeNumber) {
		sqlSession.update("myPage.completeTrade", tradeNumber);
	}

	// 구매 취소(거래 상태 변경)
	public void cancelTradeUpdate(int sellPostNumber) {
		sqlSession.update("myPage.cancelTradeUpdate", sellPostNumber);
	}

	// 구매 취소(거래글 테이블에서 삭제)
	public void cancelTradeDelete(int tradeNumber) {
		sqlSession.delete("myPage.cancelTradeDelete", tradeNumber);
	}

	// 판매 목록 조회
	public List<MyPageTradeListDTO> selectSellList(int sellPostNumber) {
		return sqlSession.selectList("myPage.completeTrade", sellPostNumber);
	}

	// 판매글 삭제
	public void deleteSell(int sellPostNumber) {
		sqlSession.delete("myPage.deleteSell", sellPostNumber);
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
