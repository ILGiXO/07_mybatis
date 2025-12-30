package com.work.springmybatis.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

  private final SqlSessionTemplate sqlSessionTemplate; //openSession,과 클로즈가 자동으로 이루어지는 트랜잭션 자동처리도 된다.

  public MenuService(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }

  public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus) {

    List<MenuDTO> menus = sqlSessionTemplate.getMapper(MenuMapper.class).findAllMenuByOrderableStatus(orderableStatus);

    if (menus != null) { //select 성공시
      menus.forEach(menu -> {
        if ("Y".equals(menu.getOrderableStatus())) {
          menu.setMenuName(menu.getMenuName() + "(주문 가능)");
        } else {
          menu.setMenuName(menu.getMenuName() + "(주문 불가능)");
        }
      });
    }
    return menus;
  }
}
