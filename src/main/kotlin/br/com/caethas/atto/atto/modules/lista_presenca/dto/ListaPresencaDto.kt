import br.com.caethas.atto.atto.modules.lista_presenca.submodules.registro_presenca.entity.RegistroPresencaEntity
import br.com.caethas.atto.atto.shared.base.BaseDto
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

data class ListaPresencaDto(
    val baseDto: BaseDto,
    var dataListaPresenca: LocalDateTime,
    var registrosPresenca: MutableList<RegistroPresencaEntity> = mutableListOf()
)