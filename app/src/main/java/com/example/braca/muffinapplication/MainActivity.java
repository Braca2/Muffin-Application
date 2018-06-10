package com.example.braca.muffinapplication;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private StorageReference mStorageRef;
    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo must have authentification PR first in this case will be just write over users

        //firt setp to get all the element from the view
        EditText Name = (EditText) findViewById(R.id.textBox_Name);
        EditText Lastname = (EditText) findViewById(R.id.textBox_lastName);
        EditText cellphone = (EditText) findViewById(R.id.textBox_cellphone);

        //second step to get the actual data from the elements
        String nameString = Name.getText().toString();
        String lastnameString = Name.getText().toString();
        String cellphoneString = Name.getText().toString();

        //second step bis? to get the button and define the listener
        Button goSave = (Button) findViewById(R.id.btn_save);

        //third step define the reference to db (the root of the json doc)
        dbReference = FirebaseDatabase.getInstance().getReference();

        goSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }


}
