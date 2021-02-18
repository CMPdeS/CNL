import numpy as np
import itertools as it
import json
from enum import Enum
import warnings
from datetime import datetime

warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)


def checkAndAddList(left, right):
    if right not in left:
        left[right] = []


def extract_time(obj):
    try:
        return int(datetime.strptime(obj["data"], '%Y-%m-%d %H:%M:%S').timestamp())
    except KeyError:
        return 0


def format_cpf(cpf):
    if len(cpf) == 11:
        cpf = '{}.{}.{}-{}'.format(cpf[:3], cpf[3:6], cpf[6:9], cpf[9:])
    return cpf


def dados_comuns(obj):
    if "cpf" in obj:
        cpf = obj["cpf"]
        cpf = format_cpf(cpf)
        print("CPF: " + cpf)
    print("Tipo: " + obj["tipo"])
    print("Data: " + datetime.strptime(obj["data"], '%Y-%m-%d %H:%M:%S').strftime('%d/%m/%Y %H:%M:%S'))


def imprimir(obj, date=None):
    cpf = obj["cpf"]
    nascimento = datetime.strptime(obj["nascimento"], '%Y-%m-%d')
    cpf = format_cpf(cpf)
    print("------------------------------------------------------------")
    print("Paciente: " + obj["nome"])
    print("CPF: " + cpf)
    print("Data de Nascimento: " + f"{nascimento:%d/%m/%Y}")
    comorbidade(obj)
    sinaisvitais(obj, date)
    sintoma(obj, date)
    exame(obj, date)
    vacina(obj, date)


def comorbidade(obj):
    if "comorbidades" not in obj:
        return
    comorb = obj["comorbidades"]
    if len(comorb) > 0:
        print("------------")
        print("Comorbidades")
        print("------------")
        print(*comorb, sep="\n")


