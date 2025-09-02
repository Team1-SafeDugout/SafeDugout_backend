package com.bullPenTalk.app.sellPost.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class SellPostDAO {
	
	public SqlSession sqlSession;
	
	public SellPostDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
		
	
	// 모든 판매글 가져오기
	public List<SellPostDTO> selectList(Map<String, Object> pageMap) {
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<SellPostDTO> list = sqlSession.selectList("sell.selectList", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 특정 팀 카테고리 가져오기
	public List<SellPostDTO> selectListTeam(Map<String, Object> pageMap) {
		System.out.println("모든 게시글 조회하기 - selectListTeam 메소드 실행 : " + pageMap);
		List<SellPostDTO> list = sqlSession.selectList("sell.selectListTeam", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 특정 팀의 상품 카테고리 가져오기
	public List<SellPostDTO> selectListTeamCategory(Map<String, Object> pageMap) {
		System.out.println("모든 게시글 조회하기 - selectListTeam 메소드 실행 : " + pageMap);
		List<SellPostDTO> list = sqlSession.selectList("sell.selectListTeamCategory", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
		
	
	// 특정 카테고리 가져오기
	public List<SellPostDTO> selectListCategory(Map<String, Object> pageMap) {
		System.out.println("모든 게시글 조회하기 - selectListCategory 메소드 실행 : " + pageMap);
		List<SellPostDTO> list = sqlSession.selectList("sell.selectListCategory", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
	// 판매글 총 개수 가져오기
	public int getTotal() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("sell.getTotal");
	}
	
	// 판매글 추가 후 자동으로 생성된 getSellPostNumber 반환 -> 파일 테이블에서도 써야하기 때문에
	public int insertSellPost(SellPostDTO sellPostDTO) {
		System.out.println("게시글 작성 - insertSellPost 메소드 실행 ");
		int insert = sqlSession.insert("sell.insert", sellPostDTO);
		System.out.println(sellPostDTO + "출력");
		System.out.println(sellPostDTO.getSellPostContent() + "출력 === ");
		System.out.println("insert 결과 : " + insert);
		System.out.println("생성된 SellPostNumber : " + sellPostDTO.getSellPostNumber());
		return sellPostDTO.getSellPostNumber();
	}
	
	// 판매글 삭제 메소드
	public void delete(int SellPostNumber) {
		System.out.println("게시글 삭제 실행 : " + SellPostNumber);
		sqlSession.delete("sell.delete", SellPostNumber);
		System.out.println("게시글 삭제 쿼리 실행 완료");
	}
	
	// 판매글 수정 메소드
	public void update(SellPostDTO sellPostDTO) {
		sqlSession.update("sell.update", sellPostDTO);
	}
	
	
	// 판매글 상세 페이지 조회 메소드
	public SellPostDetailDTO selectDetail(int sellPostNumber) {
		System.out.println("게시글 상세 페이지 조회(단건조회)");
		return sqlSession.selectOne("sell.selectDetail", sellPostNumber);
	}
	
	// 검색 메소드
	public List<SellPostDTO> searchList(Map<String, Object> pageMap) {
	    return sqlSession.selectList("trade.searchList", pageMap);
	}
	
	// 검색 결과 개수
	public int getTotalSearch(String searchWord) {
	    return sqlSession.selectOne("trade.getTotalSearch", searchWord);
	}
}
