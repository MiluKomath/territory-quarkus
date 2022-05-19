package com.territory;


import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class TerritoryEntity extends PanacheEntity {
	
//	@Column
//	@Id @GeneratedValue
//	public long id;
	public long organizationId;
	public String code;
	public String name;
	public String shortName;
	public String details;
	public String notes;
	public String createdBy;
	public String updatedBy;
	public String createdAt;
	public String updatedAt;

}
