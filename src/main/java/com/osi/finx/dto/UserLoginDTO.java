package com.osi.finx.dto;

import java.io.Serializable;
import java.util.Date;

import com.osi.finx.model.QxmaUser;


public class UserLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String firstName;
	private int isFirstLogin;
	private String lastName;
	private String password;
	private int status;
	private String username;
	private Integer roleId;
	private String roleName;
	private Integer createdBy;
	private Date creationDate;
	private Integer updatedBy;
	private Date updateDate;
	
	public UserLoginDTO(){}
	
	public UserLoginDTO(QxmaUser user){
		setUserId(user.getUserId().toString());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setIsFirstLogin(user.getIsFirstLogin());
		setStatus(user.getStatus());
		setUsername(user.getUsername());
		setRoleId(user.getQuadxRole().getRoleId());
		setRoleName(user.getQuadxRole().getRoleName());
		setPassword(user.getPassword());
		setCreatedBy(user.getCreatedBy().intValue());
		setCreationDate(user.getCreationDate());
		setUpdateDate(user.getUpdateDate());
		setUpdatedBy(user.getUpdatedBy().intValue());
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getIsFirstLogin() {
		return isFirstLogin;
	}
	public void setIsFirstLogin(int isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
