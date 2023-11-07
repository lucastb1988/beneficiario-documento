package com.beneficiariodocumento.services.impl;

import com.beneficiariodocumento.domain.Beneficiario;
import com.beneficiariodocumento.domain.Documento;
import com.beneficiariodocumento.domain.security.ProfileEnum;
import com.beneficiariodocumento.domain.security.Usuario;
import com.beneficiariodocumento.repositories.BeneficiarioRepository;
import com.beneficiariodocumento.repositories.DocumentoRepository;
import com.beneficiariodocumento.repositories.security.UsuarioRepository;
import com.beneficiariodocumento.services.DBService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBServiceImpl implements DBService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void instanciarDataBase() {

        Beneficiario ben1 = new Beneficiario(null, "Lucas Tartarini", "11985209632",
                LocalDate.of(1988, 7, 04), LocalDate.now(), LocalDate.now());
        Documento doc1 = new Documento(null, "RG", "409061669");
        Documento doc2 = new Documento(null, "CPF", "38941569885");

        Beneficiario ben2 = new Beneficiario(null, "Maria Silva", "11985209656",
                LocalDate.of(1955, 1, 10), LocalDate.now(), LocalDate.now());
        Documento doc3 = new Documento(null, "RG", "409061005");
        Documento doc4 = new Documento(null, "CPF", "38941569258");

        Beneficiario ben3 = new Beneficiario(null, "Junior Aguiar", "11985209685",
                LocalDate.of(1958, 10, 15), LocalDate.now(), LocalDate.now());
        Documento doc5 = new Documento(null, "RG", "426981005");
        Documento doc6 = new Documento(null, "CPF", "38812369258");

        ben1.getDocumentos().addAll(Arrays.asList(doc1, doc2));
        doc1.setBeneficiario(ben1);
        doc2.setBeneficiario(ben1);

        ben2.getDocumentos().addAll(Arrays.asList(doc3, doc4));
        doc3.setBeneficiario(ben2);
        doc4.setBeneficiario(ben2);

        ben3.getDocumentos().addAll(Arrays.asList(doc5, doc6));
        doc5.setBeneficiario(ben3);
        doc6.setBeneficiario(ben3);

        beneficiarioRepository.saveAll(Arrays.asList(ben1, ben2, ben3));
        documentoRepository.saveAll(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6));

        Usuario user1 = new Usuario(null, "Lucas Tartarini", "lucas.t.banin@gmail.com", "abc123", Lists.newArrayList(ProfileEnum.ADMIN.getDescription(), ProfileEnum.FUNCIONARIO.getDescription()));
        Usuario user2 = new Usuario(null, "Gustavo Tartarini", "gustavo.t.banin@gmail.com", "abc123", Lists.newArrayList(ProfileEnum.FUNCIONARIO.getDescription()));
        usuarioRepository.saveAll(Arrays.asList(user1, user2));
    }
}