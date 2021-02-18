package br.ufrn.imd.ppgti.dsl;

public enum ObjectType {
    PACIENTE(1, "paciente", null), COMORBIDADE(2, "comorbidades", null),
    SINTOMA(3, "sintomas",null), SINALVITAL(4, "sinais", null), EXAME(5, "exames", null),
    VACINA(6, "vacinas", null), LISTA(7, "lista", null), INVALIDO(7, "inválido", null);
    private final int code;
    private final String description;
    private ObjectType subtype;

    ObjectType(int code, String description, ObjectType subtype) { this.code = code; this.description = description; this.subtype= subtype; }

    int getCode() { return code; }
    String getDescription() { return description; }
    ObjectType getSubtype() { return subtype; }
    void setSubtype(ObjectType subtype){ this.subtype = subtype; }

    public static ObjectType byCode(int code) {
        for (ObjectType object: ObjectType.values()) {
            if (code == object.getCode()) return object;
        }
        throw new IllegalArgumentException("codigo invalido");
    }
}