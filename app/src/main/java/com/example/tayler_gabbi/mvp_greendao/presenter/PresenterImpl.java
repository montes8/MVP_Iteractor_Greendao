package com.example.tayler_gabbi.mvp_greendao.presenter;

import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.interactores.LoginInteractorImpl;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginInteractor;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginPresenter;
import com.example.tayler_gabbi.mvp_greendao.interfaces.LoginView;
import com.example.tayler_gabbi.mvp_greendao.interfaces.OnLoginFinishListener;


public class PresenterImpl implements LoginPresenter ,OnLoginFinishListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public PresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void usuarioSucces(String user, String password, UsuarioDao usuarioDao) {
        if (loginView != null){

        }
        loginInteractor.validarUser(user,password,usuarioDao);

    }

    @Override
    public void loginValidationsError() {

        if (loginView != null){
            loginView.loginValidations();
        }

    }

    @Override
    public void loginSuccessExist() {
        if (loginView != null){
           loginView.loginSuccess();
        }
    }

    @Override
    public void loginUserError() {
        if (loginView != null){
            loginView.loginError();
        }

    }
}
