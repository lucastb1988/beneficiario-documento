package com.beneficiariodocumento.repositories;

import com.beneficiariodocumento.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {

}
