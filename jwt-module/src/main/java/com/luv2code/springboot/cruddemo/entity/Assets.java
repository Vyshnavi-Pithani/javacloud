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
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name="assets")
public class Assets {

	 @Id
	 @Column(name="asset_id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int assetID;
	 
	@NotNull(message="Required*")
    @Column(name="asset_name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	private String assetName;
	
	@Column(name="asset_category")
	private String assetCategory;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@NotNull(message="Required*")
    @Column(name="asset_quantity")
	private Integer assetQuantity;
	
	@NotNull(message="Required*")
    @Column(name="asset_cost")
	private Double assetCost;
	
   @NotNull(message="Required*")
    @Column(name="asset_details")
	private String assetDetails;
    
    
    @ManyToOne
//    @JsonManagedReference
	@JoinColumn(name = "user_id")
    @JsonBackReference
	private UsersInfo userbean;
    
//    @ManyToOne
////    @JsonBackReference
//	@JoinColumn(name = "request_id")
//	private RequestForm requests; 
    
    public Assets() {
    	
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

	public Integer getAssetQuantity() {
		return assetQuantity;
	}

	public void setAssetQuantity(Integer assetQuantity) {
		this.assetQuantity = assetQuantity;
	}

	public Double getAssetCost() {
		return assetCost;
	}

	public void setAssetCost(Double assetCost) {
		this.assetCost = assetCost;
	}

	public String getAssetDetails() {
		return assetDetails;
	}

	public void setAssetDetails(String assetDetails) {
		this.assetDetails = assetDetails;
	}

	public UsersInfo getUserbean() {
		return userbean;
	}

	public void setUserbean(UsersInfo userbean) {
		this.userbean = userbean;
	}

	@Override
	public String toString() {
		return "Assets [assetID=" + assetID + ", assetName=" + assetName + ", assetCategory=" + assetCategory
				+ ", imgUrl=" + imgUrl + ", assetQuantity=" + assetQuantity + ", assetCost=" + assetCost
				+ ", assetDetails=" + assetDetails + ", userbean=" + userbean + "]";
	}

	
    
}
