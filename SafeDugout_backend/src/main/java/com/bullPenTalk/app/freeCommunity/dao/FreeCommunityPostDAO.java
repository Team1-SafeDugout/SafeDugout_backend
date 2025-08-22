package com.bullPenTalk.app.freeCommunity.dao;

import java.util.List;
import java.util.Map;

import com.bullPenTalk.app.dto.BoardDTO;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class FreeCommunityPostDAO {
			public SqlSession sqlSession;

	    public FreeCommunityPostDAO() {
	    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    }

	 // 모든 게시글 가져오기
		public List<FreePostDTO> selectAll(Map<String, Integer> pageMap) {
			System.out.println("모든 게시글 조회하기 - selectAll 메소드 실행 : " + pageMap);
			List<FreePostDTO> list = sqlSession.selectList("board.selectAll", pageMap);
			System.out.println("조회결과 : " + list);
			return list;
		}
	    
		// 게시글 총 개수 가져오기
		public int getTotal() {
			System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
			return sqlSession.selectOne("board.getTotal");
		}
			
		// 게시글 추가 후 자동으로 생성된 boardNumber 반환 -> 파일 테이블에서도 써야하기 때문에
		public int insertBoard(FreePostDTO freePostDTO) {
			int insert = sqlSession.insert("board.insert", FreePostDTO);
			System.out.println(FreePostDTO + "출력");
			System.out.println(FreePostDTO.getBoardContent() + "출력 === ");
			System.out.println("게시글 작성 - insertBoard 메소드 실행 ");
			System.out.println("insert 결과 : " + insert);
			System.out.println("생성된 boardNumber : " + FreePostDTO.getBoardNumber());
			return FreePostDTO.getBoardNumber();
		}

		// 게시글 삭제 메소드
		public void delete(int postNumber) {
			System.out.println("게시글 삭제 실행 : " + postNumber);
			sqlSession.delete("FreeCommunityPostMapper.delete", postNumber);
			System.out.println("게시글 삭제 쿼리 실행 완료");
		}

		// 게시글 수정 메소드
		public void update(FreePostDTO freePostDTO) {
			sqlSession.update("FreeCommunityPostMapper.update", FreePostDTO);
		}

		// 게시글 상세 페이지 조회 메소드
		public FreePostDTO select(int boardNumber) {
			System.out.println("게시글 상세 페이지 조회(단건조회)");
			return sqlSession.selectOne("FreeCommunityPostMapper.select", boardNumber);
		}



	   
	    
	

}
