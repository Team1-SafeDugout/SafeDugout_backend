package com.bullPenTalk.app.dto;

public class BoardDTO {
//	CREATE TABLE TBL_BOARD(
//	BOARD_NUMBER NUMBER,
//	BOARD_ID NUMBER,
//	CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_NUMBER),
//	CONSTRAINT FK_BOARD FOREIGN KEY(BOARD_ID) REFERENCES TBL_BOARD_TYPE(BOARD_TYPE_ID)
//	);

	
	private int boardNumber; 
	private int boardId;
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardNumber=" + boardNumber + ", boardId=" + boardId + "]";
	}

}
