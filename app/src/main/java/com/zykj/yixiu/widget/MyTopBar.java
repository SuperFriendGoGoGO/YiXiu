package com.zykj.yixiu.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zykj.yixiu.R;


/**
 * Created by zykj on 2017/4/11.
 */

public class MyTopBar extends RelativeLayout {
    private String leftSrc;
    private Drawable leftdown;
    private Drawable rightBG;
    private String titleText;
    private int textColor;


    private TextView title;
    private ImageView right;
    private TextView  left;

    public MyTopBar(Context context) {
        super(context);
    }

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取自定义属性
   TypedArray td = context.obtainStyledAttributes(attrs, R.styleable.MyTopBar);

        // 获取属性
        leftdown=td.getDrawable(R.styleable.MyTopBar_leftdown);
        titleText = td.getString(R.styleable.MyTopBar_titleText);
        rightBG = td.getDrawable(R.styleable.MyTopBar_rightBG);
        leftSrc = td.getString(R.styleable.MyTopBar_leftSrc);
        textColor = td.getColor(R.styleable.MyTopBar_textColor, Color.parseColor("#7fe4e4"));

        //创建控件
        title = new TextView(context);
        right = new ImageView(context);
        left = new TextView(context);

        //把所有属性设置到对应控件上
        //title
        title.setText(titleText);
        title.setTextSize(22.00f);
        title.setTextColor(textColor);
        title.setGravity(CENTER_VERTICAL);
        //right

      right.setImageDrawable(rightBG);
        //left
        left.setText(leftSrc);
        left.setGravity(CENTER_VERTICAL);
        left.setBackgroundDrawable(leftdown);
        left.setTextColor(Color.parseColor("#00cccc"));
        //加入并设置控件位置
        LayoutParams titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT); //中间位置
        addView(title, titleParams);
//
        LayoutParams leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(ALIGN_PARENT_LEFT); //左侧位置
        addView(left, leftParams);

        LayoutParams rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(ALIGN_PARENT_RIGHT); //右侧位置
        rightParams.addRule(CENTER_VERTICAL); //右侧位置
        addView(right, rightParams);


    }
    public String getTitleText(){
        title.getText();
        return null;
    }

    public   void setTitleText(String  titleText){
        title.setText(titleText);
    }
    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
