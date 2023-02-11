package com.tranhjava.output;

import java.util.ArrayList;
import java.util.List;

import com.tranhjava.dto.NewDTO;

public class NewOutput {
	private int page;
	private int totalPage;
	private List<NewDTO> listResults = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<NewDTO> getListResults() {
		return listResults;
	}
	public void setListResults(List<NewDTO> listResults) {
		this.listResults = listResults;
	}

	
}
