package com.work.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

// 세션 만들어놓고 가져다 쓴다
/* SqlSessionFactory 객체를 하나만 만들어서 계속 재사용
* --> Singleton 패턴
* */

public class Template {
  private static SqlSessionFactory sqlSessionFactory;

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/menudb";
  private static final String USERNAME = "swcamp";
  private static final String PASSWORD = "swcamp";

  public static SqlSession getSqlSession() {

    if(sqlSessionFactory == null) {
      try {
        // 1. 환경설정 객체 만들기
        Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD));
        Configuration configuration = new Configuration(environment);

        //2. 매퍼 등록
        configuration.addMapper(MenuMapper.class);

        //3. SqlSessionFactoryBuilder
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return sqlSessionFactory.openSession(false);
  }



}
