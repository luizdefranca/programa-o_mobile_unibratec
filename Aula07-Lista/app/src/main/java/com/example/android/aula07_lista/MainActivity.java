package com.example.android.aula07_lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*   // 1º exemplo usando o modelo de layout do android

        List<String> pessoas = new ArrayList<String>();
        for (int i = 0; i<100; i++) {
            pessoas.add("Luiz");
            pessoas.add("Pedro");
            pessoas.add("Maria");
            pessoas.add("Julia");
        }

        ListView listView = (ListView) findViewById(R.id.listaPessoas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pessoas);
        listView.setAdapter(adapter);
*/
/*   // 2º Exemplo com um arquivo de layout proprio
        List<String> pessoas = new ArrayList<String>();
        for (int i = 0; i<100; i++) {
            pessoas.add("Luiz");
            pessoas.add("Pedro");
            pessoas.add("Maria");
            pessoas.add("Julia");
        }

        ListView listView = (ListView) findViewById(R.id.listaPessoas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_da_lista, pessoas);
        listView.setAdapter(adapter);
*/
       /*
       // 3º exemplo passando um objeto
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i<100; i++) {
            pessoas.add(new Pessoa("Luiz", "Carlos", 1));
            pessoas.add(new Pessoa("Pedro", "Luiz", 1));
            pessoas.add(new Pessoa("Maria", "José", 0));
            pessoas.add(new Pessoa("Julia", "Fernanda", 0));
        }

        ListView listView = (ListView) findViewById(R.id.listaPessoas);

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this, R.layout.item_da_lista, pessoas);
        listView.setAdapter(adapter);
        */

        //4º exemplo usando um adapter criado com um arquivo de layout próprio
        final List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i<100; i++) {
            pessoas.add(new Pessoa("Luiz", "Carlos", 1));
            pessoas.add(new Pessoa("Pedro", "Luiz", 1));
            pessoas.add(new Pessoa("Maria", "José", 0));
            pessoas.add(new Pessoa("Julia", "Fernanda", 0));
        }

        ListView listView = (ListView) findViewById(R.id.listaPessoas);

        PessoaAdapter adapter = new PessoaAdapter(this, pessoas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Pessoa pessoa = pessoas.get(position);

                // IMPORTANTE AQUI SE PEGA O OBJETO INTEIRO SELECIONADO DENTRO DA LISTA
                Pessoa pessoa = (Pessoa) parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

