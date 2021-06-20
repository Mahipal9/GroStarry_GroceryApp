package app.grostarry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnSignup;
    EditText txtName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtPhone;
    ProgressDialog mProgress;

    TextView gotoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnSignup = findViewById(R.id.btn_register);
        txtName = findViewById(R.id.txt_fullname);
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        txtPhone = findViewById(R.id.txt_phone);

        mProgress=new ProgressDialog(this);
        mProgress.setCanceledOnTouchOutside(false);
        mProgress.setMessage("Please Wait...");

        mAuth = FirebaseAuth.getInstance();

        gotoLogin = findViewById(R.id.goto_login);
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();

                final String fullname,email,password,phone;

                fullname = txtName.getText().toString();
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();
                phone = txtPhone.getText().toString();




                /*code for authentication starts here*/
                mAuth.createUserWithEmailAndPassword(email,password ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                            User user = new User(fullname, phone,email,password);
                            FirebaseUser userid = mAuth.getCurrentUser();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("users").child(userid.getUid().toString());
                            myRef.setValue(user);
                            Intent i = new Intent(getApplicationContext(),Login.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                        mProgress.dismiss();
                    }
                });
                /*code for authentication ends here*/




            }
        });


    }
}
