package br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.repository

import br.com.caethas.atto.atto.modules.diretoria.submodules.cargo.entity.CargoEntity
import br.com.caethas.atto.atto.shared.base.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface CargoRepository : BaseRepository<CargoEntity>