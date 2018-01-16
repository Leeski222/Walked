package cn.nju.lee.walked.view.map.direction;

import android.content.Context;
import android.util.Log;



/**
 * Created by 果宝 on 2018/1/17.
 */

public class MyDirectionSensor implements OrientationSensorInterface {

    private float direction;

    private Orientation orientationSensor;

    public MyDirectionSensor(Context context) {
        orientationSensor = new Orientation(context, this);
        initSensor();
    }

    private void initSensor() {
        // set tolerance for any directions
        orientationSensor.init(1.0, 1.0, 1.0);
    }

    public void startSensor() {
        // set output speed and turn initialized sensor on
        // 0 Normal
        // 1 UI
        // 2 GAME
        // 3 FASTEST
        orientationSensor.on(0);
    }

    public void stopSensor() {
        orientationSensor.off();
    }

    /**
     * 根据实时接受的参数计算出用户当前的方位角
     * @param AZIMUTH
     * @param PITCH
     * @param ROLL
     */
    @Override
    public void orientation(Double AZIMUTH, Double PITCH, Double ROLL) {
        Log.d("Azimuth",String.valueOf(AZIMUTH));
        Log.d("PITCH",String.valueOf(PITCH));
        Log.d("ROLL",String.valueOf(ROLL));
        direction = AZIMUTH.floatValue();
    }

    public float getDirection() {
        return direction;
    }
}
