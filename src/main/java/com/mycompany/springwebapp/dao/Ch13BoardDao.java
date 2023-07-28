package com.mycompany.springwebapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springwebapp.dto.Ch13Board;

@Mapper
public interface Ch13BoardDao {
	public int insert(Ch13Board board);
	public List<Ch13Board> selectAll();
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
}
