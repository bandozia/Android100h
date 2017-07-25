package br.com.impacta.android100h.lab03.domain.model;

/**
 * Created by no3603 on 12/07/2017.
 */

public final class Gorjeta {

    public final static String VALOR_0 = "0.00";

    public interface Formats{
        String VALUE = "%.02f";
    }

    public Gorjeta(){
        super();
    }

    private static double toPercent(Integer value){
        return value / 100;
    }

    public static double calcularGorjeta(Double valor, double percentual){
        return valor * percentual;
    }

    public static CharSequence calcularGorjeta(Double valor, Integer percentual){
        percentual = percentual == null ? Integer.valueOf(VALOR_0) : percentual;
        return String.format(Formats.VALUE, calcularGorjeta(valor,toPercent(percentual)));
    }

    public static CharSequence calcularGorjeta(CharSequence valor, Integer percentual){
        valor = valor == null || valor.length() == 0 ? VALOR_0 : valor;
        return calcularGorjeta(Double.valueOf(valor.toString()), percentual);
    }

    public static CharSequence calcularValor(Double valor, Double percentual){
        return String.format(Formats.VALUE, ( valor + calcularGorjeta(valor , percentual) ));
    }

    public static CharSequence calcularValor(CharSequence valor, Integer percentual){
        valor = valor == null || valor.length() == 0 ? VALOR_0 : valor;
        return calcularValor(Double.valueOf(valor.toString()), percentual);
    }

    public static CharSequence calcularValor(Double valor, Integer percentual){
        percentual = percentual == null ? Integer.valueOf(VALOR_0) : percentual;
        return calcularValor(valor, toPercent(percentual));
    }



}
