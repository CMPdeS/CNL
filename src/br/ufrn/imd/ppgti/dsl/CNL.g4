grammar CNL;

start : comando+ EOF;

comando : NOME '=' (obj|lista) #Attrib
| (obj|NOME) '+' (obj|NOME|lista) #Concat
| FUNCAO (obj | NOME) (DATA|DATAHORA)? #Method
| NOME '=' (obj|lista) ('+' (obj|lista))* #AttribConcat
;

FUNCAO : 'diagnosticar' |  'exame' | 'comorbidade' | 'sinaisvitais' | 'sintoma' | 'vacina' | 'print';

obj : '{' par (',' par)* '}' | COMORBIDADE;

par : 'nome' ':' NOME |
      'cpf' ':' CPF |
      'nascimento' ':' DATA |
      'tipo' ':' (TIPOEXAME | TIPOSINAL | TIPOSINTOMA | TIPOVACINA) |
      'leitura' ':' (TEMPERATURA | PERCENTUAL) |
      'data' ':' DATAHORA |
      'resultado' ':' RESULTADO |
      'diagnostico' ':' DIAGNOSTICO |
      ('igm' ':' | 'igg' ':') DOUBLE |
      'dose' ':' DOSE |
      'lote' ':' SERIAL |
      'serial' ':' SERIAL |
      temporal ':' lista;

temporal : 'comorbidades' | 'sinais' | 'sintomas' | 'exames' | 'vacinas';

lista: '['obj (',' obj)*']';
//CPF : [0-9]{11} | [0-9]{3}'.'[0-9]{3}'.'[0-9]{3}'-'[0-9]{2};
CPF :  ONZENUMEROS | TRESNUMEROS'.'TRESNUMEROS'.'TRESNUMEROS'-'DOISNUMEROS;
TEMPERATURA : [3][5-9]'.'[0-9] 'C' | [4][0-2]'.'[0-9] 'C';
DOUBLE : NUMEROS'.'NUMEROS;
PERCENTUAL : DOISNUMEROS'%' | NUMERO'%';
DOSE : [1-2];
DATA : QUATRONUMEROS'-'DOISNUMEROS'-'DOISNUMEROS;
DATAHORA : '"'QUATRONUMEROS'-'DOISNUMEROS'-'DOISNUMEROS' 'DOISNUMEROS':'DOISNUMEROS':'DOISNUMEROS'"';
NUMERO : [0-9];
DOISNUMEROS : [0-9][0-9];
TRESNUMEROS : [0-9][0-9][0-9];
QUATRONUMEROS : [0-9][0-9][0-9][0-9];
NUMEROS : NUMERO+;
ONZENUMEROS : NUMEROS {getText().length() == 11}?; //semantic predicate
COMORBIDADE : 'IDOSO' | 'OBESIDADE' | 'DIABETES' | 'HIPERTENSÃO' | 'CARDIOPATIA' | 'NEOPLASIA' | 'NEFROPATIA'
| 'IMUNODEFICIÊNCIA' | 'TRANSPLANTADO' | 'HEPATOPATIA' | 'HEMATOPATIA' | 'NEUROPATIA' | 'PNEUMOPATIA';
TIPOEXAME : 'RT-PCR' | '"TESTE RAPIDO"' | 'SOROLOGIA' | '"ANTICORPOS TOTAIS"';
TIPOSINAL : 'OXIMETRIA' | 'TEMPERATURA';
TIPOSINTOMA : '"CORRIMENTO NASAL"' | 'FEBRE' | 'DIARRÉIA' | '"TOSSE SECA"' | 'CANSAÇO' | '"DOR DE GARGANTA"'
| 'DESCONFORTO' | '"DOR DE CABEÇA"' | 'ANOSMIA' | '"PERDA DO OLFATO"' | 'AGUSMIA' | '"PERDA DO PALADAR"'
| 'MIALGIA' | '"DOR NO CORPO"' | 'CONJUNTIVITE' | '"ERUPÇÕES CUTÂNEAS"' | '"FALTA DE AR"' | '"DOR NO PEITO"';
TIPOVACINA : 'OXFORD' | 'ASTRA-ZENACA' | 'MODERNA' | 'PFIZER' | 'BIONTECH' | 'GAMALEYA' | '"SPUTNIK V"' | 'SINOVAC'
| 'CORONAVAC';
RESULTADO : 'POSITIVO' | 'REAGENTE' | 'NEGATIVO' | '"NAO REAGENTE"';
DIAGNOSTICO : '"INFECCIOSO 'NIVEL'"' | 'DESCARTADO' | 'IMUNIZADO' | 'VACINADO';
NIVEL : 'COM SINTOMAS LEVES' | 'COM SINTOMAS MODERADOS' | 'COM SINTOMAS GRAVES' | 'COM SINTOMAS GRAVÍSSIMOS';
//quando ocorrem ambiguidades, a primeira regra é a utilizada. Assim, para garantir que não há
//conflitos entre NOME e outras regras textuais literais, NOME deve vir por último.
//NOME : [a-zA-Z]+ | '"'[a-zA-Z ]+'"'; //nomes compostos com espaços precisam estar entre aspas duplas
NOME : [a-zA-ZáãâÁÃÂéêÉÊíÍóõôÓÕÔúüÚÜ]+ | '"'[a-zA-ZáãâÁÃÂéêÉÊíÍóõôÓÕÔúüÚÜ ]+'"'; //nomes compostos com espaços precisam estar entre aspas duplas
SERIAL : [a-zA-Z0-9-]+;
WHITESPACE : (' '|'\t'|'\r'|'\n')+ -> skip ;

