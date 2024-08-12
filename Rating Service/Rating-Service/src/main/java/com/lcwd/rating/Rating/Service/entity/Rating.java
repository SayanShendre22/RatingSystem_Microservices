package com.lcwd.rating.Rating.Service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("user_rating")
public class Rating {
	
	@Id
	private String ratingID;
	private String userID;
	private String hotelID;
	private int rating;
	private String feedback;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(String ratingID, String userID, String hotelID, int rating, String feedback) {
		this.ratingID = ratingID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.rating = rating;
		this.feedback = feedback;
	}
	public String getRatingID() {
		return ratingID;
	}
	public void setRatingID(String ratingID) {
		this.ratingID = ratingID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
}
