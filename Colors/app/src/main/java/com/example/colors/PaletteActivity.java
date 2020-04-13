package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity
      implements SeekBar.OnSeekBarChangeListener {

    private SeekBar vRed = null;
    private SeekBar vGreen = null;
    private SeekBar vBlue = null;
    private SeekBar vAlpha = null;
    private View vFilter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        // variables de la interfaz grafica

        vRed = findViewById(R.id.sbrRed);
        vGreen = findViewById(R.id.sbrGreen);
        vBlue = findViewById(R.id.sbrBlue);
        vAlpha = findViewById(R.id.sbrAlpha);
        vFilter = findViewById(R.id.vieColors);


        vRed.setOnSeekBarChangeListener(this);
        vGreen.setOnSeekBarChangeListener(this);
        vBlue.setOnSeekBarChangeListener(this);
        vAlpha.setOnSeekBarChangeListener(this);





    }
    //""""""""""""" MENUS""""""""""""""""""""
    //Metodo de mostrar menu en el celular

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //acciones del menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            //mueve los seekbar segun el boton que se presione para cambiar el color
            case R.id.iteTranparent:
                vAlpha.setProgress(0);
                //Toast.makeText(this,"this color is going to change",Toast.LENGTH_SHORT);
                break;
            case R.id.iteSemiTrans:
                vAlpha.setProgress(128);
                break;
            case R.id.iteOpaque:
                vAlpha.setProgress(255);
                break;
            case R.id.iteBlack:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                break;
            case R.id.iteWhite:
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteReset:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(0);
                break;
            case R.id.iteAlpha:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(255);
                break;
            case R.id.iteAboutof:
                //va a la activity about of... donde hay info de la aplicacion
                Intent intent=new Intent(this,AboutActivity.class); //instancia del origen al destino
                //comienza la actividad
                startActivity(intent);
                break;
            case R.id.iteBlue:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteCyan:
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteGreen:
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteMagenta:
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteRed:
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteYellow:
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

        //este metodo notifica cuando sel seek bar esta cambiando
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //coger los valores del seekbar
        int r = vRed.getProgress();
        int g = vGreen.getProgress();
        int b = vBlue.getProgress();
        int a = vAlpha.getProgress();

        //convertir los valores del seekbar
        int filtercolor= Color.argb(a,r,g,b); //mandar primero alhpa,red,green,blue en orden
        int filter2 =  Color.argb(vAlpha.getProgress(),vRed.getProgress(),vGreen.getProgress(),vBlue.getProgress()); // otra forma de hacerlo

        //asignar el color a la imagen
        vFilter.setBackgroundColor(filtercolor); //tome la opcion 1 para cmabiar el color del VIEW


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
