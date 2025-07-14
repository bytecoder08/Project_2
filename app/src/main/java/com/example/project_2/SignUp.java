package com.example.project_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
    EditText full_name, Email, password, cnf_password;
    CheckBox Terms_and_Conditions;
    Button btn_create_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup);
        full_name = findViewById(R.id.full_name);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        cnf_password = findViewById(R.id.cnf_password);
        Terms_and_Conditions = findViewById(R.id.Terms_and_Conditions);
        btn_create_acc = findViewById(R.id.btn_create_acc);

        btn_create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = full_name.getText().toString();
                String email= Email.getText().toString();
                String pass = password.getText().toString();
                String cnf_pass = cnf_password.getText().toString();
                boolean terms = Terms_and_Conditions.isChecked();
                if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || cnf_pass.isEmpty() || !terms){

                    Toast.makeText(SignUp.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else if (name.equals("anand") && email.equals("anand@gmail.com") && pass.equals("anand") && cnf_pass.equals(pass)) {
                    Toast.makeText(SignUp.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUp.this, "Login Failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signup), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}