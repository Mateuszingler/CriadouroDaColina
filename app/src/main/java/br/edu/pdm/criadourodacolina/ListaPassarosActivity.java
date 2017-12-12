package br.edu.pdm.criadourodacolina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.edu.pdm.criadourodacolina.model.Passaro;
import br.edu.pdm.criadourodacolina.model.PassarosAdapter;
import br.edu.pdm.criadourodacolina.model.TipoPassaro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateus Zingler on 29-11-2017.
 */


public class ListaPassarosActivity extends AppCompatActivity {

    ListView listView;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                /*faco a ligacao entre a classe activity e o layout xml*/
        setContentView(R.layout.activity_lista_passaros);

        /*busco o componente com id lista_passaros e seto para um objeto to tipo do componente na classe*/
        listView = findViewById(R.id.listaPassaros);

        /*Aqui eu pego o extras que foi passado  pela Activity chamadora, no caso foi passado o TipoPassaro Selecionado*/
        Bundle extras = this.getIntent().getExtras();
        if(extras != null){
            TipoPassaro tipoPassadoSelecionado = (TipoPassaro)extras.get("tipoPassadoSelecionado");
            /*Pego a lista de Passaros do Tipo de Passaro, crio um adapter especializado e passo para a lisView da tela*/
            List<Passaro> listaPassaros =  tipoPassadoSelecionado.getListaPassaros();
            PassarosAdapter passarosAdapter = new PassarosAdapter(listaPassaros, this);
            listView.setAdapter(passarosAdapter);
        }

    }

}
