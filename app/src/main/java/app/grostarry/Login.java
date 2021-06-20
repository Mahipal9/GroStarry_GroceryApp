package app.grostarry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPass;
    Button btnLogin;
    private FirebaseAuth mAuth;

    TextView gotoRegister;
    ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*temp storage of user*/

        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPhonePref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit  = sharedPreferences.edit();
        myEdit.putString("phone","8805803087");
        myEdit.commit();

        txtEmail = findViewById(R.id.txt_email);
        txtPass = findViewById(R.id.txt_pass);
        btnLogin = findViewById(R.id.btn_login);

        mProgress=new ProgressDialog(this);
        mProgress.setCanceledOnTouchOutside(false);
        mProgress.setMessage("Please Wait...");

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user1 = mAuth.getCurrentUser();
        if(user1!=null)
        {
            Intent i = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(i);
        }

        gotoRegister = findViewById(R.id.goto_register);
        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();
                final String email = txtEmail.getText().toString();
                String password = txtPass.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();

//                                    // Storing data into SharedPreferences
//                                    SharedPreferences sharedPreferences = getSharedPreferences("MyPhonePref", MODE_PRIVATE);
//                                    SharedPreferences.Editor myEdit  = sharedPreferences.edit();
//                                    myEdit.putString("phone","8805803087");
//                                    myEdit.commit();

                                    Toast.makeText(Login.this, "Authentication Successful.",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),Dashboard.class);
                                    startActivity(i);

                                }
                                else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Login.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                                }
                                mProgress.dismiss();


                            }
                });

            }
        });

    }
}
