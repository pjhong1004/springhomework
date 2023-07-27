package com.mycompany.springhomework.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.springhomework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch13BoardDaoOld {
	@Resource
	private SqlSessionTemplate sst;
	
	public void insert(Ch13Board board) {
		
		sst.insert("com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.insert", board);		
	}
	
	public List<Ch13Board> select() {
		List<Ch13Board> list = sst.selectList("com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.select");
		for(Ch13Board board : list) {
			log.info(board.toString());
		}
		return list;
	}
	
	public void updateBno() {
		List<Ch13Board> list = select();
		Ch13Board board = list.get(0);
		board.setBtitle("스프링");
		board.setBcontent("공부 더 하고싶다");
		sst.update("com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.updateBno", board);

	}
	
	public void deleteByBno() {
		int bno = 1;
		sst.delete("com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.deleteByBno", bno);
	}
	

}
