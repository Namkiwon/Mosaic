package com.angointeam.Mosaic;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(value={"com.angointeam.Mosaic.Mapper"})
public class MosaicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MosaicApplication.class, args);
	}

	/*
	 * SqlSessionFactory 설정
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}


}
