package com.paperfly.scanbarcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static TextView resultTV;
    Button scan,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan = findViewById(R.id.scanBtn);
        clear = findViewById(R.id.clearResult);
        resultTV = findViewById(R.id.scannedResult);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CodeScannerActivity.class));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearResult();
            }
        });

    }

    private void clearResult() {
        if(resultTV.getText().equals("")){
            Toast.makeText(this, "Nothing to clear", Toast.LENGTH_SHORT).show();
        }
        else{
            resultTV.setText(null);
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
        }
    }
}