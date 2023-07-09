package ro.bogdannegoita.hateoastest.domain;

import lombok.Getter;
import ro.bogdannegoita.hateoastest.domain.dtos.FirmDTO;
import ro.bogdannegoita.hateoastest.persistence.daos.FirmDao;

import java.util.List;
import java.util.UUID;

public class Firm {

	@Getter
	private UUID id;
	@Getter
	private String name;
	@Getter
	private String fiscalCode;
	@Getter
	private List<BankAccount> bankAccounts;

	private final FirmDao storage;

	public Firm(FirmDTO data, FirmDao storage) {
		this.storage = storage;
		id = data.id;
		name = data.name;
		fiscalCode = data.fiscalCode;
	}

}
