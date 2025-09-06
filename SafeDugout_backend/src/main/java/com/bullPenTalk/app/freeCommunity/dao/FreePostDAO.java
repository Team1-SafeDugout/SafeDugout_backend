package com.bullPenTalk.app.freeCommunity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class FreePostDAO {
    private SqlSession sqlSession;

    public FreePostDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 게시글 목록 조회
    public List<FreePostDTO> selectList(Map<String, Integer> pageMap) {
        System.out.println("전체 커뮤니티 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
        List<FreePostDTO> list = sqlSession.selectList("freeCommunity.selectList", pageMap);
        System.out.println("조회결과 : " + list);
        return list;
    }

    // 게시글 총 개수
    public int getTotal() {
        System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
        return sqlSession.selectOne("freeCommunity.getTotal");
    }

    public int insert(FreePostDTO dto) {
        sqlSession.insert("freeCommunity.insert", dto);
        // selectKey로 DTO에 채워진 PK를 반환
        return dto.getPostNumber();
    }
    
    // 게시글 삭제
    public void delete(int postNumber) {
        System.out.println("게시글 삭제 실행 : " + postNumber);
        sqlSession.delete("freeCommunity.deletePost", postNumber);
        System.out.println("게시글 삭제 쿼리 실행 완료");
    }

    // 게시글 수정
    public void update(FreePostDTO freePostDTO) {
        sqlSession.update("freeCommunity.updatePost", freePostDTO);
        System.out.println("게시글 수정 완료: " + freePostDTO);
    }

    // 게시글 상세 조회
    public FreePostDTO selectDetail(int postNumber) {
        System.out.println("게시글 상세 페이지 조회(단건조회): " + postNumber);
        return sqlSession.selectOne("freeCommunity.selectPostDetail", postNumber);
    }
    
    // 게시글 작성자 번호 조회
    public int getWriterNumber(int postNumber) {
        System.out.println("게시글 작성자 번호 조회 - postNumber: " + postNumber);
        Integer writerNumber = sqlSession.selectOne("freeCommunity.getWriterNumber", postNumber);

        if (writerNumber == null) {
            System.out.println("해당 게시글이 존재하지 않습니다. postNumber: " + postNumber);
            return -1; // 없는 게시글일 경우 -1 반환
        }

        return writerNumber;
    }
    
    // 게시글 작성자 id조회
    public MemberDTO getMemberById(String memberId) {
        return sqlSession.selectOne("member.getMemberById", memberId);
    }
    
    // 메인페이지 조회
    public List<FreePostDTO> selectLatestPosts(int count) {
        return sqlSession.selectList("FreeCommunityPostMapper.selectLatestPosts", count);
    }
}
