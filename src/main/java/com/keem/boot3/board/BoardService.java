package com.keem.boot3.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.keem.boot3.util.FileManager;
import com.keem.boot3.util.Pager;

@Service
@Transactional(rollbackFor=Exception.class)
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private FileManager fileManager;
	
	
	public boolean setSummerFileDelete(String fileName) throws Exception{
		fileName=fileName.substring(fileName.lastIndexOf("/")+1);
		System.out.println(fileName);
		
		return fileManager.fileDelete(fileName,"resources/upload/board/");
	}
	
	public String setSummerFileUpload(MultipartFile files) throws Exception{
		//file HDD에 저장하고 저장된 파일명을 return
		
		String fileName=fileManager.fileSave(files, "resources/upload/board/");
		fileName="/resources/upload/board/"+fileName;
		
		return fileName;
	}

	public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception{
		return boardMapper.setFileDelete(boardFilesVO);
	}
	// getFileDetail
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception {
		return boardMapper.getFileDetail(boardFilesVO);
	}

	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = boardMapper.total(pager);
		pager.makeNum(totalCount);
		List<BoardVO> ar = boardMapper.getList(pager);

		return ar;
	}

	public int setAdd(BoardVO boardVO, MultipartFile[] files) throws Exception {
		System.out.println("Insert전 : " + boardVO.getNum());
		int result = boardMapper.setAdd(boardVO);
		System.out.println("Insert후 : " + boardVO.getNum());
		if (files != null) {
			for (MultipartFile mf : files) {
				if (mf.isEmpty()) {
					continue;
				}
				
				// File을 하드디스크에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/board/");
				System.out.println(fileName);
				// 저장된 정보를 DB에 저장
				BoardFilesVO boardFilesVO = new BoardFilesVO();
				boardFilesVO.setNum(boardVO.getNum());
				boardFilesVO.setFileName(fileName);
				boardFilesVO.setOriName(mf.getOriginalFilename());
				result=boardMapper.setFileAdd(boardFilesVO);
				if(result<1) {
					throw new SQLException();
				}
			}
		}
		return result;
	}

	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	}

	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}

	public int setDelete(BoardVO boardVO) throws Exception {
		return boardMapper.setDelete(boardVO);
	}

}
