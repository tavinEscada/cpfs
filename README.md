# TodosOsCPFs
Código em Java que escreve no terminal todos os CPFs válidos do Brasil (para fins estritamente acadêmicos).
# Funcionamento
A implementação possui um algoritmo usado para gerar CPFs feito com base em algoritmo semelhante que verifica se um dado CPF é válido ou não, sendo este usado comparando os dígitos verificadores (os dois últimos, após o traço) do CPF a ser conferido com os dígitos verificadores calculados a partir dos demais dígitos (os 9 antes do traço).
## Algoritmo que calcula os dígitos verificadores
Para o cálculo do dígito verificador 1, multiplica-se o os 9 dígitos por um multiplicador que vai de 10 (que multiplica o primeiro dígito) a 2 (que multiplica o nono dígito) e os resultados são somados; digamos que tal soma seja referida como 's', que é dado por:
​

<img width="194" height="68" alt="formulaMaluca" src="https://github.com/user-attachments/assets/e773f5da-d033-41b4-8cc7-e59aac336e06" />


Na fórmula, 'i', variando de 0 a 8, faz com que '(10 - i)' varie de 10 a 2, e que 'v' seja cada item do vetor, sendo 'vi' o elemento na posição i do vetor. 
A soma obtida é então dividida por 11, e o resto da divisão é analisado: se o resto da divisão for menor que 2, o digito verificador 1 calculado é definido como 0 para a combinação de 9 dígitos em questão. Caso contrário, o valor atribuído ao dígito é o resto da divisão citada subtraído de 11:

<img width="262" height="111" alt="ab" src="https://github.com/user-attachments/assets/df17cc1f-e1e8-41a5-9c0a-25445aee1c3c" />

O dígito verificador 2 é gerado de maneira semelhante, mas com 'i' variando de 0 a 9, pois adiciona-se ao array, antes tendo nove dígitos, o dígito verificador calculado e, assim, '(10 - i)' varia de 11 a 2.

## Digitando os CPFs válidos
Para gerar CPFs válidos, foram usados nove laços de repetição encapsulados para gerar todas as combinações de nove dígitos e, para cada combinação, usa-se a lógica abordada anteriormente para gerar a única (se existir) possibilidade de dígitos verificadores para cada combinação.

<img width="513" height="365" alt="lacosDv" src="https://github.com/user-attachments/assets/1d51d20b-8068-40c6-ad67-1052c293efe5" />

Além disso, é feita uma última verificação: CPFs com todos os dígitos iguais, mesmo que passem no algoritmo (como 000.000.000-00), não são válidos, e previne-se tal situação antes de exibir o CPF.

<img width="458" height="178" alt="igualdade" src="https://github.com/user-attachments/assets/78562696-5420-49a5-b435-cc2ddaba140c" />

Por fim, foi usada a função que formata o CPF a ser escrito, inserindo os pontos e o traço em cada CPF:

<img width="456" height="469" alt="printa" src="https://github.com/user-attachments/assets/639606d5-38e7-4094-8161-e79b40c78370" />

# Complexidade
Temos tempo constante de execução da operação principal (geração dos CPFs válidos), mas, como cada um dos 9 laços de repetição encapsulados na geração é executado 10 vezes, temos *10^9* operações referentes a cada um dos 2 dígitos verificadores, ou seja, 1.000.000.000 de operações para cada dígito verificador (2 bilhões ao todo).

```
for(int a = 9; b >= 0; a--){  //10 iterações
  for(int b = 9; b >= 0; b--){ //10 * 10 = 100
    for(int c = 9; c >=0; c--){ //10 * 10 * 10 = 1.000
                  ...               
          10^9 iterações totais
```
Assim, conclui-se que esse tipo de implementação representa custo computacional significativamente desnecessário, mas existe valor de análise marcante acerca d
