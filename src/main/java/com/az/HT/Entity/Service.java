package com.az.HT.Entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services")
@Access(value = AccessType.FIELD)
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id", nullable = false)
	private Integer id;

	@Column(name = "service_name", nullable = false)
	private String name;

	@Column(name = "service_system_status", nullable = false)
	private String system_status;

	@Column(name = "service_status", nullable = false)
	private String status;

	@Column(name = "service_status_description")
	private String description;

	@Column(name = "service_category", nullable = false)
	private String category;

	@Column(name = "service_incident_number", nullable = false)
	private String incident_number;

	@Column(name = "service_priority", nullable = false)
	private Integer priority;

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public String getIncident_number() {
		return incident_number;
	}

	public String getName() {
		return name;
	}

	public Integer getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public String getSystem_status() {
		return system_status;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIncident_number(String incident_number) {
		this.incident_number = incident_number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSystem_status(String system_status) {
		this.system_status = system_status;
	}

}
