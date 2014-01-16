package com.example.android.animationsdemo;

import java.util.ArrayList;

public class MoodEvents {
	ArrayList<Venue> venues;
	public MoodEvents(ArrayList<Venue> venues){
	this.venues = venues;
	}
	
	
	ArrayList<Venue> getBars(){
		ArrayList<Venue> bars = new ArrayList<Venue>();
		for(int i=0;i<venues.size();i++){
			if(venues.get(i).category == "Bar"){
				bars.add(venues.get(i));
			}
		}
		return bars;
	}
	
	ArrayList<Venue> getClubs(){
		ArrayList<Venue> clubs = new ArrayList<Venue>();
		for(int i=0;i<venues.size();i++){
			if(venues.get(i).category == "Club"){
				clubs.add(venues.get(i));
			}
		}
		return clubs;
	}
	
	ArrayList<Venue> getLounges(){
		ArrayList<Venue> lounges = new ArrayList<Venue>();
		for(int i=0;i<venues.size();i++){
			if(venues.get(i).category == "Lounge"){
				lounges.add(venues.get(i));
			}
		}
		return lounges;
	}
	
	ArrayList<Venue> getRestaurants(){
		ArrayList<Venue> restaurants = new ArrayList<Venue>();
		for(int i=0;i<venues.size();i++){
			if(venues.get(i).category == "Restaurant"){
				restaurants.add(venues.get(i));
			}
		}
		return restaurants;
	}

}
