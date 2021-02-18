import json
import cnl as cnl
paciente = json.loads("""{"nome" : "Joao da Silva Biro"
,"cpf" : "01045275441"
,"nascimento" : "1979-07-12"
,"comorbidades" : ["IDOSO","DIABETES","CARDIOPATIA"]
,"vacinas" : [{"tipo" : "ASTRA-ZENACA"
,"data" : "2021-02-10 07:39:21"
,"dose" : "2"
,"lote" : "234D"
,"serial" : "238409D23098DA2-23A-ZZ0A"
}]
,"sinais" : [{"tipo" : "OXIMETRIA"
,"data" : "2020-12-05 14:06:55"
,"leitura" : "97%"
},{"cpf" : "010.452.754-41"
,"tipo" : "TEMPERATURA"
,"data" : "2020-12-03 14:02:17"
,"leitura" : "41.5C"
},{"cpf" : "010.452.754-41"
,"tipo" : "TEMPERATURA"
,"data" : "2021-02-03 14:02:17"
,"leitura" : "35.8C"
}]
,"exames" : [{"tipo" : "TESTE RAPIDO"
,"data" : "2020-12-01 10:12:04"
,"resultado" : "NAO REAGENTE"
},{"tipo" : "ANTICORPOS TOTAIS"
,"data" : "2020-12-12 07:43:18"
,"resultado" : "POSITIVO"
}]
}""")
cnl.checkAndAddList(paciente,"comorbidades")
paciente["comorbidades"].extend(["NEOPLASIA","NEFROPATIA"])
cnl.checkAndAddList(paciente,"comorbidades")
paciente["comorbidades"].append("PNEUMOPATIA")
cnl.checkAndAddList(paciente,"comorbidades")
paciente["comorbidades"].append("NEUROPATIA")
cnl.checkAndAddList(paciente,"vacinas")
paciente["vacinas"].append(json.loads("""{"tipo" : "OXFORD"
,"data" : "2021-02-10 07:39:21"
,"dose" : "1"
,"serial" : "21329AS3292230A-AFF31"
,"lote" : "34BC"
}"""))
examList = [{"tipo" : "RT-PCR"
,"data" : "2020-12-03 14:24:32"
,"resultado" : "NEGATIVO"
},{"cpf" : "010.452.754-41"
,"tipo" : "SOROLOGIA"
,"data" : "2020-12-28 09:14:53"
,"resultado" : "REAGENTE"
,"igg" : "8.0"
,"igm" : "0.4"
}]
cnl.checkAndAddList(paciente,"exames")
paciente["exames"].extend(examList)
sintomList = [{"tipo" : "FEBRE"
,"data" : "2020-12-08 10:15:41"
},{"cpf" : "010.452.754-41"
,"tipo" : "FALTA DE AR"
,"data" : "2020-12-03 14:02:17"
}]
cnl.checkAndAddList(paciente,"sintomas")
paciente["sintomas"].extend(sintomList)
cnl.imprimir(paciente)
cnl.diagnosticar(paciente,"2020-12-15 10:30:22")

