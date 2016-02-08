package tailspin.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Survey {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ID;
	@Persistent
	private String name;
	@Persistent
	private String description;
	@Persistent
	private Long tenantID;
	
	public Survey(String name, String description, Long tenantID)
	{
		this.name = name;
		this.description = description;
		this.tenantID = tenantID;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTenantID() {
		return tenantID;
	}

	public void setTenantID(Long tenantID) {
		this.tenantID = tenantID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
