package com.territory.territory;

import java.sql.Timestamp;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class Territory {
	private Long id;

	private String organization;

	private String code;
	private String name;
	private String shortName;
	private String details;
	private String notes;
	private String createdBy;
	private String updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;

}




 