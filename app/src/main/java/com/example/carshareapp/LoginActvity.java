package com.example.carshareapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.Toast;

public class LoginActvity extends AppCompatActivity {
    private  CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvity2);
        checkBox = findViewById(R.id.checkBoxAgreement);
        showAgreementDialog(checkBox);
    }
    private void register(View view){
        if (checkBox.isChecked()){
            Toast.makeText(this,"Успешно зарегестрирован!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Прочитайте документацию",Toast.LENGTH_SHORT).show();
        }
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