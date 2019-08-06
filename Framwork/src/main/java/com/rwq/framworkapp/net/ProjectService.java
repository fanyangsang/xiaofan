package com.rwq.framworkapp.net;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 类作用：
 * Created by fy on 2019/6/22.
 */

public interface ProjectService {
    //登录接口
    @POST("doctor/doctorLogin")
    @FormUrlEncoded
    Observable<ResponseBody>login(@FieldMap Map<String, String>map);

    //获取融云Token
    @POST("rong/getRongTooken")
    @FormUrlEncoded
    Observable<ResponseBody>getRongToken(@FieldMap Map<String,String>map);

    //获取患者信息
    @POST("patient/selPatientMsg")
    @FormUrlEncoded
    Observable<ResponseBody>getPatientInformation(@FieldMap Map<String,String>map);
}
