package com.abt.leak;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @描述： @MatActivity
 * @作者： @黄卫旗
 * @创建时间： @25/06/2018
 */
public class MatActivity extends Activity {

    private static final String TAG = MatActivity.class.getSimpleName();

    private static Context sContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        sContext = this;
    }

}
