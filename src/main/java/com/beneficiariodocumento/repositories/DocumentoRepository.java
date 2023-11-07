package com.beneficiariodocumento.repositories;

import com.beneficiariodocumento.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

    //List<Documento> findAllByBeneficiarioId(Integer id);

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Documento obj WHERE obj.beneficiario.id = :beneficiarioId ORDER BY obj.id")
    List<Documento> findDocumentosByBeneficiario(@Param("beneficiarioId") Integer beneficiarioId);
}
