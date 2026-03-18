package br.com.caethas.atto.atto.modules.lista_presenca.controller

import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.service.ListaPresencaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("listas_presencas")
class ListaPresencaController(
    private val listaPresencaService: ListaPresencaService
) : BaseController<ListaPresencaEntity, ListaPresencaFromDto, ListaPresencaToDto>(listaPresencaService)