# Simulador_Rede_Social

**Simulador de Rede Social - README**

Este é um projeto de simulador de rede social desenvolvido com a utilização do banco de dados SQLite, apresentando detalhes específicos sobre sua estrutura, linguagens e ferramentas utilizadas.

**Banco de Dados: SQLite**

Motivo da Escolha: A escolha pelo SQLite foi baseada na familiaridade e experiência prévia. Já tive experiências anteriores com este banco de dados tanto durante meus estudos na faculdade quanto em projetos profissionais, o que facilitou a tomada de decisão e agilizou o desenvolvimento.

**Estrutura do Banco de Dados:**
Foram criadas três tabelas principais:
1. Tabela "Usuarios"
2. Tabela "Amigos"
3. Tabela "Mensagens"

Além disso, foram projetadas mais duas tabelas, "User" e "Login_Historico", que não foram utilizadas no desfecho do projeto, mas foram planejadas para eventual necessidade.

**Operações SQL Utilizadas:**
Durante o desenvolvimento do projeto, utilizei as operações básicas do SQL:
- DELETE
- UPDATE
- SELECT
- INSERT

**Linguagem e Ambiente de Desenvolvimento:**
Para a criação do back-end e da interface do simulador, utilizei a linguagem Java, com o ambiente de desenvolvimento Eclipse. Optei pelo Eclipse por sua simplicidade e facilidade na criação de interfaces gráficas. Como este era meu primeiro projeto de tal escala, preferi utilizar uma ferramenta com a qual eu estava mais familiarizado, mesmo que outras opções mais completas como IntelliJ IDEA estivessem disponíveis.

**Interfaces Criadas:**
Foram desenvolvidas sete interfaces para interação com o simulador:
1. Adicionar_Amigos
2. Enviar_Mensagens
3. Excluir_Amigos
4. Ver_Amigos
5. View_Cadastro
6. View_Primeira_Tela (Tela de Login)
7. View_Segunda_Tela (Menu de Opções)

As interfaces foram criadas manualmente, minimizando a utilização extensiva de código para agilizar o processo de desenvolvimento.

**Classes Criadas:**
Duas classes principais foram implementadas no projeto:
1. Classe "Connect": Responsável por estabelecer a conexão com o banco de dados SQLite e gerenciar a comunicação entre as interfaces e o banco de dados.
2. Classe "Main": Utilizada para agrupar códigos de conexão com o banco de dados e de interação entre as interfaces.

**Utilização de arquivo pom.xml:**
O arquivo pom.xml foi utilizado para adicionar propriedades e configurar a conexão com o banco de dados. Além disso, essa configuração incluiu a especificação da versão do Java (3.21.0.1) utilizada no projeto. Houve a importação da pasta do Java 3.44.00 para o Eclipse para permitir o uso de algumas bibliotecas mais recentes.

**Classes Model:**
Foram criadas três classes model - "Amigos", "Mensagens" e "Usuarios" - com o mesmo nome das tabelas do banco de dados. Estas classes continham métodos void, getters e conexões para facilitar as chamadas do banco de dados pelas interfaces.

**Package "View":**
Um package "View" foi criado para abrigar o back-end e as interfaces do projeto.

