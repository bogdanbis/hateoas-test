package ro.bogdannegoita.hateoastest.api.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ro.bogdannegoita.hateoastest.api.controllers.FirmController;
import ro.bogdannegoita.hateoastest.domain.Firm;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class FirmResponse extends RepresentationModel<FirmResponse> {
	private UUID id;
	private String name;
	private String fiscalCode;

	public FirmResponse(Firm firm) {
		id = firm.getId();
		name = firm.getName();
		fiscalCode = firm.getFiscalCode();
		Link selfLink = linkTo(methodOn(FirmController.class).findById(id)).withSelfRel();
		add(selfLink);
		Link bankAccountsLink = linkTo(methodOn(FirmController.class).getBankAccounts(id)).withRel("bankAccounts");
		add(bankAccountsLink);
	}
}
