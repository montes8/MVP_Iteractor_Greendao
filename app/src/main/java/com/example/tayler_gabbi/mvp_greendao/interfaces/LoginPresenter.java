package com.example.tayler_gabbi.mvp_greendao.interfaces;


import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;

public interface LoginPresenter {

    void usuarioSucces(String user, String password, UsuarioDao usuarioDao);


}
