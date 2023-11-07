package com.beneficiariodocumento.dto;

import com.beneficiariodocumento.domain.Beneficiario;
import com.beneficiariodocumento.domain.Documento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class BeneficiarioDTO implements Serializable {

    private static final long serialVersionUID = -9031487931907790020L;

    private Integer id;

    @Length(min = 5, max = 50, message = "O tamanho deve ser entre 5 e 50 caracteres")
    private String nome;

    private String telefone;

    @JsonFormat(pattern = "dd-MM-yyyy", locale = "pt_BR")
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @JsonFormat(pattern = "dd-MM-yyyy", locale = "pt_BR")
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataInclusao;

    @JsonFormat(pattern = "dd-MM-yyyy", locale = "pt_BR")
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAtualizacao;

    private List<Documento> documentos;

    public BeneficiarioDTO() {
        super();
    }

    public BeneficiarioDTO(Beneficiario obj) {
        id = obj.getId();
        nome = obj.getNome();
        telefone = obj.getTelefone();
        dataNascimento = obj.getDataNascimento();
        dataInclusao = LocalDate.now();
        dataAtualizacao = LocalDate.now();
        documentos = obj.getDocumentos();
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}
