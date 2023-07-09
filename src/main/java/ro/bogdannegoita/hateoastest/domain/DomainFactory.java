package ro.bogdannegoita.hateoastest.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.bogdannegoita.hateoastest.domain.dtos.BankAccountDTO;
import ro.bogdannegoita.hateoastest.domain.dtos.FirmDTO;
import ro.bogdannegoita.hateoastest.persistence.daos.FirmDao;

@Component
@RequiredArgsConstructor
public class DomainFactory {

	private final FirmDao firmDao;

	public Firm firm(FirmDTO data) {
		return new Firm(data, firmDao);
	}

	public BankAccount bankAccount(BankAccountDTO data) {
		return new BankAccount(data);
	}
}
