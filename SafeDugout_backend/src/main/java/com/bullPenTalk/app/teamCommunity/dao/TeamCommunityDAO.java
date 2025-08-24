package com.bullPenTalk.app.teamCommunity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.BatterRecordDTO;
import com.bullPenTalk.app.dto.DeffenseBaseRecordDTO;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.TeamBatterRecordDTO;
import com.bullPenTalk.app.dto.TeamPitcherRecordDTO;
import com.bullPenTalk.app.dto.TeamRecordDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class TeamCommunityDAO {
	
	public SqlSession sqlSession;
	
	public TeamCommunityDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 게시판 목록 가져오기
	public List<PostDTO> selectBoard(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<PostDTO> list = sqlSession.selectList("TeamCommunityMapper.select", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
	// 뉴스 목록 가져오기
	public List<NewsPostDTO> selectNews(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<NewsPostDTO> list = sqlSession.selectList("TeamCommunityMapper.newsSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 유튜브 목록 가져오기
	public List<YoutubePostDTO> selectYoutube(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<YoutubePostDTO> list = sqlSession.selectList("TeamCommunityMapper.youtubeSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
	// 응원가 목록 조회
	public List<SongPostDTO> selectSong(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<SongPostDTO> list = sqlSession.selectList("TeamCommunityMapper.songSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 팀 응원가 목록 조회
	public List<SongPostDTO> selectTeamSong(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<SongPostDTO> list = sqlSession.selectList("TeamCommunityMapper.TeamSongSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 선수 응원가 목록 조회
	public List<SongPostDTO> selectPlayerSong(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<SongPostDTO> list = sqlSession.selectList("TeamCommunityMapper.playerSongSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 시즌 기록 조회
	public List<TeamRecordDTO> selectTeamRecord(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<TeamRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.teamRecordSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 투수 기록 조회
	public List<TeamPitcherRecordDTO> selectTeamPitcherRecord(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<TeamPitcherRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.pitcherRecordSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 타자 기록 조회
	public List<TeamBatterRecordDTO> selectTeamBatterRecord(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<TeamBatterRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.batterRecordSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 수비/주루 기록
	public List<DeffenseBaseRecordDTO> selectTeamDeffenseRecord(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<DeffenseBaseRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.batterRecordSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 투수 기록 조회
	public List<DeffenseBaseRecordDTO> selectPlayerPitcher(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<DeffenseBaseRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.playerPitcherRecord", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 타자 기록 조회
	public List<BatterRecordDTO> selectPlayerBatter(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<BatterRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.playerBatterRecord", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
}
