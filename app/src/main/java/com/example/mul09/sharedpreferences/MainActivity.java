package com.example.mul09.sharedpreferences;

import java.util.HashMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    // Session Manager Class
    SessionManager session;
    SessionSubmit submit;
    // Button Logout
    Button btnLogout;
    Button btnSubmit;
    EditText etNama ;
    EditText etNIM ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Session class instance
        session = new SessionManager(getApplicationContext());
        TextView lblName = (TextView) findViewById(R.id.lblNama);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        EditText etNama = (EditText) findViewById(R.id.etNama);
        EditText etNIM = (EditText) findViewById(R.id.etNIIM);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

// Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
// Cek User apakah sudah login
        session.checkLogin();
// Mendapatkan data user dari session
        HashMap<String, String> user = session.getUserDetails();
// nama
        String name = user.get(SessionManager.KEY_NAME);
// email
        String email = user.get(SessionManager.KEY_EMAIL);
// menampilkan user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
/**
 * Logout button click event
 * */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// menghapus session data
// dan mengarahakan ke LoginActivity
                session.logoutUser();
                finish();
            }
        });
    }
}
