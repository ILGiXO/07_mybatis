package com.work.mapper;

import com.work.dto.CategoryAndMenuDTO;
import com.work.dto.MenuAndCategoryDTO;
import com.work.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
