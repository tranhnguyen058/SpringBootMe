package com.tranhjava.converter;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.tranhjava.dto.NewDTO;
import com.tranhjava.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity entity = new NewEntity();
		entity.setTitle(newDTO.getTitle());
		entity.setContent(newDTO.getContent());
		entity.setThumbnail(newDTO.getThumbnail());
		entity.setShortDescription(newDTO.getShortDescription());
		
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO newDTO = new NewDTO();
		if(entity.getId() != null) {
			newDTO.setId(entity.getId());
		}
		newDTO.setTitle(entity.getTitle());
		newDTO.setContent(entity.getContent());
		newDTO.setThumbnail(entity.getThumbnail());
		newDTO.setShortDescription(entity.getShortDescription());
		newDTO.setCreatedDate(entity.getCreatedDate());
		newDTO.setCreatedBy(entity.getCreatedBy());
		newDTO.setModifiedDate(entity.getModifiedDate());
		newDTO.setModifiedBy(entity.getModifiedBy());
		
		return newDTO;
	}
	public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity) {
		NewEntity entity = new NewEntity();
		entity.setTitle(newDTO.getTitle());
		entity.setContent(newDTO.getContent());
		entity.setThumbnail(newDTO.getThumbnail());
		entity.setShortDescription(newDTO.getShortDescription());
		return entity;
	}
	
	
}
