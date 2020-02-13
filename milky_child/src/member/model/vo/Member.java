package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * VO Value Object
 * DTO Data Transfer Object
 * DO Domain Object
 * Entity
 * bean
 * 
 * VO클래스의 조건
 * 1. 모든 필드는 반드시 캡슐화 적용된 private 사용.
 * 2. 필드에 대해 getter/setter 작성 필수
 * 3. 기본생성자/파라미터생성자 작성 필수
 * 4. 직렬화 처리 (Serializable 인터페이스 구현. versionUID 작성)
 * 
 */
public class Member implements Serializable, HttpSessionBindingListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private String password;
	private String memberName;
	private String memberNickname;
	private Date birthDay;
	private String phone;
	private String pwdHint;
	private String pwdAns;
	private String address;
	private String email;
	private String grade;
	private String gender;
	private int age;
	private String oneFamily;
	private Date enrollDate;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Member(String memberId, String password, String memberName, String memberNickname, Date birthDay,
			String phone, String pwdHint, String pwdAns, String address, String email, String grade, String gender,
			int age, String oneFamily, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.birthDay = birthDay;
		this.phone = phone;
		this.pwdHint = pwdHint;
		this.pwdAns = pwdAns;
		this.address = address;
		this.email = email;
		this.grade = grade;
		this.gender = gender;
		this.age = age;
		this.oneFamily = oneFamily;
		this.enrollDate = enrollDate;
	}








	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", memberName=" + memberName
				+ ", memberNickname=" + memberNickname + ", birthDay=" + birthDay + ", phone=" + phone + ", pwdHint="
				+ pwdHint + ", pwdAns=" + pwdAns + ", address=" + address + ", email=" + email + ", grade=" + grade
				+ ", gender=" + gender + ", age=" + age + ", oneFamily=" + oneFamily + ", enrollDate=" + enrollDate
				+ "]";
	}





	public String getMemberId() {
		return memberId;
	}






	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
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






	public Date getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}






	public String getPhone() {
		return phone;
	}






	public void setPhone(String phone) {
		this.phone = phone;
	}






	public String getPwdHint() {
		return pwdHint;
	}






	public void setPwdHint(String pwdHint) {
		this.pwdHint = pwdHint;
	}






	public String getPwdAns() {
		return pwdAns;
	}






	public void setPwdAns(String pwdAns) {
		this.pwdAns = pwdAns;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getGrade() {
		return grade;
	}






	public void setGrade(String grade) {
		this.grade = grade;
	}






	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public int getAge() {
		return age;
	}






	public void setAge(int age) {
		this.age = age;
	}






	public String getOneFamily() {
		return oneFamily;
	}






	public void setOneFamily(String oneFamily) {
		this.oneFamily = oneFamily;
	}






	public Date getEnrollDate() {
		return enrollDate;
	}






	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	/**
	 * Member객체가 Session의 속성에 등록될때 호출됨.
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(memberName+"["+memberId+"]님이 로그인했습니다.");
	}

	/**
	 * session 속성에 등록된 Member객체가 해제될 때 호출됨.
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(memberName+"["+memberId+"]님이 로그아웃했습니다.");
	}
	
	
	
	
}
