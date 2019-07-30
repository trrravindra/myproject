package com.lcl.erefill.core.vo;

import java.io.Serializable;

/**
 * @author srao8
 */
public class MedicationRecordDetailModel implements Serializable {

	private static final long serialVersionUID = 4784415622086913349L;

	private String data_drug_id;

	/**
	 * @return the data_drug_id
	 */
	public String getData_drug_id() {
		return data_drug_id;
	}

	/**
	 * @param data_drug_id the data_drug_id to set
	 */
	public void setData_drug_id(String data_drug_id) {
		this.data_drug_id = data_drug_id;
	}

}
