package br.com.caethas.atto.atto.modules.caixa.service

import br.com.caethas.atto.atto.modules.caixa.dto.CaixaDto
import br.com.caethas.atto.atto.modules.caixa.entity.CaixaEntity
import br.com.caethas.atto.atto.modules.caixa.mapper.CaixaMapper
import br.com.caethas.atto.atto.modules.caixa.repository.CaixaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class CaixaService(repository: CaixaRepository, mapper: CaixaMapper) :
    BaseService<CaixaEntity, CaixaRepository, CaixaDto>(
        repository, mapper,
    )