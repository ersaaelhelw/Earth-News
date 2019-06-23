package com.example.manara.capstone_stage2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    DatabaseReference databaseReference;
    EditText name,password;
    Users users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button button ;
        button= findViewById(R.id.register2);
        name=findViewById(R.id.name2);
        password = findViewById(R.id.password2);
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference().child(getString(R.string.users));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child(name.getText().toString()).setValue(new Users(name.getText().toString(),password.getText().toString()));
                Toast.makeText(Register.this,"DONE", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
