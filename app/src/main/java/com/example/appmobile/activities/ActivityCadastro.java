package com.example.appmobile.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import controller.CadastroController;
import modelo.Cadastro;

public class ActivityCadastro extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private TextView GPS;
    private EditText edtNome_solicita;
    private EditText edtEndereco;
    private EditText edtContato;
    private EditText edtBairro;
    private EditText edtAtendente;

    private Button btnSalvarCadastro;
    private Button btnListarCadasro;

    private Cadastro cadastro;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        GPS = (TextView)findViewById(R.id.GPS);
        callConnection();

        ConexaoSQLite.getInstanciaConexao(this);

        edtNome_solicita = (EditText) findViewById(R.id.edtNome_Solicita);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtContato = (EditText) findViewById(R.id.edtContato);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtAtendente = (EditText) findViewById(R.id.edtAtendente);
        btnSalvarCadastro = (Button) findViewById(R.id.btnSalvarCadastro);
        btnListarCadasro = (Button) findViewById(R.id.btnListarCadastro);


        this.btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityCadastro.this, ActivityServico.class);
                startActivity(intent);
            }
        });
        this.btnListarCadasro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Cadastro cadastroCadastrar = getCadastroSolicitado();
                if (cadastroCadastrar != null) {
                    CadastroController cadastroController = new CadastroController(ConexaoSQLite.getInstanciaConexao(ActivityCadastro.this));
                    cadastroController.salvarCadastroCtrl(cadastroCadastrar);
                }
                Intent intent = new Intent(ActivityCadastro.this, ActivityListarCadastro.class);
                startActivity(intent);
            }
        });
    }

    private Cadastro getCadastroSolicitado() {

        this.cadastro = new Cadastro();

        if (this.edtNome_solicita.getText().toString().isEmpty() == false) {
            this.cadastro.setNomeSolicita(this.edtNome_solicita.getText().toString());
        } else {
            return null;
        }
        if (edtEndereco.getText().toString().isEmpty() == false) {
            this.cadastro.setEndereco(this.edtEndereco.getText().toString());
        } else {
            return null;
        }
        if (this.edtContato.getText().toString().isEmpty() == false) {
            Long edtContato = Long.parseLong(this.edtContato.getText().toString());
            this.cadastro.setFoneSolicita(cadastro.getFoneSolicita());
        } else {
            return null;
        }

        if (this.edtBairro.getText().toString().isEmpty() == false) {
            this.cadastro.setBairro(this.edtBairro.getText().toString());
        } else {
            return null;
        }
        if (this.edtAtendente.getText().toString().isEmpty() == false) {
            this.cadastro.setAtendente(this.edtAtendente.getText().toString());
        }
        return cadastro;
    }


    private void clickBtnSalvarListenr() {
    }


    @Override
    public void onConnected(Bundle bundle) {
            Log.i("LOG", "onConnected(" + bundle +")");
            Location l = LOCATION_SERVICE.FusedLocationApi.getLastLocation(mGoogleApiClient);
             if(l!= null){
                 Log.i("LOG", "latitude"+l.getLatitude());
                 Log.i("LOG", "longitude"+l.getLongitude());
                 GPS.setText(l.getLatitude()+ " | "+l.getLongitude());
             }

    }
    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LOCATION_SERVICE.API)
                .build();
        mGoogleApiClient.connect();

    }


            @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i +")");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed("+connectionResult+")" );

    }
}





