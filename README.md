# ingressoFacil
Projeto construído como desafio após um treinamento de Spring MVC. Apresento ele como um todo nesse vídeo.
https://youtu.be/5OV34ABaSdg

Nesse projeto usei Java com Spring (Data Jpa, Security, MVC) , MySQL de banco de dados, Thymeleaf e bootstrap. 

Para adicionar shows e os locais de evento você deve logar como admin.
- Login: admin
- Senha: Admin

Para logar-se como usuário, utilize a funcionalidade de cadastro na tela de login

Nele implementei:

Menus personalizados por tipo de usuário (não autenticado, autenticado e adm autenticado).

- Adm pode criar, visualizar, atualizar e remover (CRUD) dos locais de evento (casa de show) e dos eventos os shows em si (eventos). Mais avisos ao usuário.

- banco de dados MySql
  - login: root
  - senha: root

Usuário não logado consegue ver somente os shows disponíveis (menu só aparece a home e botão para login).

Cadastro de usuário

Usuário logado que tem no menu os shows disponíveis e histórico de compras. 
Usuario logado pode fazer compras.

Ingressos restantes não ficam negativos.
