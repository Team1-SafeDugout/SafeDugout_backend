package com.bullPenTalk.app.Attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.SellPostAttachmentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class SellPostAttachmentDAO {

	public SqlSession sqlSession;

	public SellPostAttachmentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 판매글 파일 조회 메소드
	public List<AttachmentDTO> select(int sellPostNumber) {
		return sqlSession.selectList("attachment.selectSellPostAttachment", sellPostNumber);
	}

	// 파일 추가 메소드
	public void insert(SellPostAttachmentDTO sellPostAttachmentDTO) {
		System.out.println("파일 DAO - 파일 저장 " + sellPostAttachmentDTO);

		try {
			int result = sqlSession.insert("attachment.insertSellPost", sellPostAttachmentDTO);
			System.out.println("파일 저장 완료 - DB에 저장된 행의 개수 : " + result);

			// db에 파일이 제대로 저장되었는지 확인
			List<AttachmentDTO> uploadFile = select(sellPostAttachmentDTO.getSellPostNumber());
			System.out.println("db에서 자겨온 파일 : " + uploadFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("파일 저장이 실패되었습니다. : " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	// 파일 삭제 메소드
	public void delete(int boardNumber) {
		sqlSession.delete("attachment.deleteSellPost", boardNumber);
	}
}