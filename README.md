### Table of Contents

- [Desafio Insight informática](#desafio-cnsight-informática)
- [Como utilizar](#como-utilizar)

# Desafio Insight informática

Este projeto não é compatível com TomCat de versões menores que 10.1.

Por favor use uma versão do Tomcat compátivel.

Para acessar a aplicação depois deploy, utilize a url:
http://localhost:8080/ponto/registro

A porta pode variar de acordo com a instalação do TomCat.

Obrigado pela Oportunidade e espero poder fazer parte do time Insight!

# Como utilizar 

A aplicação consiste em quatro tabelas, duas de entrada e duas de saída,
onde a primeira representa o horário de trabalho definido pela empresa e a segunda
representa o horário que o funcionário cumpriu. Ao entrar com até 3 registros de
horário de trabalho e n registros de marcações do funcionários e enviar, 
as tabelas de saída irão exibir as horas extras e os atrasos feitos pelo funcionário.

Exemplo:

### Horário de trabalho
| Entrada | Saida     |           
| -------- | ------- |
| `08:00` | `12:00` | 
| `--:--` | `--:--` | 
| `--:--` | `--:--` | 

### Marcações
| Entrada | Saida     |           
| -------- | ------- |
| `07:00` | `11:00` | 
| `--:--` | `--:--` |  
| `--:--` | `--:--` | 

### Horas Extras
| Entrada | Saida     |           
| -------- | ------- |
| `07:00` | `8:00` | 
| `--:--` | `--:--` |  
| `--:--` | `--:--` | 

### Atrasos
| Entrada | Saida     |           
| -------- | ------- |
| `11:00` | `12:00` | 
| `--:--` | `--:--` |   
| `--:--` | `--:--` |