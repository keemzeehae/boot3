package com.keem.boot3.board;

import com.keem.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BoardFilesVO extends FileVO {


	private Long num;
}
