package com.example.braca.muffinapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.HashMap;

import objects.User;

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
        String nameString = Name.getText().toString().trim();
        String lastnameString = Lastname.getText().toString().trim();
        Integer cellphoneInt =Integer.parseInt( cellphone.getText().toString().trim());

        //second step bis? to get the button and define the listener
        Button goSave = (Button) findViewById(R.id.btn_save);

        final User firtU = new User(nameString , lastnameString , cellphoneInt);

        //third step define the reference to db (the root of the json doc)
        dbReference = FirebaseDatabase.getInstance().getReference();

        goSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //steps to store in the data base
                //1- create a child  in the root object (remember to show the json from firebase)
                //todo check if this workaround works on db
                dbReference.child(firtU.getUserId().toString());//create a unique child for each time
               //dbReference.push().child(firtU.getUserId().toString());


                HashMap<String, String> datamap = new HashMap<String, String>();
                datamap.put("FirstName",firtU.getFirstName());
                datamap.put("LastName",firtU.getLastName());
                datamap.put("PhoneNumer",firtU.getCellphone().toString());
                //2- assign the values to store

                //todo test the  firstU as object
                dbReference.push().setValue(datamap);//I must try set the object as value
            }
        });




    }


}
