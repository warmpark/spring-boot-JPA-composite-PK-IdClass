package com.t3q.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the user_group database table.
 * 
 */
@Entity
@Table(name="user_group")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GROUP_ID")
	private Long groupId;

	@Column(name="GROUP_NAME")
	private String groupName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userGroup")
	@JsonIgnore
	private List<User> users;

	public UserGroup() {
	}

	public UserGroup(Long groupId) {
		this.groupId = groupId;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserGroup(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserGroup(null);

		return user;
	}

	@Override
	public String toString() {
		return "UserGroup [groupId=" + groupId + ", groupName=" + groupName + ", users=" + users + "]";
	}
	
	

}