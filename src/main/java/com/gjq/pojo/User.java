package com.gjq.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
/*
 * MybatisPlus提供了实体类与表对应的机制。
 * @TableName可以将此实体类与数据库中表进行对应
 * @TableId使的某一个属性与表中某一字段对应
 * @TableField可以用来说明这个属性是否在表中存在对应的字段
 * @TableField(exist=false)表示对应属性在表中不存在
 */
public class User {
	/*
	 * 在实体类中，不对主键字段添加@TableId("数据库字段名称")注解
	 * 在调用涉及id的自带方法时就出现Invalid bound statement的错误
	 * 估计mybatis_plus无法识别主键
	 */
	@TableId("id")//数据库主键名称

	private int id;
    private String user_name;
    private String user_password;
	public User() {
		super();
	}
	public User( String user_name, String user_password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
	}
	
	public User(int id, String user_name, String user_password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_password=" + user_password + "]";
	}
    
}
