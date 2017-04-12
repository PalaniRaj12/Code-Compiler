package com.T14GString.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

 
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name = "SolutionDB")
public class CompilationForm {
	@Column
	private String code=new String();
	@Column
	private String stdout=new String("");
	@Column
	private String stderr=new String("");
	@Id
	private int questionId;
	
	@Transient
	private boolean checkbox;
	@Transient
	private CommonsMultipartFile file;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public String getStdout() {
		return stdout;
	}
	public void setStdout(String stdout) {
		this.stdout = stdout;
	}
	public String getStderr() {
		return stderr;
	}
	public void setStderr(String stderr) {
		this.stderr = stderr;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	
	
	
	
	
	
}
