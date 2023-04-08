package com.example.ruletarusa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button play = (Button) findViewById(R.id.play);
        Button exit = (Button) findViewById(R.id.exit);

        play.setOnClickListener(view -> {
            Intent intent = new Intent(End.this, Ruleta.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        exit.setOnClickListener(view -> finish());



    }
}