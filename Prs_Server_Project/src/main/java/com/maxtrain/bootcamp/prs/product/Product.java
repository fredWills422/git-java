package com.maxtrain.bootcamp.prs.product;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_vendorId", columnNames= {"vendorId"}))
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=15, nullable=false)
	private int vendorId;
	@Column(length=20, nullable=false)
	private String partNumber;
	@Column(length=20, nullable=false)
	private String name;
	@Column(length=4, nullable=false)
	private double price;
	@Column(length=20, nullable=true)
	private String unit;
	@Column(length=20, nullable=true)
	private String photoPath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	public Product() {}
}
