# 🌟 LumiGuard

Sistema Web para **denúncia de falhas na iluminação pública**, com visualização no mapa e uso de **inteligência artificial (IA)** para **previsão da prioridade** das denúncias com base no bairro.

---

## 🔧 Tecnologias Utilizadas

* **Java 17**: Linguagem principal do backend.
* **Spring Boot 3.x**: Framework para construção de aplicações web robustas.
* **Spring Data JPA**: Para acesso e persistência de dados.
* **H2 Database (modo dev)**: Banco de dados em memória para desenvolvimento.
* **Bootstrap 5**: Framework frontend para design responsivo.
* **jQuery e JS**: Para elementos interativos no frontend.
* **OpenStreetMap + Leaflet**: Para exibição de mapas interativos.
* **Weka (IA com .arff e .model)**: Software de machine learning para funcionalidades de IA.

---

## 🚀 Funcionalidades

### 💡 Público Geral

* **Tela Inicial Explicativa**: Apresenta uma visão geral do sistema.
* **Envio de Denúncia**: Usuários podem enviar uma denúncia com:
    * CEP, descrição e tipo de falha.
    * Mapa interativo para localização precisa.
* **Localização Automática**: Via integração com API de CEP.
* **Previsão de Prioridade por IA**: Estima a prioridade da denúncia mesmo sem login.
* **Feedback de Carregamento de Dados**: Indicações visuais durante o processamento de dados.
* **Validação de CEP**: Garante que apenas números sejam inseridos no campo de CEP.

### 🔐 Login (para Uso Interno da Prefeitura)

* **Autenticação**: Login seguro usando e-mail e senha.
* **Senha Criptografada**: Senhas são criptografadas com BCrypt.
* **Tela de Login Responsiva**: Adapta-se a vários tamanhos de tela.
* **Funcionalidade Futura**: Perfis de funcionários para gestão e acompanhamento das denúncias.

### 🧠 Inteligência Artificial

* **Integração com Weka**: Utiliza o Weka com arquivos `.arff` (arquivo de treinamento) e `.model` (modelo treinado).
* **Treinamento com Dados Históricos**: Treinado usando dados históricos de bairros e suas prioridades correspondentes.
* **Previsão Automática de Prioridade**: Prevê automaticamente a prioridade de novas denúncias.

---

## 🛠️ Como Rodar o Projeto

1.  **Clone o repositório**

    ```bash
    git clone [https://github.com/seu-usuario/lumiguard.git](https://github.com/seu-usuario/lumiguard.git)
    cd lumiguard
    ```

2.  **Execute com Maven ou sua IDE**

    O banco de dados H2 será inicializado automaticamente. Um script `data-denuncias.sql` opcional pode ser configurado no `application.properties` para carregamento inicial de dados.

3.  **Acesse**

    * **Sistema**: `http://localhost:8080/lumiguard`
    * **H2 Console**: `http://localhost:8080/lumiguard/h2-console`

---

## 📁 Estrutura dos Arquivos de IA

```bash
src/main/resources/weka/
├── denuncias.arff          # Arquivo de dados para treinamento (bairro x prioridade)
└── modelo.model            # Arquivo do modelo treinado (gerado com Weka)
