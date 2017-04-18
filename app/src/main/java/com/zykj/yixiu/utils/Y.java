package com.zykj.yixiu.utils;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by zykj on 2017/4/18.
 */

public class Y {
    public static Context context;
    public  static  boolean isLog=true;


    public static  void t(String  str){//吐司
        Toast.makeText(context,str, Toast.LENGTH_LONG).show();
    }
    public static  void l(String  str){   //log日志
        if(isLog)
            Logger.i(str);
    }
    public  static  boolean getRespCode(String  result){//检测请求返回的数据是否正确
        if("0".equals(JSON.parseObject(result).getString("resp_code"))){
            return true;
        }else{
            return false;
        }
    }
    public static String getData(String  result){//成功获取数据
        return JSON.parseObject(result).getString("data");
    }
    public static Callback.Cancelable post(RequestParams params, MyCommonCall<String> call){
        return   x.http().post(params, call);
    }
    public abstract  static class  MyCommonCall<String> implements Callback.CommonCallback<String>{ //减少代码的复用性
        @Override
        public void onFinished() {}

        @Override
        public void onCancelled(CancelledException cex) {}

        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            t("服务器异常");
            ex.printStackTrace();
        }
    }

}
