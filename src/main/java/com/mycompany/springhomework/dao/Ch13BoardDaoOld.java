package com.mycompany.springhomework.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.springhomework.dto.Ch13Board;
import com.mycompany.springhomework.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

public interface Ch13BoardDaoOld {

	public int insert(Ch13Board board);
	public List<Ch13Board> selectByPage(Ch13Pager pager);
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
	public int count();
}



