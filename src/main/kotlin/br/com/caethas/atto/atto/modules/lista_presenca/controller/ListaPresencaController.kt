package br.com.caethas.atto.atto.modules.lista_presenca.controller

import ListaPresencaDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.repository.ListaPresencaRepository
import br.com.caethas.atto.atto.modules.lista_presenca.service.ListaPresencaService
import br.com.caethas.atto.atto.shared.base.BaseController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("listas_presencas")
class ListaPresencaController(
    listaPresencaService: ListaPresencaService
) : BaseController<ListaPresencaEntity, ListaPresencaRepository, ListaPresencaDto>(listaPresencaService)