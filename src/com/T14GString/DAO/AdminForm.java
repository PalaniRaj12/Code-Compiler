package com.T14GString.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
@Table(name = "QuestionDB")
public class AdminForm {
	
	@Column
	@NotEmpty
	private String question;
	@NotEmpty
	@Column
	private String resultantString;
	@NotEmpty
	@Column
	private String inputString;
	@Column
	private String condition;
	@Id
	private int questionId;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResultantString() {
		return resultantString;
	}
	public void setResultantString(String resultantString) {
		this.resultantString = resultantString;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getQuestionId() {
		return questionId;
	}
	public String getInputString() {
		return inputString;
	}
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	
	
}
