sealed class ApiExceptions implements Exception {
  final String message;
  ApiExceptions(this.message);
}

class NotFoundException extends ApiExceptions {
  NotFoundException([String message = 'Não encontrado.']) : super(message);
}

class BadRequestException extends ApiExceptions {
  BadRequestException([String message = 'Requisição inválida.']) : super(message);
}

class ServerErrorException extends ApiExceptions {
  ServerErrorException([String message = 'Erro interno do servidor.']) : super(message);
}

class UnauthorizedException extends ApiExceptions {
  UnauthorizedException([String message = 'Não autorizado.']) : super(message);
}