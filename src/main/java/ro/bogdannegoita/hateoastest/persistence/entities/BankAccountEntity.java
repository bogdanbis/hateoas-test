package ro.bogdannegoita.hateoastest.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_account")
@Getter
@Setter
public class BankAccountEntity {
	@Id
	private String iban;

	private String bankName;

	@ManyToOne(fetch = FetchType.LAZY)
	private FirmEntity firm;
}
