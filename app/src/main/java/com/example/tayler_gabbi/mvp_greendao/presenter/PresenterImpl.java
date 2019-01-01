package com.example.tayler_gabbi.mvp_greendao.presenter;

import android.text.TextUtils;

import com.example.tayler_gabbi.mvp_greendao.database.Usuario;
import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginPresenter;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginView;

import java.util.ArrayList;

public class PresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public PresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void perfomLogin( String userName, String password, UsuarioDao usuarioDao) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            loginView.loginValidations();

        }else {

            ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) usuarioDao.queryBuilder().where(UsuarioDao.Properties.Usuario.eq(userName)).list();

                    if(listaUsuario!= null && listaUsuario.size() > 0) {

                        loginView.loginSuccess();

                    } else {

                        loginView.loginError();
                    }
                }
    }


}
