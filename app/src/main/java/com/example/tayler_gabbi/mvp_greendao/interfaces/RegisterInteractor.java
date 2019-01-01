package com.example.tayler_gabbi.mvp_greendao.interfaces;

import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;

public interface RegisterInteractor {

    void registrarUser(String name,String user, String password, UsuarioDao usuarioDao, OnRegisterFinishListener listener);
}
