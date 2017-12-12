package br.edu.pdm.criadourodacolina.model;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import br.edu.pdm.criadourodacolina.R;

/**
 * Created by Mateus Zingler on 29-11-2017.
 */


public class PassarosAdapter extends BaseAdapter{

    private List<Passaro> listaPassaros;
    private Activity activity;

    public PassarosAdapter(List<Passaro> listaPassaros, Activity activity){
        this.listaPassaros = listaPassaros;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaPassaros.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPassaros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaPassaros.get(i).getId();
    }

    /*neste metodo eu pego a activity_lista_passaros_adapter que está na tela da activity activity_lista_passaros (como uma ListView simples)
    * A partir desta ListView simples, eu pego a activity_lista_passaros_adapter e preencho  a ListView da activity_lista_passaros
    * a activity_lista_passaros_adapter é uma listView com um layout especifico, justamente para mostrar as imagens, textos e play/pause*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = activity.getLayoutInflater().inflate(R.layout.activity_lista_passaros_adapter, viewGroup, false);
        /*pego o passaro selecionado pelo indice*/
        final Passaro passaro = listaPassaros.get(i);

        /*pego as informações do passaro selecionado e seto nos componentes da activity_lista_passaros_adapter*/
        ImageView imagemPassaro = view.findViewById(R.id.lista_passaro_imagem);
        TextView nomePassaro = view.findViewById(R.id.lista_passaro_nome);
        TextView especiePassaro = view.findViewById(R.id.lista_passaro_especie);
        final ImageButton playAudio = view.findViewById(R.id.lista_passaro_play);
        playAudio.setImageResource(R.drawable.play);
        final MediaPlayer mediaPlayer = MediaPlayer.create(activity, passaro.getIdAudioResource());


        nomePassaro.setText(passaro.getNome());
        especiePassaro.setText(passaro.getEspecie());
        imagemPassaro.setImageResource(passaro.getIdImagemResource());

        /*crio um listner de click para o botao playAudio, para dar play no audio do passaro*/
        playAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*se estiver executando eu pauso e seto o icone de play*/
                if(mediaPlayer.isPlaying()){
                    playAudio.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                }else{
                    /*se não estiver executando eu dou play no audio e seto o icone de pause*/
                    mediaPlayer.start();
                    playAudio.setImageResource(R.drawable.pause);
                }

            }
        });

        return view;
    }
}
