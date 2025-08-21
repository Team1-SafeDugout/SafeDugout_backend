package com.bullPenTalk.app.dto;

public class BoardTypeDTO {
//	CREATE TABLE TBL_BOARD_TYPE(
//	BOARD_TYPE_ID NUMBER,
//	BOARD_TYPE_NAME VARCHAR2(50) NOT NULL,
//	CONSTRAINT PK_BOARD_TYPE PRIMARY KEY(BOARD_TYPE_ID)
//	);

	
	private int boardTypeId; // 게시판 종류 번호
	private String boardTypeName; // 게시판 종류 이름
	
	public int getBoardTypeId() {
		return boardTypeId;
	}
	public void setBoardTypeId(int boardTypeId) {
		this.boardTypeId = boardTypeId;
	}
	public String getBoardTypeName() {
		return boardTypeName;
	}
	public void setBoardTypeName(String boardTypeName) {
		this.boardTypeName = boardTypeName;
	}
	
	@Override
	public String toString() {
		return "BoardTypeDTO [boardTypeId=" + boardTypeId + ", boardTypeName=" + boardTypeName + "]";
	}
}
