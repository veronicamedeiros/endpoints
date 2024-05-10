package org.linketinder.model.entities

class Company extends Person{

    private String cnpj

    Company(){}

    Company(String name, String email, String country, String cep, String state, String description, String cnpj, String password) {
        super(name, email, country, cep, state, description, password)
        setCnpj(cnpj)
    }


    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    String getCnpj() {
        return cnpj
    }
}
