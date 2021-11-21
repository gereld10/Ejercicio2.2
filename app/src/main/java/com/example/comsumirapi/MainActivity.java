package com.example.comsumirapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    EditText txtPalabra;
    Button btnBuscar;


    ListView lista1 = null;
    List<Post> usuarios = new ArrayList<Post>();
    UserAdapter adaptador= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPalabra = findViewById(R.id.txtPalabra);
        btnBuscar = findViewById(R.id.btnBuscar);
        lista1 = findViewById(R.id.listauser);

        adaptador = new UserAdapter(this, android.R.layout.activity_list_item,usuarios);
        lista1 = (ListView) findViewById(R.id.listauser);
        lista1.setAdapter(adaptador);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargaUsuarios(txtPalabra.getText().toString());
            }
        });


    }

    public void cargaUsuarios(String q) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
        PostService postService = retrofit.create(PostService.class);
        Call<List<Post>> call = postService.find(q);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               List<Post> data = response.body();
                   usuarios.addAll(data);
                   adaptador.notifyDataSetChanged();



            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}