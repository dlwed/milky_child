package model.vo;

import java.sql.Date;

public class Adopt {
	private String adoptNum;
	private String memberId;
	private String carePublicationNum;
	private String APAgreementFile;
	private String petApplicationFile;
	private Date applicationDate;
	private Date checkDate;
	private String adoptResult;
	
	public Adopt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Adopt(String adoptNum, String memberId, String carePublicationNum, String aPAgreementFile,
			String petApplicationFile, Date applicationDate, Date checkDate, String adoptResult) {
		super();
		this.adoptNum = adoptNum;
		this.memberId = memberId;
		this.carePublicationNum = carePublicationNum;
		APAgreementFile = aPAgreementFile;
		this.petApplicationFile = petApplicationFile;
		this.applicationDate = applicationDate;
		this.checkDate = checkDate;
		this.adoptResult = adoptResult;
	}

	public String getAdoptNum() {
		return adoptNum;
	}

	public void setAdoptNum(String adoptNum) {
		this.adoptNum = adoptNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCarePublicationNum() {
		return carePublicationNum;
	}

	public void setCarePublicationNum(String carePublicationNum) {
		this.carePublicationNum = carePublicationNum;
	}

	public String getAPAgreementFile() {
		return APAgreementFile;
	}

	public void setAPAgreementFile(String aPAgreementFile) {
		APAgreementFile = aPAgreementFile;
	}

	public String getPetApplicationFile() {
		return petApplicationFile;
	}

	public void setPetApplicationFile(String petApplicationFile) {
		this.petApplicationFile = petApplicationFile;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getAdoptResult() {
		return adoptResult;
	}

	public void setAdoptResult(String adoptResult) {
		this.adoptResult = adoptResult;
	}

	@Override
	public String toString() {
		return "Adopt [adoptNum=" + adoptNum + ", memberId=" + memberId + ", carePublicationNum=" + carePublicationNum
				+ ", APAgreementFile=" + APAgreementFile + ", petApplicationFile=" + petApplicationFile
				+ ", applicationDate=" + applicationDate + ", checkDate=" + checkDate + ", adoptResult=" + adoptResult
				+ "]";
	}
	
	
	
}
