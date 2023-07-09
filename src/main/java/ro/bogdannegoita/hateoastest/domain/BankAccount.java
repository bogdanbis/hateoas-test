package ro.bogdannegoita.hateoastest.domain;

import lombok.Getter;
import ro.bogdannegoita.hateoastest.domain.dtos.BankAccountDTO;

@Getter
public class BankAccount {

	private final String iban;
	private final String bankName;

	public BankAccount(BankAccountDTO data) {
		iban = data.iban;
		bankName = data.bankName;
	}
}
