package com.work.section03.remix;

import com.work.section01.xmlconfig.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.work.section03.remix.Template.getSqlSession;

/* Service 계층
* - 비즈니스 로직 처리 계층
* - 비즈니스 로직은  데이터 가공 또는 DAO(DB CRUD) 호출, 트랜잭션 관리*/
public class MenuService {



  /***
   * 전체 메뉴 조회
   * @return menuList
   */
  public List<MenuDTO> selectAllMenu() {
    // 1. SqlSession 얻어오기
    SqlSession sqlSession = getSqlSession();
    // 2. SQL 수행 후 결과 반환 받기
    MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
    List<MenuDTO> menuList = mapper.selectAllMenu();

    // 3. SqlSession 메모리 반환
    sqlSession.close();

    //4. 결과 반환
    return menuList;
  }

  /***
   * 메뉴 코드가 일치하는 메뉴 조회
   * @param menuCode
   * @return menu
   */
  public MenuDTO selectMenuByMenuCode(int menuCode) {
    SqlSession sqlSession = null;
    MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
    sqlSession = Template.getSqlSession();
    MenuDTO menu = mapper.selectMenuByMenuCode(menuCode);
    sqlSession.close();
    return menu;
  }

  public boolean registMenu(MenuDTO menu) {
  SqlSession sqlSession = getSqlSession();
    MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
    // insert된 결과 행의 개수를 반환 받아 저장
    int result = mapper.insertMenu(menu);

    if(result>0) sqlSession.commit();
    else sqlSession.rollback();

    sqlSession.close();
    return result>0;
  }

  /* 메소드명, id 등 : updateMenu */
  public boolean modifyMenu(MenuDTO menu) {
    SqlSession sqlSession = getSqlSession();
    MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
    int result = mapper.updateMenu(menu);

    if(result>0) sqlSession.commit();
    else sqlSession.rollback();
    return result>0;
  }

  /* 메소드명, id 등 : deleteMenu */
  public boolean deleteMenu(int menuCode) {
    SqlSession sqlSession = getSqlSession();
    MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
    int result = mapper.deleteMenu(menuCode);

    if(result>0) sqlSession.commit();
    else sqlSession.rollback();
    return result>0;
  }


}