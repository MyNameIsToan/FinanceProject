package com.runningmicroservice.service2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="provider")
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String taxNo;
	private String name;
	private String address;
	private String email;
	private String fax;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "group_user", 
				joinColumns = {@JoinColumn(name = "proivder_id")}, 
				inverseJoinColumns = {@JoinColumn(name = "bank_id")})
	private List<Bank> listBank = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "representer_id", referencedColumnName = "id")
	private Representer representer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public List<Bank> getListBank() {
		return listBank;
	}
	public void setListBank(List<Bank> listBank) {
		this.listBank = listBank;
	}
	public Representer getRepresenter() {
		return representer;
	}
	public void setRepresenter(Representer representer) {
		this.representer = representer;
	}
}
