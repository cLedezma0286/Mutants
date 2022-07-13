package com.mx.mlibre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.mlibre.mutants.beans.StatsVerify;

@Repository
public interface StatsDao extends CrudRepository<StatsVerify, Long>{
	
	@Query("Select u from StatsVerify u where u.fechaCambio = ?1")
	List<StatsVerify> getByDate(Date date);
	
	@Query("Select count(u) from StatsVerify u where u.fechaCambio = ?1 and u.bndResultado = 1")
	Long getMutantsNumberD(Date date);
	
	@Query("Select count(u) from StatsVerify u where u.fechaCambio = ?1 and u.bndResultado = 0")
	Long getHumansNumberD(Date date);
	
	@Query("Select count(u) from StatsVerify u where u.bndResultado =:bndResultado")
	Long getResNumber(@Param("bndResultado") Integer bndResultado);
}
