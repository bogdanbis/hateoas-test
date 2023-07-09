package ro.bogdannegoita.hateoastest.domain.dtos;

import ro.bogdannegoita.hateoastest.persistence.entities.FirmEntity;

import java.util.UUID;

public class FirmDTO {
	public UUID id;
	public String name;
	public String fiscalCode;

	public FirmDTO() {
	}

	public FirmDTO(FirmEntity entity) {
		id = entity.getId();
		name = entity.getName();
		fiscalCode = entity.getFiscalCode();
	}
}
