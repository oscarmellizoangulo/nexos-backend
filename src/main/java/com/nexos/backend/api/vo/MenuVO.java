package com.nexos.backend.api.vo;

import java.io.Serializable;

public class MenuVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idMenu;

	private String menu;

	private String url;

	public MenuVO() {
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}