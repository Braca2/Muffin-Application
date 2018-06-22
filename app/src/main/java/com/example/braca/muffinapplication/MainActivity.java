package com.example.braca.muffinapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import objects.User;


public class MainActivity extends AppCompatActivity {

    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbReference = FirebaseDatabase.getInstance().getReference();
        //firt setp to get all the element from the view
        final EditText name = findViewById(R.id.textBox_Name);
        final EditText lastName = findViewById(R.id.textBox_lastName);
        final EditText cellphone = findViewById(R.id.textBox_cellphone);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
            }
        });

        lastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastName.setText("");
            }
        });

        cellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cellphone.setText("");
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
                User user = new User(nameString,lastNameString,cellphoneString);

                dbReference.child(user.getId());
                //1- create a child  in the root object (remember to show the json from firebase)
                //todo check if this workaround works on
                HashMap<String, String> datamap = new HashMap<>();
                datamap.put("FirstName",user.getFirstName());
                datamap.put("LastName", user.getLastName());
                datamap.put("PhoneNumber", user.getCellphone());
                //todo test the  firstU as object
                //2- assign the values to store
                dbReference.push().setValue(datamap);
            }
        });




    }


}
