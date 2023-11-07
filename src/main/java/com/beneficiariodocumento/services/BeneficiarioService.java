package com.beneficiariodocumento.services;

import com.beneficiariodocumento.domain.Beneficiario;
import com.beneficiariodocumento.domain.Documento;

import java.util.List;

public interface BeneficiarioService {

    Beneficiario buscarPorId(Integer id);

    Beneficiario salvar(Beneficiario obj);

    Beneficiario atualizar(Beneficiario obj);

    List<Beneficiario> buscarBeneficiarios();

    List<Documento> buscarDocumentosPorBeneficiario(Integer id);

    void delete(Integer id);
}
