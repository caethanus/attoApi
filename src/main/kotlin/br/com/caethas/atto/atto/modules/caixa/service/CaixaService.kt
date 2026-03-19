package br.com.caethas.atto.atto.modules.caixa.service

import br.com.caethas.atto.atto.modules.caixa.dto.CaixaFromDto
import br.com.caethas.atto.atto.modules.caixa.dto.CaixaToDto
import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.repository.CaixaRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class CaixaService(repository: CaixaRepository, mapper: BaseMapper<CaixaEntity, CaixaFromDto, CaixaToDto>) :
    BaseService<CaixaEntity, CaixaRepository, CaixaFromDto, CaixaToDto>(
        repository, mapper,
    )