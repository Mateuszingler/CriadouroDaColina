package br.edu.pdm.criadourodacolina;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.pdm.criadourodacolina.model.Passaro;
import br.edu.pdm.criadourodacolina.model.TipoPassaro;


public class TiposPassarosActivity extends AppCompatActivity {

    private ListView listView;
    private Button buttonSobre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*ligacao entre a classe activity e o layout xml*/
        setContentView(R.layout.activity_lista_tipos_passaros);

        /*busco o componente com id lista_tipos_passaros e seto para um objeto do tipo do componente na classe*/
        listView = findViewById(R.id.lista_tipos_passaros);
        /*pego a lista de tipos de passaros*/
        List<TipoPassaro> listaTiposPassaros = getListaTiposPassaros();
        /*crio um ArrayAdapter (que é um adapter pronto do android, com o layou simple_list_item, e passo a lista que ele deve mostrar na tela)*/
        ArrayAdapter<TipoPassaro> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaTiposPassaros);
        /*seto esse adapter para o listView que está na tela*/
        listView.setAdapter(adapter);

        /*adicionadp um lister (escuta) de click na listView da tela, para pegar o objeto (TipoPassaro) quando o clicar na lista*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /*pego o objeto clicado na lista*/
                TipoPassaro tipoPassadoSelecionado = (TipoPassaro)adapterView.getAdapter().getItem(i);
                /*Crio um Intent para abrir a activity da lista de passaros*/
                Intent intent = new Intent(TiposPassarosActivity.this, ListaPassarosActivity.class);

                intent.putExtra("tipoPassadoSelecionado",tipoPassadoSelecionado);
                startActivity(intent);

            }
        });

        /*busco o componente da tela e seto para o botao da classe*/
        buttonSobre = findViewById(R.id.buttonSobre);

        buttonSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*instancio a activity sobre*/
                Intent intent = new Intent(TiposPassarosActivity.this, SobreActivity.class);
                startActivity(intent);
            }
        });

    }

    public List<TipoPassaro> getListaTiposPassaros(){
        /*aqui eu monto a estrutura dos objetos, eu tenho uma lista de TipoPassaro, onde cada TipoPassaro tem uma lista de Passaros
        * Estou criando uma lista de passaros de um tipo e adicionando na lista de passaros do tipo
        *
        * Os Resources (recursos) de audio e imagem estão na pasta res do projeto, em drawable e raw (audio)
        * cada resource tem o seu ID, o ID de cada recurso é dado pelo nome do arquivo,
        */


        List<TipoPassaro> listaTipoPassaros = new ArrayList<>();
        List<Passaro> listaPassaros;

        listaPassaros = new ArrayList<>();
        listaPassaros.add(new Passaro(1L,"Rosela","Platycercus Eximius", R.drawable.rosela_platycercus_eximius, R.raw.rosela));
        listaPassaros.add(new Passaro(2L,"Rosela","Icterotis", R.drawable.rosela_icterotis, R.raw.rosela));
        listaPassaros.add(new Passaro(3L,"Rosela","Plálida", R.drawable.rosela_palida, R.raw.rosela));
        listaTipoPassaros.add(new TipoPassaro(1L,"Roselas", listaPassaros));


        listaPassaros = new ArrayList<>();
        listaPassaros.add(new Passaro(4L,"Calopsita","Alerquim",R.drawable.calopsita_alerquim, R.raw.calopsita));
        listaPassaros.add(new Passaro(5L,"Calopsita","Ashenfallow Cockatiel",R.drawable.calopsita_ashenfallow_cockatiel, R.raw.calopsita));
        listaPassaros.add(new Passaro(6L,"Calopsita","Bronzefallow Cockatiel",R.drawable.calopsita_bronzefallow_cockatiel, R.raw.calopsita));
        listaTipoPassaros.add(new TipoPassaro(2L,"Calopsitas", listaPassaros));


        listaPassaros = new ArrayList<>();
        listaPassaros.add(new Passaro(7L,"Agaposnis","Canus",R.drawable.agaposnis_canus, R.raw.agaposnis));
        listaPassaros.add(new Passaro(8L,"Agaposnis","Fischeri",R.drawable.agaposnis_fischeri, R.raw.agaposnis));
        listaPassaros.add(new Passaro(9L,"Agaposnis","Personatus",R.drawable.agaposnis_personatus, R.raw.agaposnis));
        listaTipoPassaros.add(new TipoPassaro(3L,"Agaposnis", listaPassaros));
        return listaTipoPassaros;
    }

}
