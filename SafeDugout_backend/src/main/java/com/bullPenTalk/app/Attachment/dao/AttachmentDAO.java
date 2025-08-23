package com.bullPenTalk.app.Attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AttachmentDAO {
	
	
	public SqlSession sqlSession;
	
	public AttachmentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//  파일 조회 메소드
	public List<AttachmentDTO> select(int PostNumber) {
		return sqlSession.selectList("attachment.selectAttachment", PostNumber);
	}
	
	// 파일 추가 메소드
	public void insert(AttachmentDTO AttachmentDTO) {
		System.out.println("파일 DAO - 파일 저장 " + AttachmentDTO);

		try {
			int result = sqlSession.insert("attachment.insert", AttachmentDTO);
			System.out.println("파일 저장 완료 - DB에 저장된 행의 개수 : " + result);

			// db에 파일이 제대로 저장되었는지 확인
			List<AttachmentDTO> uploadFile = select(AttachmentDTO.getAttachmentNumber());
			System.out.println("db에서 자겨온 파일 : " + uploadFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("파일 저장이 실패되었습니다. : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	// 파일 삭제 메소드
	public void delete(int boardNumber) {
		sqlSession.delete("attachment.delete", boardNumber);
	}


}
