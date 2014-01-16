/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.animationsdemo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.android.animationsdemo.R;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;

/**
 * The launchpad activity for this sample project. This activity launches other activities that
 * demonstrate implementations of common animations.
 */
public class MainActivity extends Activity {
	private ArrayList<Venue> venues = new ArrayList<Venue>();
    /**
     * This class describes an individual sample (the sample title, and the activity class that
     * demonstrates this sample).
     */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.moon_outer);
        ImageView image2 = (ImageView) findViewById(R.id.logo);
        ImageView image3 = (ImageView) findViewById(R.id.text);
        
        
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                	double windowWidth = getWindow().getDecorView().getWidth();
                	double windowHeight = getWindow().getDecorView().getHeight();
                	float xDensity = event.getX();
                	double x = (xDensity / windowWidth) * 100;
                	float yDensity = event.getY();
                	double y = (yDensity / windowHeight) * 100;
            		 if(x > 35 && x < 68 && y >55 && y < 75 ){
                	startActivity(new Intent(MainActivity.this, ScreenSlideActivity.class));
      			  	overridePendingTransition(R.animator.left_in,R.animator.card_flip_right_out); 
      			  }
                }
                return true;
            }
        });
        
        
    }
    
    public ArrayList<Venue> getType(int input){
    	if(input==1 || input==2){
    		try {
				getEvents();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		MoodEvents mood = new MoodEvents(venues);
    		return mood.getBars();
    	}
    	else{
    		return venues;
    	}
    }
    
    public void getEvents() throws JSONException {
    	String[] types = {"bars","clubs","lounges","restaurants"};
    	for(int i=0;i<types.length;i++){
        LunaRestClient.get(types[i], null, new JsonHttpResponseHandler() {
        	
            @Override
            public void onSuccess(JSONArray events) {
            	
                // Pull out the first event on the public timeline
                JSONObject event=null;
               
               
					try {
						
						venues = new ArrayList<Venue>();
						for (int i=0;i<events.length();i++){
							event = (JSONObject) events.get(i);
							venues.add(new Venue(event.getString("name"),event.getString("category"),event.getString("street"),event.getString("city"),event.getString("state"),event.getString("country"),event.getString("zip"),event.getString("contact"),event.getString("image"),event.getInt("popularity"),event.getInt("likes"),event.getString("mon_open"),event.getString("mon_close"),event.getString("tue_open"),event.getString("tue_close"),event.getString("wed_open"),event.getString("wed_close"),event.getString("thur_open"),event.getString("thur_close"),event.getString("fri_open"),event.getString("fri_close"),event.getString("sat_open"),event.getString("sat_close"),event.getString("sun_open"),event.getString("sun_close")));
							
							

						}
						
						
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
                
              
                
            }
        });
        
    	}
    }
   
    /*
    public boolean onTouchEvent(MotionEvent event){
    	double windowWidth = getWindow().getDecorView().getWidth();
    	double windowHeight = getWindow().getDecorView().getHeight();
    	float xDensity = event.getX();
    	double x = (xDensity / windowWidth) * 100;
    	float yDensity = event.getY();
    	double y = (yDensity / windowHeight) * 100;
		  if(x > 35 && x < 68 && y >55 && y < 75 ){
			  startActivity(new Intent(MainActivity.this, ScreenSlideActivity.class));
			  overridePendingTransition(R.animator.left_in,R.animator.card_flip_right_out); 
		  }
    	 return true;
	  }
    */
    
}
