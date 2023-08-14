# Coin Suey
Sistema de conversão monetária para moedas internacionais ou criptomoedas.

## Descrição
A Coin Suey API é uma ferramenta que permite a conversão de valores monetários e criptomoedas entre diferentes moedas e tokens. Ela fornece uma maneira simples e flexível de realizar conversões financeiras em diversas direções.

## Funcionalidades
- Conversão de moeda para moeda
- Conversão de moeda para criptomoeda
- Conversão de criptomoeda para moeda
- Conversão de criptomoeda para criptomoeda

## Uso básico
Acesse a API através de chamadas HTTP para realizar conversões. Abaixo estão alguns exemplos de como você pode fazer as chamadas:

### Conversão de Moeda para Moeda
**Exemplo:** Converter 100 dólares americanos (USD) para euros (EUR):

```http
GET /coins/convert?from=AMERICAN_DOLLAR&to=EURO&amount=100
```
Retorno:
```json
{
  "from": {
    "coin": "AMERICAN_DOLLAR",
    "amount": 100
  },
  "to": {
    "coin": "EURO",
    "amount": 91.6618
  },
  "dateTime": "2023-08-14T10:04:18.8284618"
}
```

### Conversão de Moeda para Criptomoeda
**Exemplo:** Converter 500 reais (BRL) para Bitcoin (BTC):

```http
GET /coins/convert?from=BRAZILIAN_REAL&to=BITCOIN&amount=500
```
Retorno:
```json
{
  "from": {
    "coin": "BRAZILIAN_REAL",
    "amount": 500
  },
  "to": {
    "coin": "BITCOIN",
    "amount": 0.003456628909
  },
  "dateTime": "2023-08-14T10:07:04.2493136"
}
```

### Conversão de Criptomoeda para Moeda
**Exemplo:** Converter 0.1 Ethereum (ETH) para dólares americanos (USD):

```http
GET /coins/convert?from=ETHEREUM&to=AMERICAN_DOLLAR&amount=0.1
```
Retorno:
```json
{
  "from": {
    "coin": "ETHEREUM",
    "amount": 0.1
  },
  "to": {
    "coin": "AMERICAN_DOLLAR",
    "amount": 184.3577
  },
  "dateTime": "2023-08-14T10:07:23.0799019"
}
```

### Conversão de Criptomoeda para Criptomoeda
**Exemplo:** Converter 200.000 Dogecoin (DOGE) para Bitcoin (BTC):

```http
GET /coins/convert?from=DOGECOIN&to=BITCOIN&amount=200000
```
Retorno:
```json
{
  "from": {
    "coin": "DOGECOIN",
    "amount": 200000
  },
  "to": {
    "coin": "BITCOIN",
    "amount": 0.5082254550
  },
  "dateTime": "2023-08-14T10:08:40.2433477"
}
```

## Moedas e Criptomoedas suportadas
A API Coin Suey suporta as seguintes moedas e criptomoedas:

### Moedas
- ARGENTINE_PESO (ARS)
- AUSTRALIAN_DOLLAR (AUD)
- AMERICAN_DOLLAR (USD)
- BRITISH_POUND (GBP)
- BRAZILIAN_REAL (BRL)
- CANADIAN_DOLLAR (CAD)
- CHINESE_YUAN (CNY)
- EURO (EUR)
- HONG_KONG_DOLLAR (HKD)
- JAPANESE_YEN (JPY)
- MEXICAN_PESO (MXN)
- RUSSIAN_RUBLE (RUB)
- SINGAPORE_DOLLAR (SGD)
- SWEDISH_KRONA (SEK)
- SWISS_FRANC (CHF)
- TURKISH_LIRA (TRY)

### Cripomoedas
- BITCOIN (BTC)
- BITCOIN_CASH (BCH)
- BINANCE_COIN (BNB)
- BINANCE_USD (BUSD)
- CARDANO (ADA)
- DOGECOIN (DOGE)
- ETHEREUM (ETH)
- ETHEREUM_CLASSIC (ETC)
- LITECOIN (LTC)
- MONERO (XMR)
- RIPPLE (XRP)
- SOLANA (SOL)
- STELLAR (XLM)
- TETHER (USDT)
- TRON (TRX)
- VECHAIN (VET)

## Pré-requisitos
- Java 17
- Maven
- Spring Boot

## Instalação
Para instalar o projeto, siga os passos abaixo:
1. Clone o repositório para o seu ambiente local: `https://github.com/ArnaldoQ15/coin-suey-api.git`. 
2. Execute o goal `mvn clean install` do Maven para compilar e construir o projeto. 
3. Execute o projeto através do goal `mvn spring-boot:run` do Maven ou a partir da sua IDE. 
4. Acesse a documentação da API através da URL `http://localhost:8080/swagger-ui/index.html`.

Agora você está pronto para utilizar a API Coin Suey! Certifique-se de seguir todas as etapas acima para garantir uma configuração adequada.

## Avisos
- A API Coin Suey utiliza a API Currency API para realizar as conversões de moedas internacionais. Uma key gratuita está configurada no projeto (application.properties) com limite de até 100 requisições/dia. Caso ultrapasse este limite, será necessário que criar uma conta na Currency API e obter uma chave de acesso. Para mais informações, acesse o site da [Currency API](https://currency.getgeoapi.com/).
- Esta API utiliza também a API Coin Ranking para realizar as conversões de criptomoedas. Uma key gratuita está configurada no projeto (application.properties) com limite de até 10.000 requisições/mês. Caso ultrapasse este limite, será necessário que criar uma conta na Coin Ranking e obter uma chave de acesso. Para mais informações, acesse o site da [Coin Ranking](https://developers.coinranking.com/api).

## Agradecimentos
- [Currency API](https://currency.getgeoapi.com/): Pela API de conversão de moedas internacionais que foi utilizada neste projeto.
- [Coin Ranking](https://developers.coinranking.com/api): Pela API de conversão de criptomoedas que foi utilizada neste projeto.
- [Weverton Silva](https://www.linkedin.com/in/weverton-silva-05b94211a/): Pelo orientação e insights valiosos durante o desenvolvimento.