package com.osi.finx.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the quadx_user database table.
 * 
 */
@Entity
@Table(name = "qxma_user", catalog = "finx_db")
@NamedQuery(name="QxUser.findAll", query="SELECT q FROM QxmaUser q")
public class QxmaUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;

	@Column(name="created_by")
	private Long createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	@Column(name="first_name")
	private String firstName;

	@Column(name="is_first_login")
	private int isFirstLogin;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="updated_by")
	private Long updatedBy;

	private String username;

	//bi-directional many-to-one association to QuadxRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private QxmaRole quadxRole;

	public QxmaUser() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getIsFirstLogin() {
		return this.isFirstLogin;
	}

	public void setIsFirstLogin(int isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public QxmaRole getQuadxRole() {
		return this.quadxRole;
	}

	public void setQuadxRole(QxmaRole quadxRole) {
		this.quadxRole = quadxRole;
	}

}