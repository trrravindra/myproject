package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.List;

public class PasswordReminder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8141109143579948640L;
	
	private List<String> questions;
	private List<String> answers;
	private short index;

	public short getIndex() {
		return index;
	}

	public void setIndex(short index) {
		this.index = index;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
