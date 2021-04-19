package vn.loveBook.converter;

import vn.loveBook.DTO.CategoryDTO;
import vn.loveBook.entity.CategoryEntity;

public class CategoryConverter {
	public static CategoryDTO toDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCode(categoryEntity.getCode());
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setName(categoryEntity.getName());
		return categoryDTO;
	}
}
