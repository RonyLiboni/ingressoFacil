# ingressoFacil
Projeto construído como desafio após um treinamento de Spring MVC. Apresento ele como um todo nesse vídeo.
https://youtu.be/5OV34ABaSdg

Nesse projeto usei Java com Spring (Data Jpa, Security, MVC) , MySQL de banco de dados, Thymeleaf e bootstrap. 

Nele implementei:

Menus personalizados por tipo de usuário (não autenticado, autenticado e adm autenticado).

Adm pode criar, visualizar, atualizar e remover (CRUD) dos locais de evento (casa de show) e dos eventos os shows em si (eventos). Mais avisos ao usuário.
login: admin
senha: admin

banco de dados 
login: root
senha: root

Usuário não logado consegue ver somente os shows disponíveis (menu só aparece a home e botão para login).

Cadastro de usuário

Usuário logado que tem no menu os shows disponíveis e histórico de compras. 
Usuario logado pode fazer compras.

Ingressos restantes não ficam negativos.
