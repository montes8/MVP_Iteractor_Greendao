package com.example.tayler_gabbi.mvp_greendao.interactores;

import android.text.TextUtils;

import com.example.tayler_gabbi.mvp_greendao.database.Usuario;
import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginInteractor;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginPresenter;
import com.example.tayler_gabbi.mvp_greendao.interfaces.OnLoginFinishListener;

import java.util.ArrayList;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter loginPresenter;

    @Override
    public void validarUser(String user, String password, UsuarioDao usuarioDao, OnLoginFinishListener listener) {
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(password)){

            listener.loginValidationsError();

        }else {

            ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) usuarioDao.queryBuilder().where(UsuarioDao.Properties.Usuario.eq(user)).list();

            if(listaUsuario!= null && listaUsuario.size() > 0) {

                listener.loginSuccessExist();

            } else {

                listener.loginUserError();
            }
        }
    }
}
