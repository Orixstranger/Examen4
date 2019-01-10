package com.example.lenovo_user.votacionapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo_user.votacionapp.adapter.PersonaAdapter;
import com.example.lenovo_user.votacionapp.helper.HelperPersonaBD;
import com.example.lenovo_user.votacionapp.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    Button botonCrear, botonConsultar;
    EditText cajaCedulaPrincipal;
    HelperPersonaBD helperPersonaBD;
    ListView listView;
    Persona persona;
    ArrayList<Persona> personas;
    List<Persona> listaPersona;
    PersonaAdapter personaAdapter;

    ArrayList<Persona> Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        helperPersonaBD = new HelperPersonaBD(this, "bdpersona",null,1);

        listView = (ListView)findViewById(R.id.listViewPersona);
        mostrarListView();
        listView.setOnItemClickListener(this);

        botonCrear = (Button)findViewById(R.id.btnCrear);
        botonCrear.setOnClickListener(this);
        botonConsultar = (Button)findViewById(R.id.btnConsultar);
        botonConsultar.setOnClickListener(this);
        cajaCedulaPrincipal = (EditText)findViewById(R.id.txtCedulaConsultar);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Dialog dialog = new Dialog(ActividadPrincipal.this);
        dialog.setContentView(R.layout.dlg_presentar);

        Items = obtenerPersonasItem();
        final TextView cajaDialogoCedula = (TextView)dialog.findViewById(R.id.lblCedulaDLG);
        final TextView cajaDialogoNombre = (TextView)dialog.findViewById(R.id.lblNombreDLG);
        final TextView cajaDialogoRecinto = (TextView)dialog.findViewById(R.id.lblRecintoDLG);
        final TextView cajaDialogoJunta = (TextView)dialog.findViewById(R.id.lblJuntaDLG);
        final TextView cajaDialogoDireccion = (TextView)dialog.findViewById(R.id.lblDireccionDLG);
        final TextView cajaDialogoProvincia = (TextView)dialog.findViewById(R.id.lblProvinciaDLG);
        final TextView cajaDialogoCanton= (TextView)dialog.findViewById(R.id.lblCantonDLG);
        final TextView cajaDialogoParroquia = (TextView)dialog.findViewById(R.id.lblParroquiaDLG);
        final TextView cajaDialogoZona = (TextView)dialog.findViewById(R.id.lblZonaDLG);

        cajaDialogoCedula.setText(Items.get(position).getCedula());
        cajaDialogoNombre.setText(Items.get(position).getNombre());
        cajaDialogoRecinto.setText(Items.get(position).getRecinto());
        cajaDialogoJunta.setText(Items.get(position).getJunta());
        cajaDialogoDireccion.setText(Items.get(position).getDireccion());
        cajaDialogoProvincia.setText(Items.get(position).getProvincia());
        cajaDialogoCanton.setText(Items.get(position).getCanton());
        cajaDialogoParroquia.setText(Items.get(position).getParroquia());
        cajaDialogoZona.setText(Items.get(position).getZona());

        dialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCrear:
                final Dialog dlgCrearPersona = new Dialog(ActividadPrincipal.this);
                dlgCrearPersona.setContentView(R.layout.dlg_crear);
                dlgCrearPersona.show();
                final EditText cajaCedula = (EditText)dlgCrearPersona.findViewById(R.id.txtCedulaDLG);
                final EditText cajaNombre = (EditText)dlgCrearPersona.findViewById(R.id.txtNombreDLG);
                final EditText cajaRecinto = (EditText)dlgCrearPersona.findViewById(R.id.txtRecintoDLG);
                final EditText cajaJunta = (EditText)dlgCrearPersona.findViewById(R.id.txtJuntaDLG);
                final EditText cajaDireccion = (EditText)dlgCrearPersona.findViewById(R.id.txtDireccionDLG);
                final EditText cajaProvincia = (EditText)dlgCrearPersona.findViewById(R.id.txtPrivinciaDLG);
                final EditText cajaCanton = (EditText)dlgCrearPersona.findViewById(R.id.txtCantonDLG);
                final EditText cajaParroquia = (EditText)dlgCrearPersona.findViewById(R.id.txtParroquiaDLG);
                final EditText cajaZona = (EditText)dlgCrearPersona.findViewById(R.id.txtZonaDLG);
                Button botonGuardar = (Button)dlgCrearPersona.findViewById(R.id.btnGuardarDatosDLG);
                botonGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Persona per = new Persona();
                        per.setCedula(cajaCedula.getText().toString());
                        per.setCedula(cajaNombre.getText().toString());
                        per.setCedula(cajaRecinto.getText().toString());
                        per.setCedula(cajaJunta.getText().toString());
                        per.setCedula(cajaDireccion.getText().toString());
                        per.setCedula(cajaProvincia.getText().toString());
                        per.setCedula(cajaCanton.getText().toString());
                        per.setCedula(cajaParroquia.getText().toString());
                        per.setCedula(cajaZona.getText().toString());
                        helperPersonaBD.insertar(per);
                        mostrarListView();
                        dlgCrearPersona.hide();
                    }
                });
            break;
            case R.id.btnConsultar:
                final Dialog dlgMostrar = new Dialog(ActividadPrincipal.this);
                dlgMostrar.setContentView(R.layout.dlg_presentar);

                listaPersona = helperPersonaBD.leerCedula(cajaCedulaPrincipal.getText().toString());
                final TextView cajaced = (TextView) dlgMostrar.findViewById(R.id.lblCedulaDLG);
                final TextView cajanom= (TextView) dlgMostrar.findViewById(R.id.lblNombreDLG);
                final TextView cajarec= (TextView) dlgMostrar.findViewById(R.id.lblRecintoDLG);
                final TextView cajajunt= (TextView) dlgMostrar.findViewById(R.id.lblJuntaDLG);
                final TextView cajadir= (TextView) dlgMostrar.findViewById(R.id.lblDireccionDLG);
                final TextView cajapro= (TextView) dlgMostrar.findViewById(R.id.lblProvinciaDLG);
                final TextView cajacan = (TextView) dlgMostrar.findViewById(R.id.lblCantonDLG);
                final TextView cajaparr= (TextView) dlgMostrar.findViewById(R.id.lblParroquiaDLG);
                final TextView cajazon= (TextView) dlgMostrar.findViewById(R.id.lblZonaDLG);

                cajaced.setText(listaPersona.get(0).getCedula());
                cajanom.setText(listaPersona.get(0).getNombre());
                cajarec.setText(listaPersona.get(0).getRecinto());
                cajajunt.setText(listaPersona.get(0).getJunta());
                cajadir.setText(listaPersona.get(0).getDireccion());
                cajapro.setText(listaPersona.get(0).getProvincia());
                cajacan.setText(listaPersona.get(0).getCanton());
                cajaparr.setText(listaPersona.get(0).getParroquia());
                cajazon.setText(listaPersona.get(0).getZona());
                dlgMostrar.show();
                break;
        }

    }
    private void mostrarListView(){
        personas = new ArrayList<Persona>();
        persona = new Persona();
        listaPersona = helperPersonaBD.obtenerPersonas();

        for (int i = 0; i < listaPersona.size(); i++) {
            persona = listaPersona.get(i);
            personas.add(persona);
        }

        personaAdapter = new PersonaAdapter(ActividadPrincipal.this, personas);
        listView.setAdapter(personaAdapter);
        personaAdapter.notifyDataSetChanged();
    }

    private ArrayList<Persona> obtenerPersonasItem(){
        personas = new ArrayList<Persona>();
        //prod = new Producto();
        listaPersona = helperPersonaBD.obtenerPersonas();

        for (int i =0; i<listaPersona.size(); i++) {
            persona = listaPersona.get(i);
            personas.add(persona);
        }
        return personas;
    }
}
