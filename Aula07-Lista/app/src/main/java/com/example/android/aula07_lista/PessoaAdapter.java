package com.example.android.aula07_lista;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by luizramos on 17/10/16.
 */

public class PessoaAdapter extends ArrayAdapter<Pessoa> {
    public PessoaAdapter(Context context, List<Pessoa> objects) {
        super(context, 0, objects);


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1 - pegar o objeto da lista
        Pessoa pessoa = getItem(position);

        //2 - carregar o arquivo de layout que representa o item


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_da_lista2, null);
        }

        //3 - preencher o arquivo de layout com as informações do objeto

        TextView txtNome = (TextView) convertView.findViewById(R.id.nome);
        TextView txtSobreNome = (TextView) convertView.findViewById(R.id.sobreNome);

        txtNome.setText(pessoa.nome);
        txtSobreNome.setText(pessoa.sobrenome);
        txtSobreNome.setTextColor(pessoa.genero==1? Color.BLUE: Color.RED);


        //4 - Retornar a view preenchida
        //return layout;
        return convertView;
    }
}
