package model.vo;

import java.sql.Date;

public class Partner {
	private String coopCode;
    private String coopName;
    private String coopField;
    private String coopGrade;
    private String coopCall;
    private String coopFax;
    private Date coopContractDay;
    private String coopCeoName;
    private String coopUrl;

	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Partner(String coopCode, String coopName, String coopField, String coopGrade, String coopCall,
			String coopFax, Date coopContractDay, String coopCeoName, String coopUrl) {
		super();
		this.coopCode = coopCode;
		this.coopName = coopName;
		this.coopField = coopField;
		this.coopGrade = coopGrade;
		this.coopCall = coopCall;
		this.coopFax = coopFax;
		this.coopContractDay = coopContractDay;
		this.coopCeoName = coopCeoName;
		this.coopUrl = coopUrl;
	}

	public String getCoopCode() {
		return coopCode;
	}
	public void setCoopCode(String coopCode) {
		this.coopCode = coopCode;
	}
	public String getCoopName() {
		return coopName;
	}
	public void setCoopName(String coopName) {
		this.coopName = coopName;
	}
	public String getCoopField() {
		return coopField;
	}
	public void setCoopField(String coopField) {
		this.coopField = coopField;
	}
	public String getCoopGrade() {
		return coopGrade;
	}
	public void setCoopGrade(String coopGrade) {
		this.coopGrade = coopGrade;
	}
	public String getCoopCall() {
		return coopCall;
	}
	public void setCoopCall(String coopCall) {
		this.coopCall = coopCall;
	}
	public String getCoopFax() {
		return coopFax;
	}
	public void setCoopFax(String coopFax) {
		this.coopFax = coopFax;
	}
	public Date getCoopContractDay() {
		return coopContractDay;
	}
	public void setCoopContractDay(Date coopContractDay) {
		this.coopContractDay = coopContractDay;
	}
	public String getCoopCeoName() {
		return coopCeoName;
	}
	public void setCoopCeoName(String coopCeoName) {
		this.coopCeoName = coopCeoName;
	}	
	public String getCoopUrl() {
		return coopUrl;
	}
	public void setCoopUrl(String coopUrl) {
		this.coopUrl = coopUrl;
	}

	@Override
	public String toString() {
		return "Partner [coopCode=" + coopCode + ", coopName=" + coopName + ", coopField=" + coopField + ", coopGrade="
				+ coopGrade + ", coopCall=" + coopCall + ", coopFax=" + coopFax + ", coopContractDay=" + coopContractDay
				+ ", coopCeoName=" + coopCeoName + ", coopUrl=" + coopUrl + "]";
	}
	
	
    
    
}
