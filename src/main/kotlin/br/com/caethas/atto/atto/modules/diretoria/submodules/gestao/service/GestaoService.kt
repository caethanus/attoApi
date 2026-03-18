package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.service

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.repository.GestaoRepository
import br.com.caethas.atto.atto.shared.base.BaseMapper
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class GestaoService(repository: GestaoRepository, mapper: BaseMapper<GestaoEntity, GestaoFromDto, GestaoToDto>) :
    BaseService<GestaoEntity, GestaoRepository, GestaoFromDto, GestaoToDto>(repository, mapper)