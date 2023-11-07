package com.beneficiariodocumento.repositories.security;

import com.beneficiariodocumento.domain.security.SessaoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoInfoRepository extends JpaRepository<SessaoInfo, String> {

    SessaoInfo findByAccessToken(String accessToken);
}