package com.keem.boot3.product;

import com.keem.boot3.member.MemberFilesVO;
import com.keem.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductFilesVO extends FileVO{

	private Long productNum;
}
