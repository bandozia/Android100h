package br.com.impacta.android100h.lab05.domain;

import br.com.impacta.android100h.lab05.domain.exception.DocumentoException;

/**
 * Created by no3603 on 18/07/2017.
 */

public interface Documento {
    String VALIDO = "Documento Valido";

    void validar() throws DocumentoException;
}
