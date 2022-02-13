package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private EditText email;
    private EditText password;
    private Button Login,Logout;
    String Email,Password;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int startColor = getWindow().getStatusBarColor();
            int endColor = ContextCompat.getColor(this,R.color.darker_blue);
            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
        }
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Login=findViewById(R.id.login);
         firebaseAuth=FirebaseAuth.getInstance();




        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = email.getText().toString();
                Password = password.getText().toString();

                String checkEmail = email.getText().toString();
                String checkPass = password.getText().toString();


                if(checkEmail.isEmpty())
                {
                    email.setError("Enter a valid Email");
                    email.requestFocus();
                }

                else if(checkPass.isEmpty())
                {
                    password.setError("Enter a valid password");
                    password.requestFocus();
                }

                else if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent i= new Intent(Login.this,student_dashbord.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }

                else
                {
                    LoginUser();
                }
            }

        });
    }

    private void LoginUser() {

        firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    //Toast.makeText(Login.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                    Intent i= new Intent(Login.this,login_entry.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
                else
                {
                    Toast.makeText((Login.this),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}