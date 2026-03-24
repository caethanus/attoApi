package br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.service

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.dto.GestaoDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.mapper.GestaoMapper
import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.repository.GestaoRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class GestaoService(repository: GestaoRepository, mapper: GestaoMapper) :
    BaseService<GestaoEntity, GestaoRepository, GestaoDto>(repository, mapper)