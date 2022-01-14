package com.icia.dabyinsa.admin.dao;

import java.util.List;

import com.icia.dabyinsa.admin.dto.product.productlistDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductSearchDao {

    //상품 목록 검색 기능
    List<productlistDto> getPLList(String plkeyword, String plkeyword2, String plsearchOption, String plsearchOption2);
	int getPLListCount(String plkeyword, String plkeyword2, String plsearchOption, String plsearchOption2);
    
}