def sinaisvitais(obj, date=None):
    if date is not None:
        date = datetime.strptime(date, '%Y-%m-%d %H:%M:%S').timestamp()
    if "sinais" not in obj:
        return
    sinais = obj["sinais"]
    sinais.sort(key=extract_time, reverse=False)
    if len(sinais) > 0:
        if date is not None and datetime.strptime(sinais[0]["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        print("-------------")
        print("Sinais Vitais")
        print("-------------")
    for sinal in sinais:
        if date is not None and datetime.strptime(sinal["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        dados_comuns(sinal)
        print("leitura: " + sinal["leitura"])
        if sinais.index(sinal) < (len(sinais) - 1):
            if date is not None and datetime.strptime(sinais[sinais.index(sinal) + 1]["data"],
                                                      '%Y-%m-%d %H:%M:%S').timestamp() > date:
                return
            print("-------------")


def sintoma(obj, date=None):
    if date is not None:
        date = datetime.strptime(date, '%Y-%m-%d %H:%M:%S').timestamp()
    if "sintomas" not in obj:
        return
    sintomas = obj["sintomas"]
    sintomas.sort(key=extract_time, reverse=False)
    if (len(sintomas) > 0):
        if date is not None and datetime.strptime(sintomas[0]["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        print("--------")
        print("Sintomas")
        print("--------")
    for sintoma in sintomas:
        if date is not None and datetime.strptime(sintoma["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        dados_comuns(sintoma)
        if sintomas.index(sintoma) < (len(sintomas) - 1):
            if date is not None and datetime.strptime(sintomas[sintomas.index(sintoma) + 1]["data"],
                                                      '%Y-%m-%d %H:%M:%S').timestamp() > date:
                return
            print("-------------")


def exame(obj, date=None):
    if date is not None:
        date = datetime.strptime(date, '%Y-%m-%d %H:%M:%S').timestamp()
    if "exames" not in obj:
        return
    exames = obj["exames"]
    exames.sort(key=extract_time, reverse=False)
    if (len(exames) > 0):
        if date is not None and datetime.strptime(exames[0]["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        print("------")
        print("Exames")
        print("------")
    for exame in exames:
        if date is not None and datetime.strptime(exame["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        dados_comuns(exame)
        print("resultado: " + exame["resultado"])
        if "igg" in exame: print("IgG: " + exame["igg"])
        if "igm" in exame: print("IgM: " + exame["igm"])
        if exames.index(exame) < (len(exames) - 1):
            if date != None and datetime.strptime(exames[exames.index(exame) + 1]["data"],
                                                  '%Y-%m-%d %H:%M:%S').timestamp() > date:
                return
            print("-------------")


def vacina(obj, date=None):
    if date is not None:
        date = datetime.strptime(date, '%Y-%m-%d %H:%M:%S').timestamp()
    if "vacinas" not in obj:
        return
    vacinas = obj["vacinas"]
    vacinas.sort(key=extract_time, reverse=False)
    if (len(vacinas) > 0):
        if date != None and datetime.strptime(vacinas[0]["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        print("-------")
        print("vacinas")
        print("-------")
    for vacina in vacinas:
        if date is not None and datetime.strptime(vacina["data"], '%Y-%m-%d %H:%M:%S').timestamp() > date:
            return
        dados_comuns(vacina)
        print("dose: " + vacina["dose"])
        print("serial: " + vacina["serial"])
        print("lote: " + vacina["lote"])
        if vacinas.index(vacina) < (len(vacinas) - 1):
            if date is not None and datetime.strptime(vacinas[vacinas.index(vacina) + 1]["data"],
                                                      '%Y-%m-%d %H:%M:%S').timestamp() > date:
                return
            print("-------------")


def diagnosticar(paciente, date=None):
    if date is not None:
        date = datetime.strptime(date, '%Y-%m-%d %H:%M:%S').timestamp()
    else:
        date = datetime.now().timestamp()
    oximetria = None
    temperatura = None
    exame_positivo = None
    exame_imunizado = None
    vacina = None
    if "sinais" in paciente:
        oximetrias = [sinal for sinal in paciente['sinais']
                         if sinal['tipo'] == 'OXIMETRIA'
                         and datetime.strptime(sinal['data'],'%Y-%m-%d %H:%M:%S').timestamp() < date]
        if len(oximetrias) > 0:
            oximetria = max(oximetrias,
                        key=lambda sinal: sinal['data'])
        temperaturas = [sinal for sinal in paciente['sinais']
                           if sinal['tipo'] == 'TEMPERATURA'
                           and datetime.strptime(sinal['data'], '%Y-%m-%d %H:%M:%S').timestamp() < date]
        if len(temperaturas) > 0:
            temperatura = max(temperaturas,
                          key=lambda sinal: sinal['data'])
    if "exames" in paciente:
        exames = [exame for exame in paciente['exames']
                              if exame['resultado'] in ['POSITIVO', 'REAGENTE']
                              and datetime.strptime(exame['data'],'%Y-%m-%d %H:%M:%S').timestamp() < date]
        if len(exames) > 0:
            exame_positivo = max(exames,
                             key=lambda exame: exame['data'])
        exames = [exame for exame in paciente['exames']
                               if 'igg' in exame and float(exame['igg']) > 1.0
                               and datetime.strptime(exame['data'], '%Y-%m-%d %H:%M:%S').timestamp() < date]
        if len(exames) > 0:
            exame_imunizado = max(exames,
                              key=lambda exame: exame['data'])
    if "vacinas" in paciente:
        vacinas = [vacina for vacina in paciente['vacinas']
                      if int(vacina['dose'].replace('ª','')) == 2
                      and datetime.strptime(vacina['data'], '%Y-%m-%d %H:%M:%S').timestamp() < date]
        if len(vacinas) > 0:
            vacina = max(vacinas,
                     key=lambda vacina: vacina['data'])
    diagnostico = "--------------------------------------------------\n" +\
                  "Paciente: "+paciente['nome'] + "\n" + \
                  "CPF: " +format_cpf(paciente['cpf'])+ "\n" + \
                  "Diagnóstico: "
    if vacina is not None:
        diagnostico += "VACINADO EM " + datetime.strptime(vacina['data'], '%Y-%m-%d %H:%M:%S').strftime('%d/%m/%Y %H:%M:%S') + "\n" +\
        "-------------------------\n" +\
        "Dados da Vacina (2ª dose)\n" +\
        "-------------------------\n" +\
        "Tipo: " + vacina['tipo'] + "\n" +\
        "Lote: " + vacina['lote'] + "\n" +\
        "Serial: " + vacina['serial'] + "\n" +\
        "-------------------------"
    elif exame_imunizado:
        diagnostico += "IMUNIZADO EM " + datetime.strptime(exame_imunizado['data'], '%Y-%m-%d %H:%M:%S').strftime('%d/%m/%Y %H:%M:%S')  + "\n" + \
        "--------------\n" +\
        "Dados do Exame\n" +\
        "--------------\n" +\
        "Tipo: """ + exame_imunizado['tipo'] + "\n" +\
        "resultado: """ + exame_imunizado['resultado'] + "\n" +\
        "IgG: """ + exame_imunizado['igg'] + "\n" +\
        "IgM: """ + exame_imunizado['igg'] + "\n" +\
        "-------------------------"
    elif exame_positivo:
        diagnostico += "INFECCIOSO EM " + datetime.strptime(exame_positivo['data'], '%Y-%m-%d %H:%M:%S').strftime('%d/%m/%Y %H:%M:%S') + "\n" + \
        "--------------\n" + \
        "Dados do Exame\n" + \
        "--------------\n" + \
        "Tipo: """ + exame_positivo['tipo'] + "\n" + \
        "resultado: """ + exame_positivo['resultado'] + "\n"
        if 'igg' in exame_positivo:
            diagnostico += "IgG: """ + exame_positivo['igg'] + "\n" + \
            "IgM: """ + exame_positivo['igg'] + "\n" + \
        "-------------------------"
    elif paciente['diagnostico']:
        diagnostico += paciente['diagnostico']
    level = Enum('level', 'BOM MODERADO GRAVE GRAVISSIMO')
    ox_level = level.BOM
    temp_level = level.BOM
    if oximetria is not None:
        diagnostico += "\nOXIMETRIA " + oximetria['leitura']
        ox_reading = int(oximetria['leitura'].replace("%", ""))
        if 90 < ox_reading < 95:
            ox_level = level.MODERADO
        elif 87 < ox_reading < 90:
            ox_level = level.GRAVE
        elif ox_reading < 87:
            ox_level = level.GRAVISSIMO
    if temperatura is not None:
        diagnostico += "\nTEMPERATURA " + temperatura['leitura']
        temp_reading = float(temperatura['leitura'].replace("º", "").replace("C", ""))
        if temp_reading < 35.0:
            diagnostico += " (HIPOTERMIA)"
            temp_level = level.GRAVISSIMO
        elif 37.5 < temp_reading <= 39.5:
            diagnostico += " (FEBRE)"
            temp_level = level.MODERADO
        elif 39.5 < temp_reading <= 41.0:
            diagnostico += " (FEBRE ALTA)"
            temp_level = level.GRAVE
        elif temp_reading > 41.0:
            diagnostico += " (HIPERTERMIA)"
            temp_level = level.GRAVISSIMO
    if ox_level == level.GRAVISSIMO or temp_level == level.GRAVISSIMO:
        diagnostico += '\nEstado Geral: GRAVÍSSIMO'
    elif (ox_level == level.GRAVE and temp_level <= level.GRAVE) or (temp_level == level.GRAVE and ox_level <= level.GRAVE):
        diagnostico += '\nEstado Geral: GRAVE'
    elif (ox_level == level.MODERADO and temp_level <= level.MODERADO) or (temp_level == level.MODERADO and ox_level <= level.MODERADO):
        diagnostico += '\nEstado Geral: MODERADO'
    else:
        diagnostico += '\nEstado Geral: BOM'
    print(diagnostico)