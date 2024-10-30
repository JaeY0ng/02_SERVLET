package DTO;

import java.time.LocalDate;

public class MemberDTO {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private LocalDate joinDate;
	private char grade;
	private String city;

	public MemberDTO(int custno, String custname, String phone, String address, LocalDate joinDate, char grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joinDate = joinDate;
		this.grade = grade;
		this.city = city;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public MemberDTO() {
	}

	@Override
	public String toString() {
		return "MemberDTO [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joinDate=" + joinDate + ", grade=" + grade + ", city=" + city + "]";
	}

}
