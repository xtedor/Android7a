package com.example.carrito;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    EditText name, cant;
    Button btn, add;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lv1);
        name=findViewById(R.id.name);
        cant=findViewById(R.id.cantidad);
        btn=findViewById(R.id.add);
        add=findViewById(R.id.buy);

        final  ArrayList<Productos> listaNombres= new ArrayList<Productos>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd=name.getText().toString().trim();
                String canti=cant.getText().toString().trim();
                listaNombres.add(new Productos(nameProd,canti));

                ArrayAdapter<Productos> adaptador = new ArrayAdapter<Productos>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,listaNombres);
                lista.setAdapter(adaptador);
                if (name.getText().toString().trim().equalsIgnoreCase(""))
                    name.setError("This field can not be empty");
                if (cant.getText().toString().trim().equalsIgnoreCase(""))
                    cant.setError("This field can not be empty");
                name.setText("");
                cant.setText("");


            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaNombres.clear();
                Toast toast2 =Toast.makeText(getApplicationContext(),
                        "Purchased item", Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                toast2.show();
                lista.setAdapter(null);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
