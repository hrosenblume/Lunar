package com.example.android.animationsdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Venue {
	String name, category,street,city,state,country,zip,contact,mon_open,mon_close;
	Bitmap image;
	String tue_open,tue_close,wed_open,wed_close,thur_open,thur_close,fri_open,fri_close,sat_open,sat_close,sun_open,sun_close;
	int popularity,likes;
	public Venue(String name, String category, String street, String city, String state,String country, String zip, String contact,String image,int popularity,int likes, String mon_open,String mon_close,String tue_open,String tue_close,String wed_open,String wed_close,String thur_open,String thur_close,String fri_open,String fri_close,String sat_open,String sat_close,String sun_open,String sun_close){
		this.name = name;
		this.category = category;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.contact = contact;
		Bitmap bitmap = decodeFile(new File(image));
		this.image =bitmap;
		this.mon_open = mon_open;
		this.mon_close = mon_close;
		this.tue_open = tue_open;
		this.tue_close = tue_close;
		this.wed_open = wed_open;
		this.wed_close = wed_close;
		this.thur_open = thur_open;
		this.thur_close = thur_close;
		this.fri_open = fri_open;
		this.fri_close = fri_close;
		this.sat_open = sat_open;
		this.sat_close = sat_close;
		this.sun_open = sun_open;
		this.sun_close = sun_close;
		
	}
	
	private Bitmap decodeFile(File f){
	    try {
	        //Decode image size
	        BitmapFactory.Options o = new BitmapFactory.Options();
	        o.inJustDecodeBounds = true;
	        BitmapFactory.decodeStream(new FileInputStream(f),null,o);

	        //The new size we want to scale to
	        final int REQUIRED_SIZE=130;

	        //Find the correct scale value. It should be the power of 2.
	        int scale=1;
	        while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
	            scale*=2;

	        //Decode with inSampleSize
	        BitmapFactory.Options o2 = new BitmapFactory.Options();
	        o2.inSampleSize=scale;
	        return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
	    } catch (FileNotFoundException e) {}
	    return null;
	}
	
	

}
