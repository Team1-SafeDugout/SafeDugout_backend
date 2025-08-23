package com.bullPenTalk.app.teamCommunity.dao;

	import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.TeamBatterRecordDTO;
import com.bullPenTalk.app.dto.TeamPitcherRecordDTO;
import com.bullPenTalk.app.dto.TeamRecordDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

	    public class TeamPostDTO() {
	    	public SqlSession sqlSession;

	    	public TeamPostDTO() {
	    		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    	}

	    	// 모든 게시글 가져오기
	    	public List<TeamPostDTO> select(Map<String, Integer> pageMap) {
	    		System.out.println("팀 게시글 조회하기 - select 메소드 실행 : " + pageMap);
	    		List<TeamPostDTO> list = sqlSession.selectList("TeamCommunityMapper.select", pageMap);
	    		System.out.println("조회결과 : " + list);
	    		return list;
	    	}

	    	// 게시글 총 개수 가져오기
	    	public int getTotal() {
	    		System.out.println("팀 게시글 총 개수 조회 - getTotal 메소드 실행");
	    		return sqlSession.selectOne("TeamCommunityMapper.getTotal");
	    	}

			/*
			 * // 게시글 추가 후 자동으로 생성된 boardNumber 반환 -> 파일 테이블에서도 써야하기 때문에 public int
			 * insertPost(TeamPostDTO teamPostDTO) { int insert =
			 * sqlSession.insert("TeamCommunityMapper.insert", TeamPostDTO);
			 * System.out.println(TeamPostDTO + "출력");
			 * System.out.println(TeamPostDTO.getPostContent() + "출력 === ");
			 * System.out.println("게시글 작성 - insertPost 메소드 실행 ");
			 * System.out.println("insert 결과 : " + insert);
			 * System.out.println("생성된 PostNumber : " + TeamPostDTO.getPostNumber()); return
			 * TeamPostDTO.getPostNumber(); }
			 */

	    	// 게시글 삭제 메소드
	    	public void delete(int PostNumber) {
	    		System.out.println("게시글 삭제 실행 : " + PostNumber);
	    		sqlSession.delete("TeamCommunityMapper.delete", PostNumber);
	    		System.out.println("게시글 삭제 쿼리 실행 완료");
	    	}

	    	// 게시글 수정 메소드
	    	public void update(TeamPostDTO teamPostDTO) {
	    		sqlSession.update("TeamCommunityMapper.update", TeamPostDTO);
	    	}

	    	// 게시글 상세 페이지 조회 메소드
	    	public TeamPostDTO detailselect(int PostNumber) {
	    		System.out.println("게시글 상세 페이지 조회(단건조회)");
	    		return sqlSession.selectOne("TeamCommunityMapper.detailselect", PostNumber);
	    	}

	    	// 팀 유튜브 목록 조회 메소드
	    	public YoutubePostDTO youtubeSelect(YoutubePostDTO youtubePostDTO) {
	    	System.out.println("팀 유튜브 목록 조회하기 - youtubeSelect 메소드 실행");
	    	return sqlSession.youtubeSelect("TeamCommunityMapper.youtubeSelect");
    		}
	    	
	    	
	    	// 팀 응원가 / 선수 응원가 목록 조회 메소드
		    public SongPostDTO songSelect(SongPostDTO songPostDTO) {
	    	System.out.println("응원가 목록 조회하기 - songSelect 메소드 실행");
	    	return sqlSession.songSelect("TeamCommunityMapper.songSelect");
			}
		    	
	    	// 팀 뉴스 목록 조회 메소드
		    public NewsPostDTO newsSelect(NewsPostDTO newsPostDTO) {
		    System.out.println("팀 뉴스 목록 조회하기 - newsSelect 메소드 실행");
		    return sqlSession.newsSelect("TeamCommunityMapper.newsSelect");
			}
		    
	    	
	    	// 팀 기록 조회 메소드
		    public TeamRecordDTO teamRecordSelect(TeamRecordDTO teamRecordDTO) {
			System.out.println("팀 기록 조회하기 - teamRecordSelect 메소드 실행");
			return sqlSession.teamRecordSelect("TeamCommunityMapper.teamRecordSelect");
		    }
		   
	    	
	    	// 선수(투수) 기록 조회 메소드
		    public TeamPitcherRecordDTO PitcherRecordSelect(TeamPitcherRecordDTO teamPitcherRecordDTO) {
			System.out.println("투수 기록 조회하기 - PitcherRecordSelect 메소드 실행");
			return sqlSession.PitcherRecordSelect("TeamCommunityMapper.PitcherRecordSelect");
			}
			   
	    	// 선수(포수) 기록 조회 메소드
		    public TeamBatterRecordDTO BatterRecordSelect(TeamBatterRecordDTO teamBatterRecordDTO) {
			System.out.println("투수 기록 조회하기 - BatterRecordSelect 메소드 실행");
			return sqlSession.BatterRecordSelect("TeamCommunityMapper.BatterRecordSelect");
		    }
}