# Documentação do Projeto: Concatenador de Texto Swing

Este projeto é uma aplicação Java desenvolvida utilizando Swing para criar uma interface gráfica simples que permite concatenar textos com diferentes operações baseadas no input do usuário. Ele é útil para formatações de strings e geração de comandos SQL personalizados.
Excelente ferramenta para criar Scripts SQL INSERT para popular banco de dados com milhões de registros.

## Funcionalidades

A aplicação possui as seguintes funcionalidades principais:

1. **Concatenar Caractere**:
   - O usuário pode inserir um caractere em um campo de texto e adicionar este caractere no início e no final de cada linha de texto fornecida.

2. **Gerar Comandos SQL**:
   - O usuário pode concatenar um texto base de SQL com o conteúdo do `JTextArea`, adicionando também sufixos e prefixos para gerar comandos SQL formatados corretamente.

## Estrutura da Interface

A interface gráfica é composta pelos seguintes elementos:

### Componentes Gráficos

1. **JTextField**:
   - `textField`: Campo para inserir o caractere que será concatenado ao texto.
   - `textFieldInsertSql`: Campo para inserir a string de base para comandos SQL.
   - `textFieldParanteses`: Campo para inserir o sufixo (geralmente parênteses ou delimitadores) para os comandos SQL.

2. **JTextArea**:
   - Componente para entrada e saída de texto que é processado pelo usuário.

3. **Botões**:
   - `Concatenar Caractere`: Adiciona o caractere especificado ao início e ao final de cada linha no `JTextArea`.
   - `Concatenar SQL`: Concatena o texto do `textFieldInsertSql` e o do `textFieldParanteses` ao conteúdo do `JTextArea`, processando linha por linha.

### Layout

- **Painel Superior**: Contém os campos de texto para entrada de caracteres e SQL.
- **Centro**: Inclui o `JTextArea` com barra de rolagem.
- **Painel Inferior**: Inclui os botões de ação.

## Exemplo de Uso

### Entrada

#### Texto no `JTextArea`:
```
'2079-01-01 00:00:00.000',1,3,'Confraternização Universal'
'2079-11-15 00:00:00.000',1,3,'Proclamação da República'
```

#### Texto no `textFieldInsertSql`:
```
INSERT INTO TBL_BA_FERIADOS (DT_FERIADO,ID_LOCAL,ID_TIPO,DS_MOTIVO) VALUES (
```

#### Texto no `textFieldParanteses`:
```
);
```

### Saída Esperada no `JTextArea`:
```
INSERT INTO TBL_BA_FERIADOS (DT_FERIADO,ID_LOCAL,ID_TIPO,DS_MOTIVO) VALUES ('2079-01-01 00:00:00.000',1,3,'Confraternização Universal');
INSERT INTO TBL_BA_FERIADOS (DT_FERIADO,ID_LOCAL,ID_TIPO,DS_MOTIVO) VALUES ('2079-11-15 00:00:00.000',1,3,'Proclamação da República');
```

## Como Executar

### Requisitos

- **Java Development Kit (JDK)**: Versão 8 ou superior.
- **Maven**: Para gerenciar dependências e construir o projeto.

### Passos

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd <DIRETORIO_DO_PROJETO>
   ```

3. Compile e execute o projeto usando o Maven:
   ```bash
   mvn clean compile exec:java
   ```

4. A interface gráfica será aberta, permitindo o uso das funcionalidades descritas.

## Estrutura do Código

### Classes Principais

- **TextAreaConcatenator**:
  - Classe principal que inicializa a interface e implementa os ActionListeners para os botões.

### Principais Métodos

- `buttonConcatenateChar.addActionListener`:
  - Processa cada linha do `JTextArea` para adicionar o caractere no início e no final da linha.

- `buttonConcatenateSql.addActionListener`:
  - Concatena a string base de SQL com cada linha do `JTextArea` e adiciona o sufixo fornecido.
