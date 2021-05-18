package br.com.diegoduarte.springbootnewrelicapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newrelic.api.agent.NewRelic;

@RestController
public class NewRelicController {

	private final SaleRepository repository;

	public NewRelicController(SaleRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public void get() {

		final Map<String, Object> map = new HashMap<>();
		map.put("status", "APROVADO");
		map.put("TotalVendas", repository.countByStatus("APROVADO"));

		NewRelic.getAgent().getInsights().recordCustomEvent("StatusVendas", map);

		map.clear();

		map.put("status", "RECUSADO");
		map.put("TotalVendas", repository.countByStatus("RECUSADO"));

		NewRelic.getAgent().getInsights().recordCustomEvent("StatusVendas", map);
	}
}
