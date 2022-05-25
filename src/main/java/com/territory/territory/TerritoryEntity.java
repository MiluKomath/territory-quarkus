package com.territory.territory;

import java.sql.Timestamp;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name = "territories")
public class TerritoryEntity extends PanacheEntity {

//	@Column
//	@Id @GeneratedValue
//	public long id;
	public String organization;
	public String code;
	public String name;
	public String shortName;
	public Boolean status;
	public String designation;
	public String details;
	public String notes;
	public String createdBy;
	public String updatedBy;
	public Timestamp createdAt;
	public Timestamp updatedAt;
	

}
