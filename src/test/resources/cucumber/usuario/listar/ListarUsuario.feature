#language: pt
Funcionalidade: Listar usuarios

  Contexto: 
    Dado que estou logado no sistema como administrador

  Cenario: Deve exibir mensagem quando nao houver usuarios
    Dado que nao existem usuarios cadastrados
    Quando buscar usuarios
    Entao exibe "Nenhum usuario cadastrado."

  Esquema do Cenario: Deve buscar usuario por CPF
    Dado que exista um usuario "James" com cpf "01234567890"
    E que exista um usuario "Rita" com cpf "02128552044"
    E que informei o cpf "<cpfInformado>"
    Quando buscar usuarios
    Entao retorna o usuario "<nomeUsuarioEncontrado>"

    Exemplos: 
      | cpfInformado | nomeUsuarioEncontrado |
      |  01234567890 | James                 |
      |  02128552044 | Rita                  |
