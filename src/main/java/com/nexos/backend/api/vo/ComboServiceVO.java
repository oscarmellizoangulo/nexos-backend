package com.nexos.backend.api.vo;

import java.io.Serializable;

public class ComboServiceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idComboService;

	private ComboVO combo;

	private ServiceVO serviceVO;

	public ComboServiceVO() {
	}

	public int getIdComboService() {
		return this.idComboService;
	}

	public void setIdComboService(int idComboService) {
		this.idComboService = idComboService;
	}

	public ComboVO getCombo() {
		return this.combo;
	}

	public void setCombo(ComboVO combo) {
		this.combo = combo;
	}

	public ServiceVO getServiceVO() {
		return serviceVO;
	}

	public void setServiceVO(ServiceVO serviceVO) {
		this.serviceVO = serviceVO;
	}

}