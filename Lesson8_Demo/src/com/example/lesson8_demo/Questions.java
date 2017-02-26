package com.example.lesson8_demo;

import java.io.Serializable;
import java.util.Arrays;

public class Questions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1930865821899071705L;

	@Override
	public String toString() {
		return "Questions [quest=" + quest + ", answer=" + answer + ", abcd="
				+ Arrays.toString(abcd) + ", userAnswer=" + userAnswer + "]";
	}

	// 每一份考试的问题
	private String quest;

	// 正确答案
	private String answer; // A,C

	// 提供4个答案
	private String[] abcd;

	private String userAnswer;

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String[] getAbcd() {
		return abcd;
	}

	public void setAbcd(String[] abcd) {
		this.abcd = abcd;
	}

	public Questions(String quest, String answer, String[] abcd) {
		super();
		this.quest = quest;
		this.answer = answer;
		this.abcd = abcd;
	}

}
