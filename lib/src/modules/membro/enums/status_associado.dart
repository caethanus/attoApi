enum StatusAssociado {
  ativo(0, 'Ativo'),
  inativo(1, 'Inativo'),
  desligado(2, 'Desligado'),
  inadimplente(3, 'Inadimplente');

  final int value;
  final String label;

  const StatusAssociado(this.value, this.label);

  static StatusAssociado fromValue(int value) {
    return StatusAssociado.values.firstWhere(
          (e) => e.value == value,
      orElse: () => StatusAssociado.inativo,
    );
  }

  Map<String, dynamic> toJson() => {'value': value, 'label': label};
}