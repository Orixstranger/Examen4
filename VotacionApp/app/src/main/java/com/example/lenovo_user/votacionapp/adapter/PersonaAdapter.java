package com.example.lenovo_user.votacionapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.lenovo_user.votacionapp.R;
import com.example.lenovo_user.votacionapp.modelo.Persona;

import java.util.ArrayList;

public class PersonaAdapter extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> listaPersonas;

    public PersonaAdapter(Context contexto, ArrayList<Persona> listaPersonas) {
        this.contexto = contexto;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = View.inflate(contexto,R.layout.display_personas,null);
        TextView textCedula = (TextView) convertView.findViewById(R.id.lblCedula);
        TextView textNombre = (TextView) convertView.findViewById(R.id.lblNombre);

        Persona persona= listaPersonas.get(position);
        textCedula.setText(persona.getCedula());
        textNombre.setText(persona.getNombre());

        return convertView;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaProductos(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}
