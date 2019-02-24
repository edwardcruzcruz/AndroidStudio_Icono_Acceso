package com.example.edward.samplegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


    }
    /** Called when the user taps the Send button */
    public void autenticacion(View view) {
        // Do something in response to button
        EditText User = (EditText) findViewById(R.id.editTextUser);
        EditText Password = (EditText) findViewById(R.id.editTextPassword);
        if(User.getText().toString().equals("etcruz") && Password.getText().toString().equals("etcruz")){

            //correcct password
            //Toast.makeText(getApplicationContext(),
            //"Redirecting...",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
        }else{
            //wrong password
            System.out.println("Error");
        }
    }
}
