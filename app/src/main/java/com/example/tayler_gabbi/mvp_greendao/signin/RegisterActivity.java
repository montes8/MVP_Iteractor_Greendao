package com.example.tayler_gabbi.mvp_greendao.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tayler_gabbi.mvp_greendao.DemoApplication;
import com.example.tayler_gabbi.mvp_greendao.R;
import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.model.RegisterPresenterImpl;
import com.example.tayler_gabbi.mvp_greendao.presenter.RegisterPresenter;
import com.example.tayler_gabbi.mvp_greendao.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private EditText nombre,usuario,contrasenia;
    private Button btnRegistrar;
    private RegisterPresenter registrarPresenter;
    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.edit_text_name);
        usuario = findViewById(R.id.edit_text_usuario);
        contrasenia = findViewById(R.id.edit_text_password);
        btnRegistrar = findViewById(R.id.button_register_ingresar);


        usuarioDao = ((DemoApplication)getApplication()).getDaoSession().getUsuarioDao();

        registrarPresenter = new RegisterPresenterImpl(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrarPresenter.RegisterSucces(nombre.getText().toString(),usuario.getText().toString(),contrasenia.getText().toString(),usuarioDao);
            }
        });

    }

    @Override
    public void registrarSuccess() {


        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        Toast.makeText(this,"usuario registrado",Toast.LENGTH_LONG).show();
    }

    @Override
    public void nameError() {
        Toast.makeText(this,"Ingrese nombre",Toast.LENGTH_LONG).show();
    }

    @Override
    public void usuarioError() {

        Toast.makeText(this,"Ingrese nombre de usuario",Toast.LENGTH_LONG).show();

    }

    @Override
    public void passwordError() {


        Toast.makeText(this,"Ingrese  Contraseña",Toast.LENGTH_LONG).show();

    }

    @Override
    public void registerError() {

        Toast.makeText(this,"usuario no guardado", Toast.LENGTH_LONG).show();
    }
}
