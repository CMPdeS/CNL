# CNL    COVID-19 NOTIFICATION LANGUAGE

## Objetivo

A CNL é uma DSL (_Domain Specific Language_) com o intuito de favorecer a interoperabilidade na notificação de casos de
COVID-19. Foi desenvolvida como trabalho final da disciplina **PPGTI1007    LINGUAGENS DE DOMÍNIO ESPECÍFICO    T01**,
do **Mestrado Profissional    Programa de Pós-graduação em Tecnologia da Informação do Instituto Metrópole Digital da
Universidade Federal do Rio Grande do Norte (PPGTI-IMD/UFRN)**.

## Autores

Cezar Miranda (cezarmiranda@gmail.com / https://github.com/CMPdeS)  
Denis Orozco (orozcodenis@gmail.com)

## Stack e Ferramentas

A CNL foi desenvolvida utilizando ANTLv4, Java 8, Python 3.9 e utilizando as IDEs IntelliJ Idea e PyCharm da JetBrains.

## Visão Geral

A CNL define estruturas de dados para _**Pacientes, Sinais Vitais, Comorbidades, Sintomas, Exames e Vacinas**_. Cada
estrutura de dados é descrita nas seções abaixo. A sintaxe para a definição das estruturas de dados é baseada em **_JSON_**
(_JavaScript Object Notation_).

## Objetos

Os tipos de dados reconhecidos pelo programa. Podem ser dos tipos Paciente, Sintoma, Sinal, Comorbidade, Exame, Vacina.

### Paciente

Estrutura de dados segue o padrão abaixo.  
Obrigatório apresentar nome, CPF e data de nascimento.

    {
       nome : texto*, //aceita acentuação, maúsculas, minúsculas e espaços, sem números
       cpf : texto*, //aceita máscara de CPF ou 11 números corridos
       nascimento : data, //mascara "yyyy-mm-dd"
       diagnostico : TIPODIAGNOSTICO**, 
       comorbidades : Lista de TIPOCOMORBIDADE**, 
       sinais : Lista de Sinal***,
       sintomas : Lista de Sintoma***,
       exames : Lista de Exame***,
       vacinas : Lista de Vacina***
    }

*possui restrições conforme comentários  
**constantes literais conforme seção "Campos de valores fixos e literais" abaixo  
***Lista do tipo de objeto conforme próximas seções

### Sintoma

Estrutura de dados segue o padrão abaixo.
Obrigatório apresentar tipo e data.

    {
      cpf: texto*, //aceita máscara de CPF ou 11 números corridos
      tipo: TIPOSINTOMA**, 
      data : data-e-hora //mascara "yyyy-mm-dd hh:mm:ss"
    }
*possui restrições conforme comentários. Preenchimento opcional!
**constantes literais conforme seção "Campos de valores fixos e literais" abaixo  
***Lista do tipo de objeto conforme próximas seções

### Sinal

Estrutura de dados segue o padrão abaixo.
Obrigatório apresentar tipo, data e leitura.

    {
      cpf: texto*, //aceita máscara de CPF ou 11 números corridos
      tipo: TIPOSINAL**, 
      data : data-e-hora //mascara "yyyy-mm-dd hh:mm:ss"
      leitura : Temperatura ou Percentual //temperatura validas entre 34.0 ºC e 42.9 ºC, percentual entre 0% e 99%
    }
*possui restrições conforme comentários. Preenchimento opcional!     
**constantes literais conforme seção "Campos de valores fixos e literais" abaixo  
***Lista do tipo de objeto conforme próximas seções

### Exame

Estrutura de dados segue o padrão abaixo.
Obrigatório apresentar tipo, data e resultado.
Se o tipo é SOROLOGIA, obrigatório apresentar IgG e IgM.

    {
      cpf: texto*, //aceita máscara de CPF ou 11 números corridos
      tipo: TIPOEXAME**, 
      data : data-e-hora //mascara "yyyy-mm-dd hh:mm:ss"
      resultado : TIPORESULTADO**,
      igg : Double, //apenas para o tipo SOROLOGIA
      igm : Double  //apenas para o tipo SOROLOGIA
    }
*possui restrições conforme comentários. Preenchimento opcional!  
**constantes literais conforme seção "Campos de valores fixos e literais" abaixo  
***Lista do tipo de objeto conforme próximas seções

### Vacina

Estrutura de dados segue o padrão abaixo.
Obrigatório apresentar tipo, data, dose, serial e lote.

    {
      cpf: texto*, //aceita máscara de CPF ou 11 números corridos
      tipo: TIPOVACINA**, 
      data : data-e-hora //mascara "yyyy-mm-dd hh:mm:ss"
      dose : 1ª ou 2ª
      serial : numero serial (números, hifens e letras)
      lote : lote (números, hifens e letras)
    }
*possui restrições conforme comentários. Preenchimento opcional!  
**constantes literais conforme seção "Campos de valores fixos e literais" abaixo  
***Lista do tipo de objeto conforme próximas seções

## Campos de valores fixos e literais
A lista completa das opções válidas para os campos de tipos com literais fixos pode ser vista abaixo.

Como uma regra geral, onde houver espaços será necessário utilizar aspas duplas. Isto também vale para datas, nomes,
etc.

Comorbidades :

    IDOSO 
    OBESIDADE 
    DIABETES
    HIPERTENSÃO 
    CARDIOPATIA
    NEOPLASIA
    NEFROPATIA
    IMUNODEFICIÊNCIA
    TRANSPLANTADO
    HEPATOPATIA 
    HEMATOPATIA 
    NEUROPATIA 
    PNEUMOPATIA

Tipos de Exames:

    RT-PCR
    "TESTE RÁPIDO"  
    SOROLOGIA  
    "ANTICORPOS TOTAIS"

Tipos de Sinal Vital:

    OXIMETRIA
    TEMPERATURA

Tipos de Sintomas:

    "CORRIMENTO NASAL"
    FEBRE
    DIARRÉIA
    "TOSSE SECA"
    CANSAÇO
    "DOR DE GARGANTA"
    DESCONFORTO
    "DOR DE CABEÇA"
    ANOSMIA
    "PERDA DO OLFATO"
    AGUSMIA
    "PERDA DO PALADAR"
    MIALGIA
    "DOR NO CORPO"
    CONJUNTIVITE
    "ERUPÇÕES CUTÂNEAS"
    "FALTA DE AR"
    "DOR NO PEITO"

Tipos de Vacina (Obs: para fins de simplificação, nomes de fabricantes e de vacinas serão considerados sinônimos)

    OXFORD
    ASTRA-ZENACA
    MODERNA
    PFIZER
    BIONTECH
    GAMALEYA
    "SPUTNIK V"
    SINOVAC
    CORONAVAC

Resultados:

    POSITIVO
    REAGENTE
    NEGATIVO
    "NÃO REAGENTE"

Diagnósticos:

    "INFECCIOSO COM SINTOMAS LEVES"
    "INFECCIOSO COM SINTOMAS MODERADOS"
    "INFECCIOSO COM SINTOMAS GRAVES"
    "INFECCIOSO COM SINTOMAS GRAVÍSSIMOS"
    DESCARTADO  
    IMUNIZADO
    VACINADO

## Operações

O programa irá reconhecer as seguintes operações:

    [variavel] = obj //atribui um paciente, sintoma, sinal, exame, vacina, comorbidade a uma variável
    paciente + exame //acumula os exames na lista de exames do paciente
    paciente + sinal //acumula o sinal vital na lista de sinais do paciente
    paciente + comorbidade //acumula a comorbidade na lista de comorbidades do paciente
    paciente + sintoma //acumula os sintomas na lista de sintomas do paciente
    paciente + vacina //acumula as vacinas na lista de vacinas do paciente
    print paciente [data] //imprime os dados completos do paciente
    comorbidade paciente //imprime apenas as comorbidades do paciente
    diagnosticar paciente [data] //calcula o diagnóstico do paciente considerando o parâmetro opcional data como referência
    sintoma paciente [data] //imprime apenas os sintomas do paciente até a data limite opcional
    sinaisvitais paciente [data] //imprime apenas os sinais do paciente até a data limite opcional
    vacina paciente [data] //imprime apenas as vacinas do paciente até a data limite opcional
    exame paciente [data] //imprime apenas os exames do paciente até a data limite opcional

## Problemas conhecidos e Limitações

Não está sendo possível utilizar caracteres acentuados nem sinais fora da tabela ASCII como ª e º.
Não está sendo feito nenhuma restrição quanto ao CPF do paciente e o CPF nos dados temporais serem diferentes
(sinais vitais, exames, vacinas).

## Exemplos

### Estrutura de Dados

Exemplo "completo" de objeto esperado (alguns campos estão repetidos apra indicar opções diferentes de preenchimento, no
entanto campos repetidos não serão aceitos).

    { 
        nome : joão,
        nome : "João da Silva Sauró",
        cpf: 06910802403,
        cpf: 069.108.024-03,
        nascimento: 1986-11-86, 
        diagnostico : "INFECCIOSO COM SINTOMAS GRAVES",
        diagnostico : IMUNIZADO,
        comorbidades : [IDOSO, DIABETES, HIPERTENSÃO, CARDIOPATIA],
        sinais: 
        [
            {
                tipo: OXIMETRIA,
                data : "2020-12-03 14:06:55",
                leitura: 97%
            },
            {
                cpf: 010.452.754-41,
                tipo: TEMPERATURA,
                data : "2020-12-03 14:02:17",
                leitura: 37.5ºC
            }
        ],
        sintomas: 
        [
            {
                tipo: FEBRE, 
                data : "2020-12-08 10:15:41"
            },
            {
                cpf: 010.452.754-41,
                tipo: "FALTA DE AR", 
                data : "2020-12-03 14:02:17"
            }
        ],
        exames : 
        [
            {
                tipo: "TESTE RÁPIDO",
                data : "2020-12-01 10:12:04",
                resultado: "NÃO REAGENTE"
            },
            {
                tipo: RT-PCR,
                data : "2020-12-03 14:24:32",
                resultado: NEGATIVO
            },
            {
                cpf: 010.452.754-41,
                tipo: SOROLOGIA,
                data : "2020-12-28 09:14:53",
                resultado: REAGENTE,
                igg: 8.0,
                igm: 0.4
            },
            {
                tipo: "ANTICORPOS TOTAIS",
                data : "2021-01-12 07:43:18",
                resultado: POSITIVO
            }
        ],
        vacinas: 
        [
            {
                tipo: OXFORD,
                data : "2021-02-10 07:39:21",
                dose: 1ª,
                serial: 21329AS3292230A-AFF31,
                lote: 34BC
            },
            {
                tipo: ASTRA-ZENACA,
                data : "2021-02-10 07:39:21",
                dose: 2ª,
                lote: 234D,
                serial: 238409D23098DA2-23A-ZZ0A
            }
        ]
    }

## Programa Completo

### Entrada de exemplo


    paciente = {nome : "Joao da Silva Biro", cpf: 01045275441, nascimento: 1979-07-12, comorbidades: [IDOSO, DIABETES, CARDIOPATIA]  
    ,  
            vacinas:  
            [  
                {  
                    tipo: ASTRA-ZENACA,  
                    data : "2021-02-10 07:39:21",  
                    dose: 2,  
                    lote: 234D,  
                    serial: 238409D23098DA2-23A-ZZ0A  
                }  
            ],  
    sinais:  
            [  
                {  
                    tipo: OXIMETRIA,  
                    data : "2020-12-05 14:06:55",  
                    leitura: 97%  
                },  
                {  
                    cpf: 010.452.754-41,  
                    tipo: TEMPERATURA,  
                    data : "2020-12-03 14:02:17",  
                    leitura: 41.5C  
                },  
                {  
                    cpf: 010.452.754-41,  
                    tipo: TEMPERATURA,  
                    data : "2021-02-03 14:02:17",  
                    leitura: 35.8C  
                }  
            ],  
    exames :  
            [  
             {  
                 tipo: "TESTE RAPIDO",  
                 data : "2020-12-01 10:12:04",  
                 resultado: "NAO REAGENTE"  
             },  
             {  
                 tipo: "ANTICORPOS TOTAIS",  
                 data : "2020-12-12 07:43:18",  
                 resultado: POSITIVO  
             }  
            ]}  
    paciente + [NEOPLASIA, NEFROPATIA]  
    paciente + PNEUMOPATIA  
    paciente + NEUROPATIA  
    paciente + {  
                   tipo: OXFORD,  
                   data : "2021-02-10 07:39:21",  
                   dose: 1,  
                   serial: 21329AS3292230A-AFF31,  
                   lote: 34BC  
               }  
    examList =  [{  
                    tipo: RT-PCR,  
                    data : "2020-12-03 14:24:32",  
                    resultado: NEGATIVO  
                },  
                {  
                    cpf: 010.452.754-41,  
                    tipo: SOROLOGIA,  
                    data : "2020-12-28 09:14:53",  
                    resultado: REAGENTE,  
                    igg: 8.0,  
                    igm: 0.4  
                }]  
    paciente + examList  
    sintomList = [  
                     {  
                         tipo: FEBRE,  
                         data : "2020-12-08 10:15:41"  
                     },  
                     {  
                         cpf: 010.452.754-41,  
                         tipo: "FALTA DE AR",  
                         data : "2020-12-03 14:02:17"  
                     }  
                 ]  
    paciente + sintomList  
    print paciente  
    diagnosticar paciente "2020-12-15 10:30:22"

### Saída Esperada

    ------------------------------------------------------------
    Paciente: Joao da Silva Biro
    CPF: 010.452.754-41
    Data de Nascimento: 12/07/1979
    ------------
    Comorbidades
    ------------
    IDOSO
    DIABETES
    CARDIOPATIA
    NEOPLASIA
    NEFROPATIA
    PNEUMOPATIA
    NEUROPATIA
    -------------
    Sinais Vitais
    -------------
    CPF: 010.452.754-41
    Tipo: TEMPERATURA
    Data: 03/12/2020 14:02:17
    leitura: 41.5C
    -------------
    Tipo: OXIMETRIA
    Data: 05/12/2020 14:06:55
    leitura: 97%
    -------------
    CPF: 010.452.754-41
    Tipo: TEMPERATURA
    Data: 03/02/2021 14:02:17
    leitura: 35.8C
    --------
    Sintomas
    --------
    CPF: 010.452.754-41
    Tipo: FALTA DE AR
    Data: 03/12/2020 14:02:17
    -------------
    Tipo: FEBRE
    Data: 08/12/2020 10:15:41
    ------
    Exames
    ------
    Tipo: TESTE RAPIDO
    Data: 01/12/2020 10:12:04
    resultado: NAO REAGENTE
    -------------
    Tipo: RT-PCR
    Data: 03/12/2020 14:24:32
    resultado: NEGATIVO
    -------------
    Tipo: ANTICORPOS TOTAIS
    Data: 12/12/2020 07:43:18
    resultado: POSITIVO
    -------------
    CPF: 010.452.754-41
    Tipo: SOROLOGIA
    Data: 28/12/2020 09:14:53
    resultado: REAGENTE
    IgG: 8.0
    IgM: 0.4
    -------
    vacinas
    -------
    Tipo: ASTRA-ZENACA
    Data: 10/02/2021 07:39:21
    dose: 2
    serial: 238409D23098DA2-23A-ZZ0A
    lote: 234D
    -------------
    Tipo: OXFORD
    Data: 10/02/2021 07:39:21
    dose: 1
    serial: 21329AS3292230A-AFF31
    lote: 34BC
    --------------------------------------------------
    Paciente: Joao da Silva Biro
    CPF: 010.452.754-41
    Diagnóstico: INFECCIOSO EM 12/12/2020 07:43:18
    --------------
    Dados do Exame
    --------------
    Tipo: ANTICORPOS TOTAIS
    resultado: POSITIVO
    
    OXIMETRIA 97%
    TEMPERATURA 41.5C (HIPERTERMIA)
    Estado Geral: GRAVÍSSIMO