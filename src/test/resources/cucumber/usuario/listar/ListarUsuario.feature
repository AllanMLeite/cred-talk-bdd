#language: pt
Funcionalidade: Listar usuarios

  Contexto: 
    Dado que estou logado no sistema como administrador

  Cenario: Deve exibir mensagem quando nao houver usuarios
    Dado que nao existem usuarios cadastrados
    Quando buscar usuarios
    Entao exibe "Nenhum usuario cadastrado."
