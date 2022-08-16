package com.api.helprback.domain.dtos;

import com.api.helprback.domain.Cliente;
import com.api.helprback.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "Preencha este campo!(Obrigatório)")
    protected String nome;
    @NotNull(message = "Preencha este campo!(Obrigatório)")
    protected String cpf;
    @NotNull(message = "Preencha este campo!(Obrigatório)")
    protected String email;
    @NotNull(message = "Preencha este campo!(Obrigatório)")
    protected String senha;

    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createData = LocalDate.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfis) {
        this.perfis.add(perfis.getCodigo());
    }

    public LocalDate getCreateData() {
        return createData;
    }

    public void setCreateData(LocalDate createData) {
        this.createData = createData;
    }

    public ClienteDTO(Cliente obj){
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.createData = obj.getDataCriacao();
        addPerfis(Perfil.CLIENTE);

    }

    public ClienteDTO(){
        super();
        addPerfis(Perfil.CLIENTE);
    }
}
