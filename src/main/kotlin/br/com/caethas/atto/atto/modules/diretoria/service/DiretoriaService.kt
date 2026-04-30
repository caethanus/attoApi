package br.com.caethas.atto.atto.modules.diretoria.service

import br.com.caethas.atto.atto.modules.diretoria.entity.DiretoriaEntity
import br.com.caethas.atto.atto.modules.diretoria.repository.DiretoriaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class DiretoriaService(
    override val repository: DiretoriaRepository
) : BaseService<DiretoriaEntity, DiretoriaRepository>(
    repository
)