package br.edu.pdm.criadourodacolina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView loginAutoComplete;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         /*faco a ligacao entre a classe activity e o layout xml*/
        setContentView(R.layout.activity_login);

         /*faco a ligacao dos componentes da tela com os objetos da classe */
        loginAutoComplete = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);

        Button botaoLogarSistema = findViewById(R.id.email_sign_in_button);
        /*adiciono um lister de click no botao logar para chamar o metodo logarNoSistema()*/
        botaoLogarSistema.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                logarNoSistema();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void logarNoSistema() {

        loginAutoComplete.setError(null);
        mPasswordView.setError(null);

        String email = loginAutoComplete.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(email)) {
            loginAutoComplete.setError(getString(R.string.error_field_required));
            focusView = loginAutoComplete;
            cancel = true;
        } else if (!isEmailValid(email)) {
            loginAutoComplete.setError(getString(R.string.error_invalid_email));
            focusView = loginAutoComplete;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        boolean loginValido = validarUsuarioESenha(email,password);
        if(!loginValido){
            mPasswordView.setError(getString(R.string.invalid_login));
            focusView = mPasswordView;
            focusView.requestFocus();
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            mostrarTelaListaTiposPassaros();
        }
    }

    private boolean validarUsuarioESenha(String email, String senha){
        return email.equals("mateus@gmail.com") && senha.equals("1234");
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private void mostrarTelaListaTiposPassaros() {
        Intent intent = new Intent(LoginActivity.this, TiposPassarosActivity.class);
        startActivity(intent);
        finish();
    }


}

