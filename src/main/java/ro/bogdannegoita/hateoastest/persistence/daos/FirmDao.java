package ro.bogdannegoita.hateoastest.persistence.daos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.bogdannegoita.hateoastest.domain.dtos.FirmDTO;
import ro.bogdannegoita.hateoastest.persistence.repositories.FirmRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FirmDao {

	private final FirmRepository repository;

	public List<FirmDTO> findAll() {
		return repository.findAll().stream()
				.map(FirmDTO::new)
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
