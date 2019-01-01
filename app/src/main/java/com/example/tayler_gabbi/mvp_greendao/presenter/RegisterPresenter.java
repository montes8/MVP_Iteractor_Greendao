package com.example.tayler_gabbi.mvp_greendao.presenter;

import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;

public interface RegisterPresenter {

    void RegisterSucces(String name,String user, String password, UsuarioDao usuarioDao);
}
