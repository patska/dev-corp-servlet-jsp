# dev-corp-1bim-lista
## Checklist
:white_check_mark: - Primeiro Exercicio

:white_check_mark: - Segundo Exercicio

:white_check_mark: - Terceiro Exercicio

:white_check_mark: - Logs para o terceiro exercício
<br/>
<br/>
Lista de exercícios para entrega referentes ao primeiro bimestre da matéria de Desenvolvimento Corporativo.

**Primeiro exercício**. (Valor 1,0 ponto) Crie uma servlet para gerar uma tabela HTML de conversão Milhas por hora (mph) para Km por hora (km/h) entre 10 e 200 Milhas por hora com incrementos de 10 em 10. 
   
| mph  | km/h  |
|---|---|
| 1.0  | 1.6093  |  


**Segundo exercício**. Crie o JSP temperatura.jsp que imprima uma tabela HTML de conversão Celsius-Fahrenheit entre -50 e 150 graus Celsius com incrementos de 10 em 10.

``A fórmula é °F = °C × 1, 8 + 32 ``

**Terceiro exercício**. (Valor 2,0 ponto) Crie uma página HTML com um formulário onde o usuário irá informar o salário bruto. Este formulário irá enviar os dados pelo método GET para uma página JSP que irá calcular o salário líquido, descontando o INSS, conforme a seguinte tabela:


| Salário (R$)  | Alíquota (%)  |
|---|---|
| Até 1.045,00   | 7,5%  |
| De 1.045,01 até 2.089,60   | 9,0%  |
| De 2.089,61 até 3.134,40   | 12%  |
| De 3.134,41 até 6.101,06   | 14%  |  

*Exemplos de como calcular o desconto do INSS*

Entre cada parcela, o cálculo é feito considerando o máximo e o mínimo destas faixas e a alíquota a ser aplicada. Enquanto o valor do salário não é atingido, é considerado o teto de cada faixa de contribuição.

Exemplo de cálculo do desconto do INSS para uma base de contribuição de R$ 3.000,00:

- 1ª Faixa Salarial: 1.045,00 x 7,5% = 78,38
- 2ª Faixa Salarial: [2.089,60 – 1.045,00 = 1.044,60] x 9,00% = 94,01
- 3ª Faixa Salarial: que atinge a base de contribuição: [3.000,00 – 2.089,60 = 910,40] x 12,00% = 109,25 
-  Total do desconto de INSS: 109,25 + 94,01 + 78,38 = R$ 281,64 

Esse valor de **R$ 281,64** é o que será descontado de INSS. 


