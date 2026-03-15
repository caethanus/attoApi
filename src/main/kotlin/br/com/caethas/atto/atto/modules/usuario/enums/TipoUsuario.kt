package br.com.caethas.atto.atto.modules.usuario.enums

enum class TipoUsuario(val value: Int, val label: String) {
    ADMIN(1, "Administrador"),
    PRESIDENTE(2, "Presidente"),
    DIRETOR(3, "Diretor"),
    ASSOCIADO(4, "Associado");
}