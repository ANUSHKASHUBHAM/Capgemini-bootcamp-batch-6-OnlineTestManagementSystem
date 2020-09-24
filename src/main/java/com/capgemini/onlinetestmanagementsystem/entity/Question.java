package com.capgemini.onlinetestmanagementsystem.entity;

	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "questionansweradmin")
	public class Question {

		    @Id
			@Column(name="Sno")
			int Sno;
			
			@Column(name="Question")
			String questionvalue;
			@Column(name="Topic")
			String questiondomain;
			@Column(name="marks")
		      int questionmarks;
			@Column(name="option1")
		    String option1;
			@Column(name="option2")
		   String option2;
			@Column(name="option3")
		    String option3;
			@Column(name="option4")
		    String option4;
			
			@Column(name="Answer")
			String correctoption;
		
	public Question()
	{
			
		}

	@Override
	public String toString() {
		return "QuestionAnswerAdmin [Sno=" + Sno + ", questionvalue=" + questionvalue + ", questiondomain=" + questiondomain
				+ ", questionmarks=" + questionmarks + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", correctoption=" + correctoption + "]";
	}

	public Question(int sno, String questionvalue, String questiondomain, int questionmarks, String option1,
			String option2, String option3, String option4, String correctoption) {
		
		Sno = sno;
		this.questionvalue = questionvalue;
		this.questiondomain = questiondomain;
		this.questionmarks = questionmarks;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctoption = correctoption;
	}

	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

	public String getQuestionvalue() {
		return questionvalue;
	}

	public void setQuestionvalue(String questionvalue) {
		this.questionvalue = questionvalue;
	}

	public String getQuestiondomain() {
		return questiondomain;
	}

	public void setQuestiondomain(String questiondomain) {
		this.questiondomain = questiondomain;
	}

	public int getQuestionmarks() {
		return questionmarks;
	}

	public void setQuestionmarks(int questionmarks) {
		this.questionmarks = questionmarks;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectoption() {
		return correctoption;
	}

	public void setCorrectoption(String correctoption) {
		this.correctoption = correctoption;
	}



}
