package com.example.ruletarusa;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Ruleta extends AppCompatActivity {

    private int posicionBalaActual;
    private int posicionBala;
    private ImageView boom, gucci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button shoot = (Button) findViewById(R.id.shoot);
        boom = (ImageView) findViewById(R.id.boom);
        gucci = (ImageView) findViewById(R.id.gucci);

        boom.setVisibility(View.INVISIBLE);
        gucci.setVisibility(View.INVISIBLE);

        revolver();

        shoot.setOnClickListener(view -> {

            boom.setVisibility(View.INVISIBLE);
            gucci.setVisibility(View.INVISIBLE);

            AlertDialog.Builder dialogo = new AlertDialog.Builder(Ruleta.this);
            dialogo.setMessage("Posicion actual del tambor: " + posicionBalaActual)
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());

            System.out.println("Posicion actual del tambor: " + posicionBalaActual + "\nPosicion de la bala en el tambor: " + posicionBala);

            dialogo.show();

            if(shoot()){
                boom.setVisibility(View.VISIBLE);

                final Timer t = new Timer ();
                t.schedule(new TimerTask() {
                    @Override
                    public void run () {
                        Intent intent = new Intent(Ruleta.this, End.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);


            } else {
                gucci.setVisibility(View.VISIBLE);
            }
        });

    }

    public void revolver(){
        posicionBala = random(1, 6);
        posicionBalaActual = random(1, 6);
    }

    public boolean shoot(){

        boolean exito = posicionBalaActual == posicionBala;


        siguienteHuecoTambor();

        return exito;
    }

    public void siguienteHuecoTambor(){

        if(posicionBalaActual == 6){
            posicionBalaActual = 1;
        } else {
            posicionBalaActual ++;
        }
    }

    public static int random(int min, int max){
        return (int) Math.floor(Math.random() * (max - min + 1) + (min));
    }

}