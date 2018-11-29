package com.nexos.backend.api.beans;


public class ItemVO {
	private Long idItem;
	private String item;
	/**
	 * @param idItem
	 * @param item
	 */
	public ItemVO(Long idItem, String item) {
		super();
		this.idItem = idItem;
		this.item = item;
	}
	/**
	 * @return the idItem
	 */
	public Long getIdItem() {
		return idItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(Long idItem) {
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
