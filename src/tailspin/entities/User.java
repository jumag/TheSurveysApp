package tailspin.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ID;
	@Persistent
	private Long tenantID;
	@Persistent
	private Long roleID;
	@Persistent
	private String username;
	@Persistent
	private String password;
	
	public User(String username, String password, Long tenantID, Long roleID){
		this.username = username;
		this.password = password;
		this.tenantID = tenantID;
		this.roleID = roleID;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getTenantID() {
		return tenantID;
	}

	public void setTenantID(Long tenantID) {
		this.tenantID = tenantID;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}