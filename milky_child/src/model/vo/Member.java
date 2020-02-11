package model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberNickname;
    private Date memberBirthday;
    private String memberPhone;
    private int memberPwdHint;
    private String memberPwdAns;
    private String memberAddress;
    private String memberEmail;
    private String memberGrade;
    private String memberGender;
    private int memberAge;
    private String memberOneFamily;
    private Date memberEnrollDate;
	
    public Member() {
	}
    
	public Member(String memberId, String memberPwd, String memberName, String memberNickname, Date memberBirthday,
			String memberPhone, int memberPwdHint, String memberPwdAns, String memberAddress, String memberEmail,
			String memberGrade, String memberGender, int memberAge, String memberOneFamily, Date memberEnrollDate) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberBirthday = memberBirthday;
		this.memberPhone = memberPhone;
		this.memberPwdHint = memberPwdHint;
		this.memberPwdAns = memberPwdAns;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.memberGender = memberGender;
		this.memberAge = memberAge;
		this.memberOneFamily = memberOneFamily;
		this.memberEnrollDate = memberEnrollDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public Date getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getMemberPwdHint() {
		return memberPwdHint;
	}
	public void setMemberPwdHint(int memberPwdHint) {
		this.memberPwdHint = memberPwdHint;
	}
	public String getMemberPwdAns() {
		return memberPwdAns;
	}
	public void setMemberPwdAns(String memberPwdAns) {
		this.memberPwdAns = memberPwdAns;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberOneFamily() {
		return memberOneFamily;
	}
	public void setMemberOneFamily(String memberOneFamily) {
		this.memberOneFamily = memberOneFamily;
	}
	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}
	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberNickname=" + memberNickname + ", memberBirthday=" + memberBirthday + ", memberPhone="
				+ memberPhone + ", memberPwdHint=" + memberPwdHint + ", memberPwdAns=" + memberPwdAns
				+ ", memberAddress=" + memberAddress + ", memberEmail=" + memberEmail + ", memberGrade=" + memberGrade
				+ ", memberGender=" + memberGender + ", memberAge=" + memberAge + ", memberOneFamily=" + memberOneFamily
				+ ", memberEnrollDate=" + memberEnrollDate + "]";
	}    
}
