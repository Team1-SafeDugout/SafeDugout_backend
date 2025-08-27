package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminMemberDAO {
	public SqlSession sqlSession;

	public AdminMemberDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 조회
	public MemberDTO select(int memberNumber) {
		return sqlSession.selectOne("member.select", memberNumber);
	}	
	
	public List<MemberDTO> listSelect(Map<String, Object> map){
		return sqlSession.selectList("member.listSelect",map);
	}
	
	public List<MemberDTO> selectAll(){
		return sqlSession.selectList("member.selectAll");
	}
	
	public int getTotal() {
		return sqlSession.selectOne("member.getTotal");
	}
	
	public PostDTO postSelect(int postNumber) {
		return sqlSession.selectOne("member.postSelect", postNumber);
	}
	
	public List<PostDTO> postListSelect(Map<String, Object> map){
		return sqlSession.selectList("member.postListSelect", map);
	}
	
	public List<SellPostDTO> sellPostListSelect(Map<String, Object> map){
		return sqlSession.selectList("member.sellPostListSelect", map);
	}
	
	public List<SellPostDTO> tradePostListSelect(Map<String, Object> map){
		return sqlSession.selectList("member.tradePostListSelect", map);
	}
}
