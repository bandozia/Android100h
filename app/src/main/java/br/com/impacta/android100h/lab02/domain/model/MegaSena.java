package br.com.impacta.android100h.lab02.domain.model;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;

import an.algoritimos.ArrayAlgos;

public final class MegaSena {

    private static int[] group;

    public interface Bundle{
        String JOGO = "lab02.megasena.jogo";
        String JOGOS = "lab02.megasena.jogos";
    }

    public interface Formats{
        String JOGO = "%02d %02d %02d %02d %02d %02d";
    }

    private MegaSena(){
        super();
    }

    public static String sortear(){

        group = new int[60];
        for(int i = 0; i < group.length; i++){
            group[i] = i + 1;
        }

        final Integer[] jogo = ArrayAlgos.fisherYates(group, 6);

        return String.format(Formats.JOGO, jogo);
    }

    public static ArrayList<String> sortear(int jogos){
        final ArrayList<String> js = new ArrayList<>();
        final HashSet<String> ujs = new HashSet<>();

        while (ujs.size() < jogos){
            ujs.add(sortear());
        }

        js.addAll(ujs);

        return js;
    }



}
