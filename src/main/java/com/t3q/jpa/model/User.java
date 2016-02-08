package com.t3q.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1199993764819370925L;

	@Id
	@Column(name = "EMAIL", unique = true, nullable = false)
	String email;
	
	@Column(name = "NAME", nullable = false)
	String name;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "USE_YN", nullable = true)
	String useYn;

	@Column(name = "REG_USER", nullable = true)
	String regUser;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	//@JsonManagedReference : for 1
	//@JsonBackReference
	@JsonIgnore
	//Set<Address> addresses = new HashSet<Address>(0);
	private List<Address> addresses;


	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="GROUP_ID", nullable=false)
	//@JsonManagedReference
	//@JsonBackReference : for many
	//@JsonIgnore
	private UserGroup userGroup;
	
	
	

	public User() {

	}

	public User(String email) {
		this.email = email;
	}

	public User(String email,Long groupId, String name,  Integer age, String useYn, String regUser) {
		this.email = email;
		this.userGroup = new UserGroup(groupId);
		//this.groupId = groupId;
		this.name = name;
		this.age = age;
		this.useYn = useYn;
		this.regUser = regUser;
	}


	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}


	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}
	
	

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", age=" + age + ", useYn=" + useYn + ", regUser=" + regUser +"]";
	}

	

}
