package com.example.toastviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.graphics.Color.WHITE;

public class MainActivity extends Activity {

    private ToastUtil toastUtil;
    private Button mDefault;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
    }

    /**
     * 初始化控件
     */
    private void initButtons() {
        mDefault = (Button) findViewById(R.id.defaultToast);
        mButton1 = (Button) findViewById(R.id.bt1);
        mButton2 = (Button) findViewById(R.id.bt2);
        mButton3 = (Button) findViewById(R.id.bt3);
        mButton4 = (Button) findViewById(R.id.bt4);
       mImageView = (ImageView) findViewById(R.id.iv);
    }



    public void defaultToast(View v) {
        Toast.makeText(this, "defaultToast", Toast.LENGTH_SHORT).show();
    }

    /**
     * 修改Toast背景色的使用法方法如下：
     *
     * @param v
     */
    public void changeBackGroundColor(View v) {

        toastUtil = new ToastUtil();
        toastUtil.Short(MainActivity.this, "自定义message字体、背景色")
                .setToastColor(WHITE, getResources().getColor(R.color.colorAccent)).show();
    }

    /**
     * 方形的Toast看上去有些呆板，我自定义了一个名为toast_radius.xml的背景
     * <p>
     * 然后设置背景的代码改成:
     */
    public void DIYToast(View v) {
        toastUtil.Short(MainActivity.this, "自定义message字体颜色和背景")
                .setToastBackground(WHITE, R.drawable.toast_radius).show();
    }

    /**
     * 向Toast中添加图标可以这样
     *
     * @param v
     */
    public void ToastWithPic(View v) {
        ImageView toastImage = new ImageView(getApplicationContext());
        toastImage.setImageResource(R.mipmap.ic_launcher);

        toastUtil.Short(MainActivity.this, "向Toast添加了一个ImageView")
                .setToastBackground(Color.WHITE, R.drawable.toast_radius)
                .addView(toastImage, 0).show();
    }

    /**
     * Toast显示自定义的布局
     *
     * @param v
     */
    public void DIYLayout(View v) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_image, null);
        new ToastUtil(MainActivity.this, view, Toast.LENGTH_SHORT).show();
    }

}
