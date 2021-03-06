package com.example.braca.muffinapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import objects.User;


public class AddContact extends AppCompatActivity {

    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        dbReference = FirebaseDatabase.getInstance().getReference();
        //first step to get all the element from the view
        final EditText name = findViewById(R.id.textBox_Name);
        final EditText lastName = findViewById(R.id.textBox_lastName);
        final EditText cellphone = findViewById(R.id.textBox_cellphone);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("Name")){
                    name.setText("");
                }
            }
        });

        lastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastName.getText().toString().equals("Last Name")){
                    lastName.setText("");
                }
            }
        });

        cellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cellphone.getText().toString().equals("Cellphone")){
                    cellphone.setText("");
                }
            }
        });

        Button goSave = findViewById(R.id.btn_save);

        goSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo must have authentication PR first in this case will be just write over users

                //second step to get the actual data from the elements
                String nameString = name.getText().toString().trim();
                String lastNameString = lastName.getText().toString().trim();
                String cellphoneString = cellphone.getText().toString().trim();
                User user = new User(nameString, lastNameString, cellphoneString);

                dbReference.child(user.getId());
                dbReference.push().setValue(user);
            }
        });
    }
}
