package com.khalej.magsala_admin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khalej.magsala_admin.R;

public class MainActivity extends AppCompatActivity {
Button add_annonce ,delete_annonce,DeleteCategory,AddCategory,delete_modir,add_modir,monitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_annonce=findViewById(R.id.add_annonce);
        delete_annonce=findViewById(R.id.delete_annonce);
        AddCategory=findViewById(R.id.AddCategory);
        DeleteCategory=findViewById(R.id.DeleteCategory);
        delete_modir=findViewById(R.id.delete_modir);
        add_modir=findViewById(R.id.add_modir);
        monitor=findViewById(R.id.monitor);
        add_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,Add_annonce.class));
            }
        });
        delete_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_annonce.class));

            }
        });
        AddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_category.class));

            }
        });
        DeleteCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_category.class));

            }
        });
        add_modir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_Mwasel.class));

            }
        });
        delete_modir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_porvider.class));

            }
        });
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Monitor_provider.class));
            }
        });
    }
}
