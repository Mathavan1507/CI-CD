package com.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tariffs")
public class Tariff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String planName;
	private Double unitPrice;

	public Tariff() {
	}

	public Tariff(String planName, Double unitPrice) {
		this.planName = planName;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
