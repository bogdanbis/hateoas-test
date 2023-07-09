package ro.bogdannegoita.hateoastest.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.bogdannegoita.hateoastest.persistence.daos.FirmDao;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Facturation {

	private final DomainFactory domainFactory;
	private final FirmDao firmStorage;

	private List<Firm> firms;
	private final Map<UUID, Firm> firmRegistry = new HashMap<>();

	public List<Firm> getFirms() {
		if (firms == null)
			loadFirms();
		return firms;
	}

	public Firm getFirm(UUID id) {
		if (firms == null)
			loadFirms();
		return firmRegistry.get(id);
	}

	private void loadFirms() {
		firms = firmStorage.findAll().stream()
				.map(dto -> {
					Firm firm = domainFactory.firm(dto);
					firmRegistry.put(firm.getId(), firm);
					return firm;
				})
				.sorted(Comparator.comparing(Firm::getName))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
