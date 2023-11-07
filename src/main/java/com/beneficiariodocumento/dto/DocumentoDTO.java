package com.beneficiariodocumento.dto;

import com.beneficiariodocumento.domain.Documento;

import java.io.Serializable;
import java.time.LocalDate;

public class DocumentoDTO implements Serializable {

    private static final long serialVersionUID = -9031487931907790020L;

    private Integer id;

    private String tipoDocumento;

    private String descricao;

    private LocalDate dataInclusao;

    private LocalDate dataAtualizacao;

    public DocumentoDTO() {
        super();
    }

    public DocumentoDTO(Documento obj) {
        id = obj.getId();
        tipoDocumento = obj.getTipoDocumento();
        descricao = obj.getDescricao();
        dataInclusao = LocalDate.now();
        dataAtualizacao = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
