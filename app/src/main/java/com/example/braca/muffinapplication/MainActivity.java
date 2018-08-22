package com.example.braca.muffinapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goSave = findViewById(R.id.btn_save);


        Button btnAdd = findViewById(R.id.btnAddContact);
        Button btnList = findViewById(R.id.btnContactList);

    }

    public void goAdd(View view){
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }
    public void goList(View view){
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }
}
