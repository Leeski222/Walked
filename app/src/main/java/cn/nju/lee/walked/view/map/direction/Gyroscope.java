package cn.nju.lee.walked.view.map.direction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Observable;


/**
 * Created with IntelliJ IDEA.
 * User: Majid Golshadi
 * Date: ic_create/ic_multifab/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Gyroscope extends Observable implements SensorEventListener,Isensor {

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;

    private SensorEvent event;

    public Gyroscope(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }
    
    @Override
    public boolean isSupport(){
    	if (gyroscopeSensor == null)
    		return false;
    	
    	return true;
    }

    @Override
    public void on(int speed){
    	switch (speed) {
		case 0:
			sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
			break;

		case 1:
			sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_UI);
			break;

		case 2:
			sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_GAME);
			break;

		case 3:
			sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
			break;
			
		default:
			sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
			break;
		}
    }

    @Override
    public void off(){
        sensorManager.unregisterListener(this, gyroscopeSensor);
    }

    @Override
    public float getMaximumRange()
    {
        return gyroscopeSensor.getMaximumRange();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        event = sensorEvent;

        setChanged();
        notifyObservers();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public SensorEvent getEvent(){
        return event;
    }


}
