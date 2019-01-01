package com.example.tayler_gabbi.mvp_greendao.presenter;


import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;

public interface LoginPresenter {

    void perfomLogin(String userName, String password, UsuarioDao usuarioDao);
}
