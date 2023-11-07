package com.beneficiariodocumento.services.impl;

import com.beneficiariodocumento.domain.Beneficiario;
import com.beneficiariodocumento.domain.Documento;
import com.beneficiariodocumento.exception.NotFoundException;
import com.beneficiariodocumento.repositories.BeneficiarioRepository;
import com.beneficiariodocumento.repositories.DocumentoRepository;
import com.beneficiariodocumento.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Transactional
    @Override
    public Beneficiario salvar(Beneficiario obj) {
        obj.setId(null);
        obj = beneficiarioRepository.save(obj);
        documentoRepository.saveAll(obj.getDocumentos());
        return obj;
    }

    @Transactional
    @Override
    public Beneficiario atualizar(Beneficiario obj) {
        Beneficiario novoObj = buscarPorId(obj.getId());
        atualizarData(novoObj, obj);
        return beneficiarioRepository.save(novoObj);
    }

    private void atualizarData(Beneficiario novoObj, Beneficiario obj) {
        if (obj.getNome() != null) {
            novoObj.setNome(obj.getNome());
        }
        if (obj.getTelefone() != null) {
            novoObj.setTelefone(obj.getTelefone());
        }
        if (obj.getDataNascimento() != null) {
            novoObj.setDataNascimento(obj.getDataNascimento());
        }
        if (obj.getDataAtualizacao() != null) {
            novoObj.setDataAtualizacao(obj.getDataAtualizacao());
        }
    }

    @Override
    public void delete(Integer id) {
        buscarPorId(id);
        beneficiarioRepository.deleteById(id);
    }

    @Override
    public Beneficiario buscarPorId(Integer id) {
        Optional<Beneficiario> obj = beneficiarioRepository.findById(id);
        return obj.orElseThrow(() -> new NotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Beneficiario.class.getName()));
    }

    @Override
    public List<Beneficiario> buscarBeneficiarios() {
        List<Beneficiario> lista = beneficiarioRepository.findAll();
        for (Beneficiario b : lista) {
            b.getDocumentos()
                    .stream().filter(d -> d != null)
                    .forEach(d -> d.setBeneficiario(null));
        }
        return lista;
    }

    @Override
    public List<Documento> buscarDocumentosPorBeneficiario(Integer id) {
        buscarPorId(id);
        return documentoRepository.findDocumentosByBeneficiario(id);
    }
}
