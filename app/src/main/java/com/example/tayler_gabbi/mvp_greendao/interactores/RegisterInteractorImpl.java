package com.example.tayler_gabbi.mvp_greendao.interactores;

import android.text.TextUtils;

import com.example.tayler_gabbi.mvp_greendao.database.Usuario;
import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.interfaces.OnRegisterFinishListener;
import com.example.tayler_gabbi.mvp_greendao.interfaces.RegisterInteractor;
import com.example.tayler_gabbi.mvp_greendao.presenter.RegisterPresenter;

public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterPresenter registerPresenter;


    @Override
    public void registrarUser(String name, String user, String password, UsuarioDao usuarioDao, OnRegisterFinishListener listener) {
        if (TextUtils.isEmpty(name)) {

            listener.nombreError();

        } else if (TextUtils.isEmpty(user)) {

            listener.usuError();
        } else if (TextUtils.isEmpty(password)) {

            listener.contraseniaError();

        } else {

            Usuario usuarioi = new Usuario();
            usuarioi.setNombre(name);
            usuarioi.setUsuario(user);
            usuarioi.setContrasenia(password);
            Long idResultante = usuarioDao.insert(usuarioi);

            if (idResultante != null && idResultante > 0) {

                listener.registrarSuccessExcito();

            } else {

                listener.registroError();
            }
        }
    }
}
