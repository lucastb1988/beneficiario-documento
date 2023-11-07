API de Beneficiarios
======================================
Sistema Api de Beneficiarios - nome do projeto = beneficiario-documento.


Introdução
-----------------------------------------
API dedicada a atender as necessidades dos processos de beneficiario e documentos.


Documentação API
-----------------------------------------
SWAGGER
http://localhost:8080/swagger-ui.html


Rodando o sistema
-----------------------------------------
Ao buildar o projeto já terá alguns registros salvos no banco H2 (dbService.instanciarDataBase()), deve ser chamado o
endpoint /login para geração de token manual. Deve-se utilizar o valor de user "lucas.t.banin@gmail.com" ou
"gustavo.t.banin@gmail.com" neste endpoint /login ou então criar um usuario manualmente no endpoint /usuarios para
posterior geração de token. Com esse token em mãos para cada endpoint solicitado abaixo utilizar no header o campo token
e o valor do token recuperado no endpoint /login.
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.