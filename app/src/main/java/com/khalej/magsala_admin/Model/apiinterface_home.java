package com.khalej.magsala_admin.Model;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {

    @GET("Magsala_annonce.php")
    Call<List<contact_annonce>> getcontacts_annonce();
    @GET("Magsala_all_first_category.php")
    Call<List<content_category>> getcontacts_allfirst();
    @FormUrlEncoded
    @POST("Magsala_login.php")
    Call<ResponseBody> getcontactsadd(@Field("name") String name,
                                      @Field("phone") String phone, @Field("address") String address);
    @FormUrlEncoded
    @POST("Magsala_login_provider.php")
    Call<List<user_content>>getcontacts_login(@Field("phone") String phonee, @Field("password") String password);
    @FormUrlEncoded
    @POST("Magsala_add_order.php")
    Call<ResponseBody> getcontacts_order(@Field("name") String name, @Field("address") String address,
                                         @Field("phone") String phone,
                                         @Field("details") String details,
                                         @Field("date") String date
    );


    @GET("Magsala_all_neworders.php")
    Call<List<contact_order>> get_all_neworders();
    @FormUrlEncoded
    @POST("Magsala_all_cuurentorders.php")
    Call<List<contact_order>> get_all_cuurent(@Field("id") int id);
    @FormUrlEncoded
    @POST("Magsala_all_oldorders.php")
    Call<List<contact_order>> get_all_old(@Field("id") int id);
    @FormUrlEncoded
    @POST("Magsala_update_status.php")
    Call<ResponseBody> update_status(@Field("provider_id") int provider_id, @Field("provider_name") String provider_name, @Field("id") int id);

    @FormUrlEncoded
    @POST("Magsala_finish_order.php")
    Call<ResponseBody> finish_order(@Field("provider_id") int provider_id, @Field("provider_name") String provider_name,
                                    @Field("id") int id, @Field("price") int price);
    @FormUrlEncoded
    @POST("Magsala_updateLocation_provider.php")
    Call<ResponseBody> update_location(@Field("id") int id, @Field("log") String log,
                                       @Field("lat") String lat, @Field("Date") String Date);
    @FormUrlEncoded
    @POST("Magsala_add_annonce.php") Call<ResponseBody> getcontacts_add_annonce(@Field("image") String image);
    @FormUrlEncoded
    @POST("Magsala_delete_annonce.php")
    Call<ResponseBody> delete_annonce(@Field("id") int id);
    @FormUrlEncoded
    @POST("magsala_add_first_category.php") Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name, @Field("image") String image,@Field("price")int price);
    @FormUrlEncoded
    @POST("Magsala_delete_first_category.php")
    Call<ResponseBody> delete_first(@Field("id") int id);
    @FormUrlEncoded
    @POST("Magsala_add_mwasel.php") Call<ResponseBody> getcontacts_add_mwasel(@Field("name") String name,@Field("phone")int phone,@Field("password") String password);

    @GET("Magsala_all_mwasel.php")
    Call<List<user_content>> getcontacts_provider_acc();
    @FormUrlEncoded
    @POST("Magsala_delete_mwasel.php")
    Call<ResponseBody> accept_provider_delete(@Field("id") int id);
}

