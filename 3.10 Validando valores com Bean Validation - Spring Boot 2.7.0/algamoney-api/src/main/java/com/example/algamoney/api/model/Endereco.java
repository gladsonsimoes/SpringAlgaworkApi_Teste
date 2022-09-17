package com.example.algamoney.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String estado;
}
