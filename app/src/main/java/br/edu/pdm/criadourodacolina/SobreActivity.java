package br.edu.pdm.criadourodacolina;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*ligacao entre a classe activity e o layout xml*/
        setContentView(R.layout.activity_sobre);

    }


}
