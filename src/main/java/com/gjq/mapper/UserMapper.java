package com.gjq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gjq.pojo.User;
/*
 * MybatisPlus提供了BaseMapper,
 * 在BaseMapper中提供了一系列基础的增删查改
 * 在实现具体的Mapper时可以在此基础上进行扩展。
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
	List<User> getUserList();
}
