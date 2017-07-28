package br.com.impacta.android100h.lab06.domain.model;

/**
 * Created by no3603 on 27/07/2017.
 */

public abstract class Jogador {
    private Integer partidasGanhas;
    private String simbolo;

    protected Jogador(String simbolo){
        this.partidasGanhas = 0;
        this.simbolo = simbolo;
    }

    public void ganharPartida(){
        partidasGanhas++;
    }

    public void reiniciarPartida(){
        partidasGanhas = 0;
    }

    public Integer getPartidasGanhas(){
        return partidasGanhas;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
