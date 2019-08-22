package com.gjq.config;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*Mybatis-Plus在Mybatis的基础上进行扩展，只做增强不做改变
 * 引入Mybatis-Plus不会对您现有的Mybatis架构产生影响。它支持所有Mybatis原生的特性
 * 
 * 
 */
@Configuration
public class MybatisPlusConfig {
	  @Bean
	  public PaginationInterceptor paginationInterceptor(){
		  PaginationInterceptor page = new PaginationInterceptor();
		  //设置方言
		  page.setDialectType("mysql");
		  return page;
		  
	  }

}
