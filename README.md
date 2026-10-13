# MotorApp — API com Deploy Contínuo no Azure

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![Azure](https://img.shields.io/badge/Azure_App_Service-0078D4?logo=microsoftazure&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/CI%2FCD-GitHub_Actions-2088FF?logo=githubactions&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle_DB-F80000?logo=oracle&logoColor=white)

API REST para cadastro de **veículos e seus proprietários**, com deploy contínuo no **Azure App Service** via **GitHub Actions**. A cada push na `main`, o projeto é compilado com Maven e publicado automaticamente.

Também existe uma versão em container: [Checkpoint-DevOps6](https://github.com/RenanCCastilho/Checkpoint-DevOps6).

## Endpoints

| Recurso | Rota base | Operações |
|---|---|---|
| Proprietários | `/proprietarios` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Veículos | `/veiculos` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |

**Exemplo — cadastrar proprietário**

```json
POST /proprietarios
{
  "nome": "Maria Souza",
  "cidade": "São Paulo",
  "telefone": "(11) 99999-0000"
}
```

**Exemplo — cadastrar veículo** (use o id de um proprietário já cadastrado)

```json
POST /veiculos
{
  "modelo": "Onix",
  "montadora": "Chevrolet",
  "anoFabricacao": 2023,
  "km": 0.0,
  "proprietario": { "id": 1 }
}
```

## Como executar localmente

1. Crie as tabelas executando o [`DDL_BD.txt`](DDL_BD.txt) no seu banco Oracle.
2. Rode a aplicação:

```bash
export DB_USERNAME=seu_usuario DB_PASSWORD=sua_senha
./mvnw spring-boot:run
```

## Deploy no Azure App Service

1. **Banco:** execute o `DDL_BD.txt` no Oracle (pelo SQL Developer, por exemplo).
2. **Web App:** no portal do Azure, crie um App Service com pilha **Java 17**, na região **Brazil South**.
3. **Implantação:** habilite a implantação contínua, autorize o GitHub e selecione este repositório na branch `main`.
4. **Rede:** deixe o acesso público ativado. O Application Insights pode ficar desabilitado.
5. **Variáveis:** em *Configuração → Configurações do aplicativo*, defina `DB_USERNAME` e `DB_PASSWORD`.
6. **Pipeline:** revise e crie o recurso. O Azure gera o workflow em `.github/workflows/`, e o build e o deploy podem ser acompanhados na aba **Actions**.

> A raiz do Web App não tem página inicial. Acesse diretamente `/proprietarios` ou `/veiculos`.

---

Projeto acadêmico desenvolvido na **FIAP** (DevOps Tools & Cloud Computing, 2023).
