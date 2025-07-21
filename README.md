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

<img alt="conta" src="https://github.com/user-attachments/assets/9c28edf5-5bc6-4abf-ac08-ced571f0adde" />

O dígito verificador 2 é gerado de maneira semelhante, mas com 'i' variando de 0 a 9, pois adiciona-se ao array, antes tendo nove dígitos, o dígito verificador calculado e, assim, '(10 - i)' varia de 11 a 2.

## Digitando os CPFs válidos
Para gerar CPFs válidos, foram usados nove laços de repetição encapsulados para gerar todas as combinações de nove dígitos e, para cada combinação, usa-se a lógica abordada anteriormente para gerar a única (se existir) possibilidade de dígitos verificadores para cada combinação.

<img alt="dv" src="https://github.com/user-attachments/assets/ed78d27b-5642-4169-9ff8-9cd51883992b" />

Além disso, é feita uma última verificação: CPFs com todos os dígitos iguais, mesmo que passem no algoritmo (como 000.000.000-00), não são válidos, e previne-se tal situação antes de exibir o CPF.

<img alt="exi" src="https://github.com/user-attachments/assets/57e940d6-2d3f-40df-9300-c258c88f01df" />

Na imagem acima, é usada a função que verifica se todos os números do vetor 'cpf' são iguais; só se exibe os que não têm os dígitos todos iguais e tal função está representada abaixo:

<img alt="sla" src="https://github.com/user-attachments/assets/c1a855a4-ef97-4b73-8b44-981a0cecfc2d" />

Por fim, foi usada a função que formata o CPF a ser escrito, inserindo os pontos e o traço em cada CPF:

<img alt="formulaMaluca" src="https://github.com/user-attachments/assets/b3fd506f-3492-4e94-88ce-77028c0a4939" />

# Complexidade

