package com.info.demo;

public class Products {
String name ="";
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isCanPurchase() {
	return canPurchase;
}
public void setCanPurchase(boolean canPurchase) {
	this.canPurchase = canPurchase;
}
public Track getTrack() {
	return track;
}
public void setTrack(Track track) {
	this.track = track;
}
String price="";
String description="";
boolean canPurchase=false;
Track track;
Reviews reviews;
public Reviews getReviews() {
	return reviews;
}
public void setReviews(Reviews reviews) {
	this.reviews = reviews;
}
String code="";
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

	
}
