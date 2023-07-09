package ro.bogdannegoita.hateoastest.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.bogdannegoita.hateoastest.api.responses.FirmResponse;
import ro.bogdannegoita.hateoastest.domain.BankAccount;
import ro.bogdannegoita.hateoastest.domain.Facturation;
import ro.bogdannegoita.hateoastest.domain.Firm;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/firms")
@RequiredArgsConstructor
public class FirmController {

	private final Facturation facturation;

	@GetMapping
	public CollectionModel<FirmResponse> findAll() {
		return CollectionModel.of(
				facturation.getFirms().stream()
						.map(FirmResponse::new)
						.toList()
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FirmResponse> findById(@PathVariable UUID id) {
		Firm firm = facturation.getFirm(id);
		return ResponseEntity.ok(new FirmResponse(firm));
	}

	@GetMapping("/{id}/bank-accounts")
	public List<BankAccount> getBankAccounts(@PathVariable UUID id) {
		return facturation.getFirm(id).getBankAccounts();
	}
}
