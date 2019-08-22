package com.gjq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gjq.mapper.UserMapper;
import com.gjq.pojo.User;

@Controller
@ResponseBody
public class UserController {
	@Autowired
	private UserMapper userMapper;
	 @GetMapping("getUserList")
	    public List<User> getUserList(){
	        return userMapper.getUserList();
	    }

	    //http://localhost:8888/getUserListByName?userName=xiaoli
	    //条件查询
	    @GetMapping("getUserListByName")
	    public List<User> getUserListByName(String userName)
	    {
	        Map map = new HashMap();
	        map.put("user_name", userName);
	        return userMapper.selectByMap(map);
	    }

	    //http://localhost:8888/saveUser?userName=xiaoli&userPassword=111
	    //保存用户
	    @GetMapping("saveUser")
	    public String saveUser(String userName,String userPassword)
	    {
	        User user = new User(userName,userPassword);
	        Integer index = userMapper.insert(user);
	        if(index>0){
	            return "新增用户成功。";
	        }else{
	            return "新增用户失败。";
	        }
	    }

	    //http://localhost:8888/updateUser?id=5&userName=xiaoli&userPassword=111
	    //修改用户
	    @GetMapping("updateUser")
	    public String updateUser(Integer id,String userName,String userPassword)
	    {
	        User user = new User(id,userName,userPassword);
	        Integer index = userMapper.updateById(user);
	        if(index>0){
	            return "修改用户成功，影响行数"+index+"行。";
	        }else{
	            return "修改用户失败，影响行数"+index+"行。";
	        }
	    }


	    //http://localhost:8888/getUserById?userId=1
	    //根据Id查询User
	    @GetMapping("getUserById")
	    public User getUserById(Integer userId)
	    {
	        return userMapper.selectById(userId);
	    }

	    //http://localhost:8888/getUserListByPage?pageNumber=1&pageSize=2
	    //条件分页查询
	    /*
	     * 在MybatisPlus中，提供了分页查询的方法，
	     * 即查询得到Page<T>类型，简化了分页查询的操作。
	     */
	    @GetMapping("getUserListByPage")
	    public List<User> getUserListByPage(Integer pageNumber,Integer pageSize)
	    {
	        Page<User> page =new Page<>(pageNumber,pageSize);
	        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
	        entityWrapper.eq("user_name", "xiaoli");
	        return userMapper.selectPage(page,entityWrapper);
	    }

}
