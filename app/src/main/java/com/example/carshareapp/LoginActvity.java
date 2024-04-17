package com.example.carshareapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.Toast;

public class LoginActvity extends AppCompatActivity {
    private static final String LOG ="LoginActvity";
    private  CheckBox checkBox;
    private Spinner carSpinner;
    private EditText username;
    private EditText password;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvity2);
        checkBox = findViewById(R.id.checkBoxAgreement);
        carSpinner = findViewById(R.id.carSpinner);
        username = findViewById(R.id.usernameID);
        Log.d(LOG,"username::::"+username.toString());
        password = findViewById(R.id.passwordID);
        register = findViewById(R.id.btnClick);
        ArrayAdapter<CharSequence> arrayAdapter =
                ArrayAdapter.createFromResource
                        (this,R.array.login_array,
                        android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_item);
        carSpinner.setAdapter(arrayAdapter);
        showAgreementDialog(checkBox);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(v);
            }
        });
        Log.d(LOG,"Activity is created!");
    }
    private void register(View view){
    String login = username.getText().toString();
    String login_pass = password.getText().toString();
    String selectedLogin = carSpinner.getSelectedItem().toString();

    if (login.isEmpty() || login_pass.isEmpty()){
        showToast("Введите логин и пароль!");
        Log.d(LOG,"Попытка регестрации с пустым логином или паролем!");
    }else {
        Intent intent = new Intent(this, MenuActvity.class);
        intent.putExtra("username",login);
        startActivity(intent);
        finish();
        showToast("Успешно зарегистрирован и выбрана модель регестрации"+ selectedLogin);
    }
    }
    private void  showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    public void showAgreementDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Terms and Conditions")
                .setMessage("These terms and conditions of using mobile app")
                .setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkBox.setChecked(true);
                    }
                })
                .setNegativeButton("Disagree", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkBox.setChecked(false);
                    }
                })
                .setCancelable(false)
                .show();

    }
}