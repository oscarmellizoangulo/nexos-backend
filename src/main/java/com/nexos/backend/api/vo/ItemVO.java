package com.nexos.backend.api.vo;


public class ItemVO {
	private Integer idItem;
	private String item;
	/**
	 * @param idItem
	 * @param item
	 */
	public ItemVO(Integer idItem, String item) {
		super();
		this.idItem = idItem;
		this.item = item;
	}
	/**
	 * @return the idItem
	 */
	public Integer getIdItem() {
		return idItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
}
