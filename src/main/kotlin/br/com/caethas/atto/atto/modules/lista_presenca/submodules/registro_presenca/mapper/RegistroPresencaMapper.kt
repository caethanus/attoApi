package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.mapper

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaFromDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaToDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseMapper

class RegistroPresencaMapper : BaseMapper<RegistroPresencaEntity, RegistroPresencaFromDto, RegistroPresencaToDto>() {
    override fun fromDto(request: RegistroPresencaFromDto): RegistroPresencaEntity {
        return RegistroPresencaEntity(
            membro = request.membro,
            presente = request.presente,
            listaPresenca = request.listaPresenca,
        )
    }

    override fun toDto(entity: RegistroPresencaEntity): RegistroPresencaToDto {
        return RegistroPresencaToDto(
            id = entity.id,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm,
            deletadoEm = entity.deletadoEm,
            sincronizadoEm = entity.sincronizadoEm,
            membro = entity.membro,
            presente = entity.presente
        )
    }
}