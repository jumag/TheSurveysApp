package tailspin.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

// Declares the class as capable of being stored and retrieved with JDO
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tenant {
	// Required primary key populated automatically by JDO
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ID;
	@Persistent
	private String tenantName;
	@Persistent
	private String tenantDesc;
	@Persistent
	private String tenantAddress;
	
	public Tenant(String tenantName, String tenantDesc, String tenantAddress) {
		this.tenantName = tenantName;
		this.tenantDesc = tenantDesc;
		this.tenantAddress = tenantAddress;
	}	

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	public String getTenantDesc() {
		return tenantDesc;
	}

	public void setTenantDesc(String tenantDesc) {
		this.tenantDesc = tenantDesc;
	}

	public String getTenantAddress() {
		return tenantAddress;
	}

	public void setTenantAddress(String tenantAddress) {
		this.tenantAddress = tenantAddress;
	}
}