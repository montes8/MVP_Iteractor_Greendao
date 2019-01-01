package com.example.tayler_gabbi.mvp_greendao.model;

import com.example.tayler_gabbi.mvp_greendao.database.UsuarioDao;
import com.example.tayler_gabbi.mvp_greendao.interactores.RegisterInteractorImpl;
import com.example.tayler_gabbi.mvp_greendao.interfaces.OnRegisterFinishListener;
import com.example.tayler_gabbi.mvp_greendao.interfaces.RegisterInteractor;
import com.example.tayler_gabbi.mvp_greendao.presenter.RegisterPresenter;
import com.example.tayler_gabbi.mvp_greendao.view.RegisterView;

public class RegisterPresenterImpl implements RegisterPresenter,OnRegisterFinishListener{

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    public RegisterPresenterImpl(RegisterView registerView) {
        this.registerView = registerView;
        this.registerInteractor = new RegisterInteractorImpl();
    }

    @Override
    public void RegisterSucces(String name, String user, String password, UsuarioDao usuarioDao) {

        registerInteractor.registrarUser(name,user,password,usuarioDao,this);

    }

    @Override
    public void registrarSuccessExcito() {

        if (registerView != null){
            registerView.registrarSuccess();
        }

    }

    @Override
    public void nombreError() {

        if (registerView != null){
            registerView.nameError();
        }

    }

    @Override
    public void usuError() {

        if (registerView != null){
            registerView.usuarioError();
        }
    }

    @Override
    public void contraseniaError() {
        if (registerView != null){
            registerView.passwordError();
        }
    }

    @Override
    public void registroError() {
        if (registerView != null){
            registerView.registerError();
        }
    }
}
