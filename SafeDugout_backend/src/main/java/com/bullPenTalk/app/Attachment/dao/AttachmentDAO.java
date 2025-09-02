package com.bullPenTalk.app.Attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AttachmentDAO {

    private SqlSession sqlSession;

    public AttachmentDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // auto commit
    }

    // 조회
    // 게시글 첨부파일 조회
    public List<AttachmentDTO> selectByPost(int postNumber) {
        return sqlSession.selectList("attachment.selectAttachment", postNumber);
    }

    // 판매글 첨부파일 조회
    public List<AttachmentDTO> selectBySellPost(int sellPostNumber) {
        return sqlSession.selectList("attachment.selectAttachmentBySellPost", sellPostNumber);
    }

    // 공지사항 첨부파일 조회
    public List<AttachmentDTO> selectByNoticePost(int noticePostNumber) {
        return sqlSession.selectList("attachment.selectNoticeAttachment", noticePostNumber);
    }

    // 추가
    public void insert(AttachmentDTO attachmentDTO) {
        try {
            int result = sqlSession.insert("attachment.insertAttachment", attachmentDTO);
            System.out.println("AttachmentDAO - insert 완료: " + result);
            System.out.println("생성된 attachmentNumber: " + attachmentDTO.getAttachmentNumber());
        } catch (Exception e) {
            System.out.println("AttachmentDAO - insert 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void insertNoticeAttachment(AttachmentDTO attachmentDTO) {
    	try {
    		sqlSession.insert("attachment.insertNoticeAttachment", attachmentDTO);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // 글번호 가져오기
    public int getNoticePostNumber() {
    	return sqlSession.selectOne("attachment.getCurrentNoticeNumber");
    }
    
    public int getPostNumber() {
    	return sqlSession.selectOne("attachment.getCurrentPostNumber");
    }
    
    public int getTradeNumber() {
    	return sqlSession.selectOne("attachment.getCurrentTradeNumber");
    }

    // 삭제
    // 게시글 첨부파일 삭제
    public void deleteByPost(int postNumber) {
        sqlSession.delete("attachment.deletePost", postNumber);
    }

    // 판매글 첨부파일 삭제
    public void deleteBySellPost(int sellPostNumber) {
        sqlSession.delete("attachment.deleteSellPost", sellPostNumber);
    }

    // 공지사항 첨부파일 삭제
    public void deleteByNoticePost(int noticePostNumber) {
        sqlSession.delete("attachment.deleteNoticePost", noticePostNumber);
    }

    // 개별 파일 삭제
    public void deleteByAttachmentNumber(int attachmentNumber) {
        sqlSession.delete("attachment.deleteAttachment", attachmentNumber);
    }
}
