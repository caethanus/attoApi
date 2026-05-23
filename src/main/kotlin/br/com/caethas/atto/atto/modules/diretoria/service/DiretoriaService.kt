package br.com.caethas.atto.atto.modules.diretoria.service

import br.com.caethas.atto.atto.modules.diretoria.dto.DiretoriaDto
import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.mapper.DiretoriaMapper
import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class DiretoriaService(
    override val repository: DiretoriaRepository,
    override val mapper: DiretoriaMapper
) : BaseService<DiretoriaEntity, DiretoriaRepository, DiretoriaDto>(
    repository, mapper
)