package com.unicesumar.ordemDeServicoDigital.entities.enums;

public enum StatusSolicitacao {
	
	SOLICITACAO_REALIZADA(1),
	SOLICITACAO_RECEBIDA(2),
	SOLICITACAO_ATENDIDA(3),
	SOLICITACAO_CANCELADA(4);
	
	private int code;
	private StatusSolicitacao(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusSolicitacao valueOf(int code) {
		for(StatusSolicitacao value : StatusSolicitacao.values()) {
			if(value.getCode()== code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusSolicitacao code");
	}

}
