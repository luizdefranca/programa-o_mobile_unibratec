package com.example.android.aula07_lista;

public class Pessoa{
    String nome;
    String sobrenome;
    int genero;

    public Pessoa(String nome, String sobrenome, int genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", sobrenome=' " + sobrenome + '\'' +
                ", genero= " + (genero == 1 ? "M" : "F") ;
    }
}