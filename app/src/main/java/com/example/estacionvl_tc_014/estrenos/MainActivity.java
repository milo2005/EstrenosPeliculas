package com.example.estacionvl_tc_014.estrenos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.estacionvl_tc_014.estrenos.adapters.PeliculaAdapter;
import com.example.estacionvl_tc_014.estrenos.models.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    PeliculaAdapter adapter;
    List<Pelicula> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        data = new ArrayList<>();
        adapter =  new PeliculaAdapter(this, data);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
        cargarPeliculas();

    }

    public void cargarPeliculas(){
        Pelicula p = new Pelicula();
        p.setCalificacion(3.5f);
        p.setDuracion("160");
        p.setTitulo("Deadpool");
        p.setUrl("http://cdn.movieweb.com/img.site/PHI6pg1OTJj5LO_1_l.jpg");

        Pelicula p1 = new Pelicula();
        p1.setTitulo("Batman v Superman");
        p1.setDuracion("180");
        p1.setCalificacion(5.0f);
        p1.setUrl("http://cinelium.com/wp-content/uploads/2015/05/cinelium-batman-v-superman-poster-1024x640.jpeg");

        Pelicula p2 = new Pelicula();
        p2.setTitulo("Warcraft");
        p2.setDuracion("160");
        p2.setCalificacion(4.5f);
        p2.setUrl("http://cdn4.dualshockers.com/wp-content/uploads/2015/11/warcraft-movie-poster-trailer.jpg");

        data.add(p);
        data.add(p1);
        data.add(p2);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this
                , SegundaPantallaActivity.class);

        intent.putExtra("nombre",data.get(position)
                .getTitulo());

        startActivity(intent);

    }
}
