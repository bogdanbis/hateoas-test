package ro.bogdannegoita.hateoastest.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "firm")
@Getter
@Setter
public class FirmEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	private String fiscalCode;

	@OneToMany(mappedBy = "firm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BankAccountEntity> bankAccounts;

}
