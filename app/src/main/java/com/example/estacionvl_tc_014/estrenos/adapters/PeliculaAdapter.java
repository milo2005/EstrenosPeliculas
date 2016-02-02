package com.example.estacionvl_tc_014.estrenos.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estacionvl_tc_014.estrenos.R;
import com.example.estacionvl_tc_014.estrenos.models.Pelicula;

import java.util.List;

/**
 * Created by EstacionVL-TC-014 on 2/02/16.
 */
public class PeliculaAdapter extends BaseAdapter{

    Activity activity;
    List<Pelicula> data;

    public PeliculaAdapter(Activity activity, List<Pelicula> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null)
            v = View.inflate(activity
                    , R.layout.template_list, null);

        Pelicula p = data.get(position);

        TextView title = (TextView)
                v.findViewById(R.id.title);

        title.setText(p.getTitulo());

        TextView score = (TextView) v
                .findViewById(R.id.txt_score);
        score.setText(""+p.getCalificacion());



        return v;
    }
}
