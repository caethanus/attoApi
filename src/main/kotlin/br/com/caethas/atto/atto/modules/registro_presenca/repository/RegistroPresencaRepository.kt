package br.com.caethas.atto.atto.modules.registro_presenca.repository

import br.com.caethas.atto.atto.modules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RegistroPresencaRepository : BaseRepository<RegistroPresencaEntity> {
    /**
     * Busca registros de presença por ID da lista de presença
     */
    fun findByListaPresencaId(listaPresencaId: UUID): List<RegistroPresencaEntity>
}