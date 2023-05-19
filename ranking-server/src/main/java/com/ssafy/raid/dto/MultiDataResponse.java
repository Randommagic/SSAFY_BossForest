package com.ssafy.raid.dto;

public class MultiDataResponse<Data> {

	private int itemCount;
	private Iterable<Data> items;
	
	public MultiDataResponse(int itemCount, Iterable<Data> items) {
		super();
		this.itemCount = itemCount;
		this.items = items;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public Iterable<Data> getItems() {
		return items;
	}

	public void setItems(Iterable<Data> items) {
		this.items = items;
	}
	
}
