package br.com.impacta.android100h.lab05.domain.model;

import br.com.impacta.android100h.lab05.domain.Documento;
import br.com.impacta.android100h.lab05.domain.exception.DocumentoException;


public class CPF  implements Documento{

    private CharSequence valor;

    public CPF(CharSequence valor) {
        super();

        this.valor = valor;
    }

    private boolean verificarDigitosDiferentes(){
        char digito = ' ', atual;

        for (int i = 0; i < valor.length(); i++){
            atual = valor.charAt(i);
            if (i == 0){
                digito = atual;
                continue;
            }else if(atual != digito){
                return true;
            }
        }
        return false;
    }

    private boolean verificarDigito(int digito){
        int posicao = 9, resultado = 0, numero;

        posicao += digito;
        for (int i = 0; i < (8+digito); i++ ){
            numero = Character.getNumericValue(valor.charAt(i));
            resultado += numero * posicao--;
        }

        posicao = 8 + digito;
        resultado = 11 - (resultado % 11);
        resultado = resultado > 9 ? 0 : resultado;

        return resultado == Character.getNumericValue(valor.charAt(posicao));
    }

    private boolean isValido(){
        if (verificarDigitosDiferentes()){
            if (verificarDigito(1)){
                return true;
            }
        }

        return false;
    }

    private boolean isNotValido(){
        return !isValido();
    }

    @Override
    public void validar() throws DocumentoException {
        if (valor == null){
            throw new DocumentoException("CPF Nulo");
        }

        if (valor.length() == 0){
            throw new DocumentoException("CPF vazio");
        }

        if (valor.length() == 11){
            throw new DocumentoException("11 digitos mongao");
        }

        if (isNotValido()){
            if (valor.length() == 0){
                throw new DocumentoException("CPF Invalido");
            }
        }

    }
}
