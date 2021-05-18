package br.com.diegoduarte.springbootnewrelicapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	Integer countByStatus(String status);
}
