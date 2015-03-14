package com.example.sensors;

import java.io.IOException;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


@SuppressLint("NewApi")
public class MainActivity extends Activity implements SensorEventListener{
	private  View  view;
	public Sensor sensor;
	public SensorManager SensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view =findViewById(R.id.textView1);
		view.setBackground(getWallpaper());
		Toast.makeText(MainActivity.this, "Shake the phone", Toast.LENGTH_SHORT).show();
		SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		 sensor = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		 
		
		
	}

	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
		{
			getAccelerometer(event);
		
		}
	}

	public void getAccelerometer(SensorEvent event) {
		float[] values =event.values;
		float x = values[0];
		float y =  values[1];
		float z = values[2];
		float Accsqroot = (x*x + y*y + z*z) /
				(android.hardware.SensorManager.GRAVITY_EARTH * android.hardware.SensorManager.GRAVITY_EARTH);
		
		WallpaperManager mywall = WallpaperManager.getInstance(getApplicationContext());
			if(Accsqroot > 2)
			{
				
				try{
				
				Random rg = new Random();
	int z1 = rg.nextInt()%11;
		 switch(z1)
		 {
		 
		 case 1:	
			 mywall.setResource(R.drawable.w11);
			 view.setBackgroundResource(R.drawable.w11);
		 break;
		 case 2:
			 mywall.setResource(R.drawable.w22);
			 view.setBackgroundResource(R.drawable.w22);
		 break;
		 case 3:
			 mywall.setResource(R.drawable.w33);
			 view.setBackgroundResource(R.drawable.w33);
		 break;
		 case 4:
			 mywall.setResource(R.drawable.w44);
			 view.setBackgroundResource(R.drawable.w44);
		 break;
		 case 5:
			 mywall.setResource(R.drawable.w55);
			 view.setBackgroundResource(R.drawable.w55);
		 break;
		 case 6:
			 mywall.setResource(R.drawable.w66);
			 view.setBackgroundResource(R.drawable.w66);
		 break;
		 case 7:
			 mywall.setResource(R.drawable.w77);
			 view.setBackgroundResource(R.drawable.w77);
			 
		 break;
		 case 8:
			 mywall.setResource(R.drawable.w88);
			 view.setBackgroundResource(R.drawable.w88);
		 break;
		 case 9:
			 mywall.setResource(R.drawable.w99);
			 view.setBackgroundResource(R.drawable.w99);
		 break;
		 case 10:
			 mywall.setResource(R.drawable.w10);
			 
		 view.setBackgroundResource(R.drawable.w10);
		 break;	
		 }
		 
	}
		catch (IOException e) {
			
			Toast.makeText(MainActivity.this, "error setting wallpaper", Toast.LENGTH_SHORT).show();
		}
				}
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
		
	}
		
			  @Override
			  protected void onResume() {
			    super.onResume();
			    // register this class as a listener for the orientation and
			    // accelerometer sensors
			    SensorManager.registerListener(this,
			        SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
			        android.hardware.SensorManager.SENSOR_DELAY_NORMAL);
			  }

			  @Override
			  protected  void onPause() {
			    // unregister listener
			    super.onPause();
			    SensorManager.unregisterListener(this);
			  }
			

}