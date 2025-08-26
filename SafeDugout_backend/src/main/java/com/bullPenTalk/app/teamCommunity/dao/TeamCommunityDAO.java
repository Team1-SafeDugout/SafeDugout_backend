package com.bullPenTalk.app.teamCommunity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.BatterRecordDTO;
import com.bullPenTalk.app.dto.DeffenseBaseRecordDTO;
import com.bullPenTalk.app.dto.GameScheduleDTO;
import com.bullPenTalk.app.dto.NewsDetailDTO;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.PitcherRecordDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.dto.PostDetailDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.StadiumDTO;
import com.bullPenTalk.app.dto.StadiumFoodDTO;
import com.bullPenTalk.app.dto.StadiumTicketDTO;
import com.bullPenTalk.app.dto.TeamBatterRecordDTO;
import com.bullPenTalk.app.dto.TeamNoticeDetailDTO;
import com.bullPenTalk.app.dto.TeamNoticePostDTO;
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
	
	// 게시글 상세 페이지
	public PostDetailDTO postDetail(int PostNumber) {
		System.out.println("게시글 상세 페이지 조회(단건조회)");
		return sqlSession.selectOne("TeamCommunityMapper.detailSelect", PostNumber);
	}
	
	
	// 공지 목록 가져오기
	public List<TeamNoticePostDTO> selectNotice(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<TeamNoticePostDTO> list = sqlSession.selectList("TeamCommunityNoticeMapper.select", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 공지목록 상세페이지
	public TeamNoticeDetailDTO teamNoticeDetail(int PostNumber) {
		System.out.println("게시글 상세 페이지 조회(단건조회)");
		return sqlSession.selectOne("TeamCommunityNoticeMapper.detailSelect", PostNumber);
	}
	
	// 뉴스 목록 가져오기
	public List<NewsPostDTO> selectNews(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<NewsPostDTO> list = sqlSession.selectList("TeamCommunityMapper.newsSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
	// 뉴스 상세페이지 가져오기
	public NewsDetailDTO teamNewsDetail(int PostNumber) {
		System.out.println("게시글 상세 페이지 조회(단건조회)");
		return sqlSession.selectOne("TeamCommunityMapper.detailNewsSelect", PostNumber);
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
	
	// 선수 응원가 목록 조회 --
	public List<SongPostDTO> selectPlayerSong(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<SongPostDTO> list = sqlSession.selectList("TeamCommunityMapper.playerSongSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 시즌 기록 조회
    public List<TeamRecordDTO> selectTeamRecord(Map<String, Integer> param){
        System.out.println("DAO: 팀 기록 조회 - selectTeamRecord 실행, param: " + param);
        List<TeamRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.teamRecordSelect", param);
        System.out.println("조회결과: " + list);
        return list;
    }
    
	// 팀 투수 기록 조회
	public List<TeamPitcherRecordDTO> selectTeamPitcherRecord(Map<String, Integer> param){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + param);
		List<TeamPitcherRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.pitcherRecordSelect", param);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 타자 기록 조회
	public List<TeamBatterRecordDTO> selectTeamBatterRecord(Map<String, Integer> param){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + param);
		List<TeamBatterRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.batterRecordSelect", param);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 팀 수비/주루 기록
	public List<DeffenseBaseRecordDTO> selectTeamDeffenseRecord(Map<String, Integer> param){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + param);
		List<DeffenseBaseRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.deffenseBaseRecord", param);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 투수 기록 조회
	public List<PitcherRecordDTO> selectPlayerPitcher(Map<String, Integer> param){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + param);
		List<PitcherRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.playerPitcherRecord", param);
		System.out.println("조회결과 : " + list);
		return list;
	}	
	
	// 타자 기록 조회
	public List<BatterRecordDTO> selectPlayerBatter(Map<String, Integer> param){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + param);
		List<BatterRecordDTO> list = sqlSession.selectList("TeamCommunityMapper.playerBatterRecord", param);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
	// 게시글 등록
	public int insertPost(PostDTO postDTO) {
		System.out.println("게시글 작성 - insertSellPost 메소드 실행 ");
		int insert = sqlSession.insert("TeamCommunityMapper.insert", postDTO);
		System.out.println(postDTO + "출력");
		System.out.println(postDTO.getPostContent() + "출력 === ");
		System.out.println("insert 결과 : " + insert);
		System.out.println("생성된 SellPostNumber : " + postDTO.getPostNumber());
		return postDTO.getPostNumber();
	}
	
	// 게시글 수정
	public void update(PostDTO PostDTO) {
		sqlSession.update("TeamCommunityMapper.update", PostDTO);
	}
	
	// 게시글 삭제
	public void delete(int PostNumber) {
		System.out.println("게시글 삭제 실행 : " + PostNumber);
		sqlSession.delete("TeamCommunityMapper.delete", PostNumber);
		System.out.println("게시글 삭제 쿼리 실행 완료");
	}
	
	// 게시글 총 개수 가져오기
	public int getTotalBoard() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotal");
	}
	
	// 뉴스글 총 개수 가져오기
	public int getTotalNews() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotalNews");
	}
	
	// 유튜브 총 개수 가져오기
	public int getTotalYoutube() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotalYoutube");
	}
	
	// 응원가 총 개수 가져오기
	public int getTotalSong() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotalSong");
	}
	
	// 팀 응원가 총 개수 가져오기
	public int getTotalTeamSong() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotalTeamSong");
	}
	
	// 응원가 총 개수 가져오기
	public int getTotalPlayerSong() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("TeamCommunityMapper.getTotalPlayerSong");
	}
	
    // 팀 번호로 경기장 정보 조회
    public StadiumDTO selectStadium(int teamNumber) {
        System.out.println("DAO: selectStadium 실행 - teamNumber : " + teamNumber);
        StadiumDTO stadium = sqlSession.selectOne("TeamCommunityMapper.selectStadium", teamNumber);
        System.out.println("조회 결과: " + stadium);
        return stadium;
    }

    // 경기장 번호로 티켓 정보 조회
    public List<StadiumTicketDTO> selectTicket(int stadiumNumber) {
        System.out.println("DAO: selectTicket 실행 - stadiumNumber : " + stadiumNumber);
        List<StadiumTicketDTO> tickets = sqlSession.selectList("TeamCommunityMapper.selectTicket", stadiumNumber);
        System.out.println("조회 결과: " + tickets);
        return tickets;
    }

    // 경기장 번호로 먹거리 정보 조회
    public List<StadiumFoodDTO> selectFood(int stadiumNumber) {
        System.out.println("DAO: selectFood 실행 - stadiumNumber : " + stadiumNumber);
        List<StadiumFoodDTO> foods = sqlSession.selectList("TeamCommunityMapper.selectFood", stadiumNumber);
        System.out.println("조회 결과: " + foods);
        return foods;
    }
	
	// 경기 일정 조회
	public List<GameScheduleDTO> selectGame(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
		List<GameScheduleDTO> list = sqlSession.selectList("TeamCommunityMapper.selectGame", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
}
