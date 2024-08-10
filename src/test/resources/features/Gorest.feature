#language: pt
#Author: Diogo
#Version: 1.0
#Encoding: UTF-8

@Gorest
  Funcionalidade: Criar e editar contas de usuários
    Eu como administrador do sistema, quero cadastrar, editar e excluir usuarios dos sistema

  Cenario: Cadastrar um novo usuarios na api gorest
    Dado que passou gorest token valido
    Quando envio uma request de cadastro de usuario com dados validos
    Entao o usuario deve criado corretamente
    E o status code deve ser 200