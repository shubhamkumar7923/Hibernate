package com.abc;


import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="PASSPORT")

public class Passport {
	private int pid;
	private String pnumber;
	private Citizen citizen;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PID")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Column(name="PNUMBER")
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PID")
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}