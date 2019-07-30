package com.lcl.erefill.core.vo;

import java.io.Serializable;

/**
 * @author vsha51
 */
public class UpdateSecurityQuestions implements Serializable {

	private static final long serialVersionUID = 4784515622086913349L;

	private String question1;

	private String question2;

	private String question3;

	private String answer1;

	private String answer2;

	private String answer3;

	/**
	 * @return the question1
	 */
	public String getQuestion1() {
		return question1;
	}

	/**
	 * @param question1
	 *            the question1 to set
	 */
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	/**
	 * @return the question2
	 */
	public String getQuestion2() {
		return question2;
	}

	/**
	 * @param question2
	 *            the question2 to set
	 */
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	/**
	 * @return the question3
	 */
	public String getQuestion3() {
		return question3;
	}

	/**
	 * @param question3
	 *            the question3 to set
	 */
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	/**
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}

	/**
	 * @param answer1
	 *            the answer1 to set
	 */
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	/**
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}

	/**
	 * @param answer2
	 *            the answer2 to set
	 */
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	/**
	 * @return the answer3
	 */
	public String getAnswer3() {
		return answer3;
	}

	/**
	 * @param answer3
	 *            the answer3 to set
	 */
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

}
