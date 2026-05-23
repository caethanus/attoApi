import 'dart:convert';
import 'package:atto_api/src/shared/exceptions/api_exceptions.dart';
import 'package:vaden/vaden.dart';

class ApiResponseHelper {

  static Response ok(dynamic data) => _buildResponse(200, true, 'Sucesso.', data);

  static Response okList(List<dynamic> data) => _buildResponse(200, true, 'Sucesso.', data);

  static Response created(dynamic data) => _buildResponse(201, true, 'Criado com sucesso.', data);

  static Response noContent() => _buildResponse(204, true, 'Removido com sucesso.', null);

  static Response notFound([String message = 'Não encontrado.']) =>
      _buildResponse(404, false, message, null);

  static Response badRequest([String message = 'Requisição inválida.']) =>
      _buildResponse(400, false, message, null);

  static Response serverError([String message = 'Erro interno do servidor.']) =>
      _buildResponse(500, false, message, null);

  static Response fromException(dynamic e) {
    switch(e) {
      case NotFoundException:
        return notFound(e);
      case BadRequestException:
        return badRequest(e);
      case ServerErrorException:
        return serverError(e);
      default:
        return serverError(e);
    }
  }

  static Response _buildResponse(
      int statusCode,
      bool success,
      String message,
      dynamic data,
      ) {
    return Response(
      statusCode,
      body: jsonEncode({
        'statusCode': statusCode,
        'success':    success,
        'message':    message,
        if (data != null) 'data': data,
      }),
      headers: {'content-type': 'application/json'},
    );
  }
}