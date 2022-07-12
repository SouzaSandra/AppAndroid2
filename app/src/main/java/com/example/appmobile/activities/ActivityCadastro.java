package com.example.appmobile.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import DAO.CadastroDAO;
import controller.CadastroController;
import modelo.Cadastro;

public class ActivityCadastro extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private ConexaoSQLite helper;
    private EditText edtNome_solicita;
    private EditText edtEndereco;
    private EditText edtContato;
    private EditText edtBairro;
    private EditText edtAtendente;
    private Cadastro dao;

    private Button btnSalvarCadastro;
    private Button btnListarCadastro;
    private Button btnBuscarCEP;

    private Cadastro cadastro;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnBuscarCEP = (Button) findViewById(R.id.btnBuscarCEP);
        edtNome_solicita = (EditText) findViewById(R.id.edtNome_Solicita);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtContato = (EditText) findViewById(R.id.edtContato);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        helper = new ConexaoSQLite(this);
        edtAtendente = (EditText) findViewById(R.id.edtAtendente);



        btnSalvarCadastro = (Button) findViewById(R.id.btnSalvarCadastro);
        btnListarCadastro = (Button) findViewById(R.id.btnListarCadastro);
        btnBuscarCEP = (Button) findViewById(R.id.btnBuscarCEP);
        this.btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityCadastro.this, ActivityListarCadastro.class);
                startActivity(intent);
            }


        });



        this.btnListarCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ActivityCadastro.this, ActivityListarCadastro.class);
                startActivity(intent);
            }

            public void ListarCadastro(View view) {
                SQLiteDatabase db = helper.getWritableDatabase();

//                long resultado = db.insert("ListarCadastro", null, values);
//                if (resultado != 0) {
//                    Toast.makeText(ActivityCadastro.this, "Serviço Cadastrado", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(ActivityCadastro.this, "Serviço não Cadastrado", Toast.LENGTH_LONG).show();
//                }
            }
        });

//        private void callConnection() {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addOnConnectionFailedListener(this)
//                    .addConnectionCallbacks(this)
//                    .addApi(LocationServices.API)
//                    .build();
//            mGoogleApiClient.connect();
//
//        }


            }

        public void salvarCadastro(View view) {

                ContentValues values = new ContentValues();
                values.put("nome", edtNome_solicita.getText().toString());
                values.put("endereco", edtEndereco.getText().toString());
                values.put("contato", edtContato.getText().toString());
                values.put("bairro", edtBairro.getText().toString());
                values.put("atendente", edtAtendente.getText().toString());
                SQLiteDatabase db = helper.getWritableDatabase();

        long resultado = db.insert("cadastro", null, values);
        if (resultado != -1) {
            Toast.makeText(ActivityCadastro.this, "Serviço Cadastrado",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(ActivityCadastro.this, "Serviço não Cadastrado",
                    Toast.LENGTH_LONG).show();
        }
    }
        @Override
        public void onConnected(Bundle bundle){
            Log.i("LOG", "onConnected(" + bundle + ")");
            @SuppressLint("MissingPermission") Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            if (location !=null){
                Log.i("LOG", "latitude"+location.getLatitude());
                Log.i("LOG", "longitude"+location.getLongitude());
                btnBuscarCEP.setText(location.getLatitude()+ " | "+location.getLongitude());
            }

            }
            @Override
            public void onConnectionSuspended(int i) {
                Log.i("LOG", "onConnectionSuspended(" + i +")");
            }

            @Override
            public void onConnectionFailed(ConnectionResult connectionResult) {
                Log.i("LOG", "onConnectionFailed("+connectionResult+")" );
            }

    @Override
    protected  void onDestroy(){
        helper.close();
        super.onDestroy();
    }

            }

//            this.btnListarCadastro.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//
//                Cadastro cadastroCadastrar = getCadastroSolicitado();
//                if (cadastroCadastrar != null) {
//                    CadastroController cadastroController = new CadastroController(ConexaoSQLite.getInstanciaConexao(ActivityCadastro.this));
//                    cadastroController.salvarCadastroCtrl(cadastroCadastrar);
//                }
//                Intent intent = new Intent(ActivityCadastro.this, ActivityListarCadastro.class);
//                startActivity(intent);
//            }
//        });
//    }
//     Cadastro cadastroCadastrar = getCadastroSolicitado();
//            if (cadastroCadastrar != null) {
//                CadastroController cadastroController = new CadastroController(ConexaoSQLite.getInstanciaConexao(ActivityCadastro.this));
//                cadastroController.salvarCadastroCtrl(cadastroCadastrar);
//            }
//
//
//
//    private Cadastro getCadastroSolicitado() {
//
//        this.cadastro = new Cadastro();
//
//        if (this.edtNome_solicita.getText().toString().isEmpty() == false) {
//            this.cadastro.setNomeSolicita(this.edtNome_solicita.getText().toString());
//        } else {
//            return null;
//        }
//        if (edtEndereco.getText().toString().isEmpty() == false) {
//            this.cadastro.setEndereco(this.edtEndereco.getText().toString());
//        } else {
//            return null;
//        }
//        if (this.edtContato.getText().toString().isEmpty() == false) {
//            Long edtContato = Long.parseLong(this.edtContato.getText().toString());
//            this.cadastro.setFoneSolicita(cadastro.getFoneSolicita());
//        } else {
//            return null;
//        }
//
//        if (this.edtBairro.getText().toString().isEmpty() == false) {
//            this.cadastro.setBairro(this.edtBairro.getText().toString());
//        } else {
//            return null;
//        }
//        if (this.edtAtendente.getText().toString().isEmpty() == false) {
//            this.cadastro.setAtendente(this.edtAtendente.getText().toString());
//        }
//        return cadastro;
//    }
//
//
//    private void clickBtnSalvarListenr() {
//    }
//
//
//
//     FusedLocationProviderClient l = LocationServices.getFusedLocationProviderClient(this);
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//    */











