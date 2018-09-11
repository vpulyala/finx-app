package com.osi.finx.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the quadx_role database table.
 * 
 */
@Entity
@Table(name = "qxma_role", catalog = "finx_db")
@NamedQuery(name="QxRole.findAll", query="SELECT q FROM QxmaRole q")
public class QxmaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Column(name="created_by")
	private Long createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	@Column(name="role_description")
	private String roleDescription;

	@Column(name="role_name")
	private String roleName;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="updated_by")
	private Long updatedBy;

	//bi-directional many-to-one association to QuadxUser
	@OneToMany(mappedBy="quadxRole")
	private List<QxmaUser> quadxUsers;

	public QxmaRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public List<QxmaUser> getQuadxUsers() {
		return this.quadxUsers;
	}

	public void setQuadxUsers(List<QxmaUser> quadxUsers) {
		this.quadxUsers = quadxUsers;
	}

	public QxmaUser addQuadxUser(QxmaUser quadxUser) {
		getQuadxUsers().add(quadxUser);
		quadxUser.setQuadxRole(this);

		return quadxUser;
	}

	public QxmaUser removeQuadxUser(QxmaUser quadxUser) {
		getQuadxUsers().remove(quadxUser);
		quadxUser.setQuadxRole(null);

		return quadxUser;
	}

}