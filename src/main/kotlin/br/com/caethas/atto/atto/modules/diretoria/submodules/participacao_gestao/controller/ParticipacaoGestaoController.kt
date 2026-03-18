package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.controller

import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoFromDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto.ParticipacaoGestaoToDto
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.entity.ParticipacaoGestaoEntity
import br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.service.ParticipacaoGestaoService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/participacoes_gestao")
class ParticipacaoGestaoController(service: ParticipacaoGestaoService) :
    BaseController<ParticipacaoGestaoEntity, ParticipacaoGestaoFromDto, ParticipacaoGestaoToDto>(
        service
    )