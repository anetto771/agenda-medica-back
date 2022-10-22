package com.api.agendamedicaback.domain.enums;

public enum Perfil {
    USUARIO(0, "ROLE_USUARIO"), PACIENTE(1, "ROLE_PACIENTE"), MEDICO(2, "ROLE_MEDICO");

    private Integer codigo;
    private String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null) {
            return null;
        }
        for(Perfil x: Perfil.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }
}

