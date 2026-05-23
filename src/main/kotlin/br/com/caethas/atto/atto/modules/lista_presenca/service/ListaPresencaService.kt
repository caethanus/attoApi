package br.com.caethas.atto.atto.modules.lista_presenca.service

import ListaPresencaDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.mapper.ListaPresencaMapper
import br.com.caethas.atto.atto.modules.lista_presenca.repository.ListaPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class ListaPresencaService(
    listaPresencaRepository: ListaPresencaRepository,
    listaPresencaMapper: ListaPresencaMapper
) : BaseService<ListaPresencaEntity, ListaPresencaRepository, ListaPresencaDto>(
    listaPresencaRepository,
    listaPresencaMapper
)