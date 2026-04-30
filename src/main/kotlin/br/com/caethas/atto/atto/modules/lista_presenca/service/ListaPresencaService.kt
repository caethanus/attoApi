package br.com.caethas.atto.atto.modules.lista_presenca.service

import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.lista_presenca.repository.ListaPresencaRepository
import br.com.caethas.atto.atto.shared.base.BaseService
import org.springframework.stereotype.Service

@Service
class ListaPresencaService(
    listaPresencaRepository: ListaPresencaRepository
) : BaseService<ListaPresencaEntity, ListaPresencaRepository>(
    listaPresencaRepository
)