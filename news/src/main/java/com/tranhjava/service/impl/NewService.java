package com.tranhjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tranhjava.converter.NewConverter;
import com.tranhjava.dto.NewDTO;
import com.tranhjava.entity.CategoryEntity;
import com.tranhjava.entity.NewEntity;
import com.tranhjava.repository.CategoryRepository;
import com.tranhjava.repository.NewRepository;
import com.tranhjava.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() == null) {
			newEntity = newConverter.toEntity(newDTO);
			
		} else {
			NewEntity oldNew = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNew);
			
			
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode()); 
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (Long item : ids) {
			newRepository.delete(item);
		}
		
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : entities) {
			NewDTO newDTO = newConverter.toDTO(newEntity);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}
}
