package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;






@Entity
@Table(name="requests")
public class RequestForm {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="request_id")
	private Integer requestID;
	
	@NotNull(message="Required*")
	@Column(name="asset_id")
	private int assetID;
	
	@NotNull(message="Required*")
	@Column(name="asset_name")
	private String assetName;
	
	@NotNull(message="Required*")
	@Column(name="asset_category")
	private String assetCategory;
	
	@NotNull(message="Required*")
	@Column(name="img_url")
	private String imgUrl;
	
	@NotNull(message="Required*")
	@Column(name="employee_id")
	private Integer employeeID;
	
	@NotNull(message="Required*")
	@Column(name="quantity")
	private Integer quantity;
	
	@NotNull(message="Required*")
    @Column(name="asset_cost")
	private Double assetCost;
	
	@NotNull(message="Required*")
	@Column(name="additional_notes")
	private String additionalNotes;

	
	@Column(name="alloted")
	private boolean alloted;
	

	
	
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
    private UsersInfo userbean;
	
    public RequestForm() {
    	
    }

	public Integer getRequestID() {
		return requestID;
	}

	public void setRequestID(Integer requestID) {
		this.requestID = requestID;
	}

	public int getAssetID() {
		return assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAssetCost() {
		return assetCost;
	}

	public void setAssetCost(Double assetCost) {
		this.assetCost = assetCost;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public boolean isAlloted() {
		return alloted;
	}

	public void setAlloted(boolean alloted) {
		this.alloted = alloted;
	}

	public UsersInfo getUserbean() {
		return userbean;
	}

	public void setUserbean(UsersInfo userbean) {
		this.userbean = userbean;
	}

	@Override
	public String toString() {
		return "RequestForm [requestID=" + requestID + ", assetID=" + assetID + ", assetName=" + assetName
				+ ", assetCategory=" + assetCategory + ", imgUrl=" + imgUrl + ", employeeID=" + employeeID
				+ ", quantity=" + quantity + ", assetCost=" + assetCost + ", additionalNotes=" + additionalNotes
				+ ", alloted=" + alloted + ", userbean=" + userbean + "]";
	}

	

}
