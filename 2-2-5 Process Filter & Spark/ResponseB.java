package com.sparkTutorial.rdd;

public class ResponseB {

	private int transaction_id;
	private int day;
	private int month;
	private int year;
	private String credit_card_no;
	private int cust_ssn;
	private int branch_code;
	private String transaction_code;
	private float transaction_value;
	
	public ResponseB(int transaction_id, int day, int month, int year, String credit_card_no, int cust_ssn,
			int branch_code, String transaction_code, float transaction_value) {
		super();
		this.transaction_id = transaction_id;
		this.day = day;
		this.month = month;
		this.year = year;
		this.credit_card_no = credit_card_no;
		this.cust_ssn = cust_ssn;
		this.branch_code = branch_code;
		this.transaction_code = transaction_code;
		this.transaction_value = transaction_value;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCredit_card_no() {
		return credit_card_no;
	}

	public void setCredit_card_no(String credit_card_no) {
		this.credit_card_no = credit_card_no;
	}

	public int getCust_ssn() {
		return cust_ssn;
	}

	public void setCust_ssn(int cust_ssn) {
		this.cust_ssn = cust_ssn;
	}

	public int getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}

	public String getTransaction_code() {
		return transaction_code;
	}

	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}

	public float getTransaction_value() {
		return transaction_value;
	}

	public void setTransaction_value(float transaction_value) {
		this.transaction_value = transaction_value;
	}

	@Override
	public String toString() {
		return "ResponseB [transaction_id=" + transaction_id + ", day=" + day + ", month=" + month + ", year=" + year
				+ ", credit_card_no=" + credit_card_no + ", cust_ssn=" + cust_ssn + ", branch_code=" + branch_code
				+ ", transaction_code=" + transaction_code + ", transaction_value=" + transaction_value + "]";
	}
	
   
	
	
	
	
	
}