/*start : comando+ EOF;

comando : NOME '=' obj #Attrib
| obj '+' obj #Concat
| 'diagnostico' obj (DATA)? #Diagnose
| 'exames' paciente (DATA)? #Exams
| 'comorbidades' paciente #Comorbid
| 'sinais' paciente (DATA)? #Signs
| 'print' obj #Print
;

obj : paciente | exame | comorbidade | sinal | sintoma | list;

paciente : '{ '
                ('nome : 'NOME |
                'cpf : 'CPF |
                'nascimento : 'DATA |
                'comorbidades : 'list |
                'sinais : 'list |
                'sintomas : 'list |
                'exames : 'list )+
           ' }';
list: '['comorbidade (',' comorbidade)*']' |
'['sinal (',' sinal)*']' |
'['sintoma (',' sintoma)*']' |
'['exame (',' exame)*']';
exame : '{ '
            ('cpf :' CPF)?
            'tipo :' TIPOEXAME
            'data :' DATAHORA
            'resultado :' RESULTADO
            ('igm :' DOUBLE
             'igg :' DOUBLE
            )?
        ' }';
comorbidade : '{ '
                  ('cpf :' CPF)?
                  'tipo :' TIPOEXAME
                  'data :' DATAHORA
                  'resultado :' RESULTADO
                  ('igm :' DOUBLE
                   'igg :' DOUBLE
                  )?
              ' }';
sinal : '{ '
            ('cpf :' CPF)?
            'tipo :' TIPOSINAL
            'data :' DATAHORA
            'leitura :' TEMPERATURA | PERCENTUAL
        ' }';
sintoma : '{ '
              ('cpf :' CPF)?
              'tipo :' TIPOSINTOMA
              'data :' DATAHORA
          ' }';

NOME : [a-zA-Z]+;
CPF : [0-9]{11} | [0-9]{3}'.'[0-9]{3}'.'[0-9]{3}'-'[0-9]{2};
DOUBLE : [0-9]+'.'[0-9]+;
TEMPERATURA : [3][5-9]'.'[0-9]  | [4][0-2]'.'[0-9] | ' ºC';
PERCENTUAL : [0-9]{1,2}' %';
DATA : [0-9]{4}'-'[0-9]{2}'-'[0-9]{2};
DATAHORA : [0-9]{4}'-'[0-9]{2}'-'[0-9]{2}' '[0-9]{2}':'[0-9]{2}':'[0-9]{2};
TIPOEXAME : 'RT-PCR' | 'TESTE RÁPIDO' | 'SOROLOGIA' | 'ANTICORPOS TOTAIS';
TIPOSINAL : 'OXIMETRIA' | 'TEMPERATURA';
TIPOSINTOMA : 'CORRIMENTO NASAL' | 'FEBRE' | 'DIARRÉIA' | 'TOSSE SECA' | 'CANSAÇO' | 'DOR DE GARGANTA'
| 'DESCONFORTO' | 'DOR DE CABEÇA' | 'ANOSMIA' | 'PERDA DO OLFATO' | 'AGUSMIA' | 'PERDA DO PALADAR'
| 'MIALGIA' | 'DOR NO CORPO' | 'CONJUNTIVITE' | 'ERUPÇÕES CUTÂNEAS' | 'FALTA DE AR' | 'DOR NO PEITO';
WHITESPACE : ' ' -> skip ;
*/