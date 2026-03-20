package br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.mapper

import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.dto.RegistroPresencaDto
import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import br.com.caethas.atto.atto.shared.base.BaseMapper

class RegistroPresencaMapper : BaseMapper<RegistroPresencaEntity, RegistroPresencaDto>() {
    override fun toEntity(d: RegistroPresencaDto): RegistroPresencaEntity {
        return RegistroPresencaEntity(
            membro = d.membro,
            presente = d.presente,
            listaPresenca = d.listaPresenca
        ).apply {
            id = d.baseDto.id
            criadoEm = d.baseDto.criadoEm
            atualizadoEm = d.baseDto.atualizadoEm
            deletadoEm = d.baseDto.deletadoEm
            sincronizadoEm = d.baseDto.sincronizadoEm
        }
    }

    override fun toDto(e: RegistroPresencaEntity): RegistroPresencaDto {
        return RegistroPresencaDto(
            baseDto = BaseDto(
                id = e.id,
                criadoEm = e.criadoEm,
                atualizadoEm = e.atualizadoEm,
                deletadoEm = e.deletadoEm,
                sincronizadoEm = e.sincronizadoEm
            ),
            membro = e.membro,
            presente = e.presente,
            listaPresenca = e.listaPresenca
        )
    }

    override fun updateEntity(
        e: RegistroPresencaEntity,
        d: RegistroPresencaDto
    ): RegistroPresencaEntity {

        e.membro = d.membro
        e.presente = d.presente
        e.listaPresenca = d.listaPresenca

        e.criadoEm = d.baseDto.criadoEm
        e.criadoEm = d.baseDto.criadoEm
        e.deletadoEm = d.baseDto.deletadoEm
        e.sincronizadoEm = d.baseDto.sincronizadoEm
        return e
    }

}