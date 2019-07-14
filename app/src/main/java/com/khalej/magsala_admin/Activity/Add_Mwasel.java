package com.khalej.magsala_admin.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.khalej.magsala_admin.Model.Apiclient_home;
import com.khalej.magsala_admin.Model.apiinterface_home;
import com.khalej.magsala_admin.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Mwasel extends AppCompatActivity {
    Intent intent;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayList<Integer> arrayList_id=new ArrayList<>();
    apiinterface_home apiinterface;
    AppCompatButton regesiter;
    private  static final int IMAGE = 100;
    ImageView imageView;
    Toolbar toolbar;
    int category_id;
    Bitmap bitmap;
    ProgressDialog progressDialog;
    Spinner spinner;
    TextInputLayout textInputLayoutdetails,textInputLayoutname,textInputLayoutaddress,textInputLayoutphone;
    TextInputEditText textInputEditTextprice,textInputEditTextname,textInputEditTextpass,textInputEditTextphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__mwasel);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        initializer();
        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );



        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
                regesiter.setClickable(false);
            }
        });
    }
    public void initializer(){

        imageView=(ImageView)findViewById(R.id.image);

        textInputLayoutname=(TextInputLayout)findViewById(R.id.textInputLayoutName);

        textInputEditTextname=(TextInputEditText)findViewById(R.id.textInputEditTextName);
        textInputEditTextprice=findViewById(R.id.textInputEditTextprice);
        textInputEditTextpass=findViewById(R.id.textInputEditTextpass);
        regesiter=(AppCompatButton)findViewById(R.id.appCompatButtonRegister);
    }

    public void fetchInfo(){
        progressDialog = ProgressDialog.show(Add_Mwasel.this,"جارى تسجيل الموصل","Please wait...",false,false);
        progressDialog.show();


        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_mwasel(textInputEditTextname.getText().toString()
                , Integer.parseInt(textInputEditTextprice.getText().toString()),textInputEditTextpass.getText().toString());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Add_Mwasel.this);
                dlgAlert.setMessage("تم تسجيل الموصل بنجاح ");
                dlgAlert.setTitle("نظرة النظافة");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                regesiter.setClickable(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Add_Mwasel.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
