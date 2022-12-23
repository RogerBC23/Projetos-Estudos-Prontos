package com.nttdata.controleestoque.estudoSpring.validacoes;


import lombok.experimental.StandardException;

import java.sql.SQLIntegrityConstraintViolationException;


@StandardException
public class TratamentoExcecoes extends Exception {

    String message = "Houve um erro no sistema";

    public TratamentoExcecoes() {
        this(null, null);
    }

    public TratamentoExcecoes(String message) {
        this(message, null);
    }

    public TratamentoExcecoes(Throwable cause) {
        this(cause != null ? cause.getMessage() : null, cause);
    }

    public TratamentoExcecoes(String message, Throwable cause) {
        super(message);
        if (cause != null) super.initCause(cause);
    }

    public TratamentoExcecoes(SQLIntegrityConstraintViolationException cause){
        this(cause != null ? cause.getMessage() : null, cause);
    }

    public TratamentoExcecoes(String message, SQLIntegrityConstraintViolationException cause){
        super(message);
    }
    }


