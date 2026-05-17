package org.serratec.Ong.repository;

import org.serratec.Ong.domain.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository <Caracteristica, Long> {

}
