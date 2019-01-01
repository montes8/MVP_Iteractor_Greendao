package com.example.tayler_gabbi.mvp_greendao.interfaces;

import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;

public interface LoginInteractor {

  void validarUser(String user, String password, UsuarioDao usuarioDao);
}
