package com.beneficiariodocumento.resources;

import com.beneficiariodocumento.domain.Beneficiario;
import com.beneficiariodocumento.domain.security.ProfileEnum;
import com.beneficiariodocumento.dto.BeneficiarioDTO;
import com.beneficiariodocumento.dto.DocumentoDTO;
import com.beneficiariodocumento.services.BeneficiarioService;
import com.beneficiariodocumento.services.impl.AutorizacaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"API dedicada a atender as necessidades dos processos de beneficiario e documentos do mesmo."})
@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioResource {

    @Autowired
    private BeneficiarioService service;

    @Autowired
    private AutorizacaoServiceImpl authorizationService;

    @ApiOperation("Salvar beneficiario.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> salvar(@RequestHeader String token, @Valid @RequestBody BeneficiarioDTO objDto) {
        autorizar(token, ProfileEnum.ADMIN);
        Beneficiario obj = new Beneficiario();
        BeanUtils.copyProperties(objDto, obj);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation("Atualizar beneficiario.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestHeader String token, @Valid @RequestBody BeneficiarioDTO objDto, @PathVariable Integer id) {
        autorizar(token, ProfileEnum.ADMIN, ProfileEnum.FUNCIONARIO);
        Beneficiario obj = new Beneficiario();
        BeanUtils.copyProperties(objDto, obj);
        obj.setId(id);
        obj = service.atualizar(obj);
    }

    @ApiOperation("Deletar beneficiario.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@RequestHeader String token, @PathVariable Integer id) {
        autorizar(token, ProfileEnum.ADMIN);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Buscar beneficiario por id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BeneficiarioDTO buscarPorId(@RequestHeader String token, @PathVariable Integer id) {
        autorizar(token, ProfileEnum.ADMIN, ProfileEnum.FUNCIONARIO);
        BeneficiarioDTO dto = new BeneficiarioDTO(service.buscarPorId(id));
        dto.getDocumentos()
                .stream().filter(d -> d != null)
                .forEach(d -> d.setBeneficiario(null));
        return dto;
    }

    @ApiOperation("Buscar todos os beneficiarios inseridos no banco.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BeneficiarioDTO>> buscarBeneficiarios(@RequestHeader String token) {
        autorizar(token, ProfileEnum.ADMIN, ProfileEnum.FUNCIONARIO);
        List<BeneficiarioDTO> listDto = service.buscarBeneficiarios().stream().map(obj -> new BeneficiarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @ApiOperation("Buscar os documentos do beneficiario por id.")
    @GetMapping("/{id}/documentos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DocumentoDTO>> buscarDocumentosPorBeneficiario(@RequestHeader String token, @PathVariable Integer id) {
        autorizar(token, ProfileEnum.ADMIN, ProfileEnum.FUNCIONARIO);
        List<DocumentoDTO> listDto = service.buscarDocumentosPorBeneficiario(id).stream().map(x -> new DocumentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    private void autorizar(String token, ProfileEnum... profiles) {
        try {
            authorizationService.autorizar(token, profiles);
        } catch (Exception e) {
            throw e;
        }
    }
}
