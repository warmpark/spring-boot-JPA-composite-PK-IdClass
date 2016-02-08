package com.t3q.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@IdClass(AddressPK.class)
@Table(name = "address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1199993764819370925L;
	
	@Id
	@Column(name = "EMAIL")
	String email;
	

	@Id
	@Column(name = "ADDRESS")
	String address;
	
	@Column(name="COMMENTS")
	String comments;
	
	@Transient
	String etc;
	
	
	

	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL", insertable=false, updatable=false)
	//@JsonManagedReference
	//@JsonBackReference : for many
	//@JsonIgnore
	private User user;



	public User getUser() {
		return user;
	}

	
    public void setUser(User user) {
        this.user = user;
    }
	
	public Address(){
		
	}

	public Address (String email, String address){
		this.email = email;
		this.address = address;
	}

	

	
	public Address (String email, String address, String comments){
		this.email = email;
		this.address = address;
		this.comments = comments;
	}

	

	public Address(AddressPK addressPK) {
		this.email = addressPK.getEmail();
		this.address = addressPK.getAddress();
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}




	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Address [email=" + email + ", address=" + address + ", comments=" + comments + ", user=" + user + "]";
	}




}


