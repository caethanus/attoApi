package br.com.caethas.atto.atto.modules.lista_presenca.service

import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.dto.ListaPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.mapper.ListaPresencaMapper
import br.com.caethas.atto.atto.modules.lista_presenca.repository.ListaPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class ListaPresencaService(
    private val listaPresencaRepository: ListaPresencaRepository,
    private val listaPresencaMapper: ListaPresencaMapper
) : BaseService<ListaPresencaEntity, ListaPresencaRepository, ListaPresencaFromDto, ListaPresencaToDto>(
    listaPresencaRepository,
    listaPresencaMapper
)