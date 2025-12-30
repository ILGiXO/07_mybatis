package com.work.transaction.mapper;


import com.work.transaction.domain.Order;
import com.work.transaction.domain.OrderMenu;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;

// Mybatis가 해당 인터페이스를 구현하여 객체 (proxy)로 만들고  이를 Bean으로 등록
@Mapper
public interface OrderMapper {

  void insertOrder(Order order);

  void insertOrderMenu(OrderMenu orderMenu);
}




