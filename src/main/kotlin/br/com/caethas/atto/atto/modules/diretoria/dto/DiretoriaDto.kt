package br.com.caethas.atto.atto.modules.diretoria.dto

import br.com.caethas.atto.atto.modules.diretoria.submodules.gestao.entity.GestaoEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import java.time.LocalDateTime
import java.util.UUID

data class DiretoriaFromDto(
    val nomeDiretoria: String,
    val informacoesDiretoria: String,
    val emailDiretoria: String?,
    val contatoDiretoria: String?,
    val gestoes: MutableList<GestaoEntity>

) : BaseDto.FromDto()

data class DiretoriaToDto(
    override val id: UUID?,
    override val criadoEm: LocalDateTime?,
    override val atualizadoEm: LocalDateTime?,
    override val deletadoEm: LocalDateTime?,
    override val sincronizadoEm: LocalDateTime?,
    val nomeDiretoria: String,
    val informacoesDiretoria: String,
    val emailDiretoria: String?,
    val contatoDiretoria: String?,
    val gestao: MutableList<GestaoEntity>

) : BaseDto.ToDto(
    id,
    criadoEm,
    atualizadoEm,
    deletadoEm,
    sincronizadoEm
)