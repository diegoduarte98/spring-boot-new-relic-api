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

//        Map eventAttributes = new HashMap();
//        eventAttributes.put("animalType", "cat");
//        eventAttributes.put("animalCount", 50);
//        NewRelic.getAgent().getInsights().recordCustomEvent("animalEvent", eventAttributes);
//
//        eventAttributes.clear();
//
//        eventAttributes.put("animalType", "dog");
//        eventAttributes.put("animalCount", 15);
//        NewRelic.getAgent().getInsights().recordCustomEvent("animalEvent", eventAttributes);
//		  select sum(animalCount) from animalEvent facet animalType since 1 day ago
//        select sum(TotalVendas) from StatusVendas facet status since 1 day ago
		final Map map = new HashMap();
		map.put("status", "ATIVO");
		map.put("TotalVendas", repository.countByStatus("ATIVO"));

		NewRelic.getAgent().getInsights().recordCustomEvent("StatusVendas", map);

		map.clear();

		map.put("status", "BLOQUEADO");
		map.put("TotalVendas", repository.countByStatus("BLOQUEADO"));

		NewRelic.getAgent().getInsights().recordCustomEvent("StatusVendas", map);
	}
}
