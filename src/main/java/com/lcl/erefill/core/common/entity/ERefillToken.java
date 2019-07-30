package com.lcl.erefill.core.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.namespace.QName;

import com.lcl.erefill.core.utils.CommonUtils;

public final class ERefillToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8731823095274615519L;

	private List<String> status;

	@XmlElementRef(name = "Token", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
	private JAXBElement<byte[]> token;

	public ERefillToken() {
		super();
	}

	public ERefillToken(List<String> status, JAXBElement<byte[]> token) {
		super();
		this.status = status;
		this.token = token;
	}

	public ERefillToken(
			com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Error error) {
		if (!CommonUtils.isNullOrEmpty(error.getType())
				&& !"eTokenExpired".equals(error.getType().get(0))) {
			status = error.getUserToken().getValue().getStatus();
			token = error.getUserToken().getValue().getToken();
		}
	}

	public List<String> getStatus() {
		if (null == status)
			status = new ArrayList<String>();
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public JAXBElement<byte[]> getToken() {
		return token;
	}

	public void setToken(JAXBElement<byte[]> token) {
		this.token = token;
	}

	public void fill(
			com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}

	public void fill(
			com.lcl.erefill.generated.telus.profile.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void fill(String status, String token) {
		getStatus().add(status);
		this.token = new JAXBElement(
				new QName(
						"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
						"Token"), byte[].class,
				CommonUtils.stringAsByteArray(token));
	}

	public void fill(
			com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}

	public void fill(
			com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}

	public void fill(
			com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}

	public void fill(
			com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}
	
	public void fill(
			com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}
	
	public void fill(
			com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.UserToken userToken) {
		userToken.getStatus().addAll(getStatus());
		userToken.setToken(getToken());
	}
}
