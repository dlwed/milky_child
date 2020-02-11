package model.vo;

import java.sql.Date;

public class CarePet {
	private String carePublicationNum;
	private String careBreed;
    private String careName;
    private int careAge;
    private Date careReceiveDay;
    private String careGender;
    private String careCha;
    private String careCon;
    private String careFindLoc;
    private String careRegiNo;
    private String careShelter;
	public CarePet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarePet(String carePublicationNum, String careBreed, String careName, int careAge, Date careReceiveDay,
			String careGender, String careCha, String careCon, String careFindLoc, String careRegiNo,
			String careShelter) {
		super();
		this.carePublicationNum = carePublicationNum;
		this.careBreed = careBreed;
		this.careName = careName;
		this.careAge = careAge;
		this.careReceiveDay = careReceiveDay;
		this.careGender = careGender;
		this.careCha = careCha;
		this.careCon = careCon;
		this.careFindLoc = careFindLoc;
		this.careRegiNo = careRegiNo;
		this.careShelter = careShelter;
	}
	public String getCarePublicationNum() {
		return carePublicationNum;
	}
	public void setCarePublicationNum(String carePublicationNum) {
		this.carePublicationNum = carePublicationNum;
	}
	public String getCareBreed() {
		return careBreed;
	}
	public void setCareBreed(String careBreed) {
		this.careBreed = careBreed;
	}
	public String getCareName() {
		return careName;
	}
	public void setCareName(String careName) {
		this.careName = careName;
	}
	public int getCareAge() {
		return careAge;
	}
	public void setCareAge(int careAge) {
		this.careAge = careAge;
	}
	public Date getCareReceiveDay() {
		return careReceiveDay;
	}
	public void setCareReceiveDay(Date careReceiveDay) {
		this.careReceiveDay = careReceiveDay;
	}
	public String getCareGender() {
		return careGender;
	}
	public void setCareGender(String careGender) {
		this.careGender = careGender;
	}
	public String getCareCha() {
		return careCha;
	}
	public void setCareCha(String careCha) {
		this.careCha = careCha;
	}
	public String getCareCon() {
		return careCon;
	}
	public void setCareCon(String careCon) {
		this.careCon = careCon;
	}
	public String getCareFindLoc() {
		return careFindLoc;
	}
	public void setCareFindLoc(String careFindLoc) {
		this.careFindLoc = careFindLoc;
	}
	public String getCareRegiNo() {
		return careRegiNo;
	}
	public void setCareRegiNo(String careRegiNo) {
		this.careRegiNo = careRegiNo;
	}
	public String getCareShelter() {
		return careShelter;
	}
	public void setCareShelter(String careShelter) {
		this.careShelter = careShelter;
	}
	
	@Override
	public String toString() {
		return "CarePet [carePublicationNum=" + carePublicationNum + ", careBreed=" + careBreed + ", careName="
				+ careName + ", careAge=" + careAge + ", careReceiveDay=" + careReceiveDay + ", careGender="
				+ careGender + ", careCha=" + careCha + ", careCon=" + careCon + ", careFindLoc=" + careFindLoc
				+ ", careRegiNo=" + careRegiNo + ", careShelter=" + careShelter + "]";
	}
    
    
}
