package br.com.caethas.atto.atto.modules.diretoria.submodules.participacao_gestao.dto

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import org.springframework.cglib.core.Local
import java.time.LocalDateTime
import java.util.UUID

data class ParticipacaoGestaoFromDto(
    val membroId: UUID,
    val cargoId: UUID,
    val dataEntrada: LocalDateTime,
    val dataSaida: LocalDateTime?
) : BaseDto.FromDto()

data class ParticipacaoGestaoToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val membro: MembroEntity,
    val cargo: CargoEntity,
    val dataEntrada: LocalDateTime,
    val dataSaida: LocalDateTime?
) : BaseDto.ToDto(
    id,
    criadoEm,
    atualizadoEm,
    deletadoEm,
    sincronizadoEm
)