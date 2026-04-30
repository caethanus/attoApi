package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto

import br.com.caethas.atto.atto.modules.lista_presenca.entity.ListaPresencaEntity
import br.com.caethas.atto.atto.modules.membro.entity.MembroEntity

data class RegistroPresencaDto(
    val baseDto: BaseDto,
    var membro: MembroEntity,
    var presente: Boolean,
    var listaPresenca: ListaPresencaEntity
)