package model.vo;

import java.sql.Date;

public class Promote {
	private String promoteNum;
	private String memberId;
	private String oldPromoteFile;
	private String renamedPromoteFile;
	private String beforeGrade;
	private Date promoteApplyDate;
	private Date checkDate;
	private String resultGrade;
	
	public Promote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Promote(String promoteNum, String memberId, String oldPromoteFile, String renamedPromoteFile,
			String beforeGrade, Date promoteApplyDate, Date checkDate, String resultGrade) {
		super();
		this.promoteNum = promoteNum;
		this.memberId = memberId;
		this.oldPromoteFile = oldPromoteFile;
		this.renamedPromoteFile = renamedPromoteFile;
		this.beforeGrade = beforeGrade;
		this.promoteApplyDate = promoteApplyDate;
		this.checkDate = checkDate;
		this.resultGrade = resultGrade;
	}

	public String getPromoteNum() {
		return promoteNum;
	}
	public void setPromoteNum(String promoteNum) {
		this.promoteNum = promoteNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}	
	public String getOldPromoteFile() {
		return oldPromoteFile;
	}
	public void setOldPromoteFile(String oldPromoteFile) {
		this.oldPromoteFile = oldPromoteFile;
	}
	public String getRenamedPromoteFile() {
		return renamedPromoteFile;
	}
	public void setRenamedPromoteFile(String renamedPromoteFile) {
		this.renamedPromoteFile = renamedPromoteFile;
	}
	public String getBeforeGrade() {
		return beforeGrade;
	}
	public void setBeforeGrade(String beforeGrade) {
		this.beforeGrade = beforeGrade;
	}
	public Date getPromoteApplyDate() {
		return promoteApplyDate;
	}
	public void setPromoteApplyDate(Date promoteApplyDate) {
		this.promoteApplyDate = promoteApplyDate;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getResultGrade() {
		return resultGrade;
	}
	public void setResultGrade(String resultGrade) {
		this.resultGrade = resultGrade;
	}


	@Override
	public String toString() {
		return "Promote [promoteNum=" + promoteNum + ", memberId=" + memberId + ", oldPromoteFile=" + oldPromoteFile
				+ ", renamedPromoteFile=" + renamedPromoteFile + ", beforeGrade=" + beforeGrade + ", promoteApplyDate="
				+ promoteApplyDate + ", checkDate=" + checkDate + ", resultGrade=" + resultGrade + "]";
	}

	

	
	
	
}
