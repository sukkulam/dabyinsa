package com.icia.dabyinsa.user.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.dabyinsa.user.dto.CartDto;

@Repository
public class CartDaoImpl implements CartDao {

	//@Inject
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<CartDto> cart_money() {
		return sqlSession.selectList("cart.cart_money");
	}

	@Override
	public void insert(CartDto dto) {
		sqlSession.insert("cart.insert", dto);

	}

	@Override
	public List<CartDto> list(String m_id) {
		return sqlSession.selectList("cart.list", m_id);
	}

	@Override
	public void delete(int c_id) {
		sqlSession.delete("cart.delete", c_id);
	}

	@Override
	public void delete_all(String m_id) {
		sqlSession.delete("cart.delete_all", m_id);
	}

	@Override
	public int sum_money(String m_id) {
		return sqlSession.selectOne("cart.sum_money", m_id);
	}

	@Override
	public void modify(CartDto dto) {
		sqlSession.update("cart.modify", dto);
	}

}
