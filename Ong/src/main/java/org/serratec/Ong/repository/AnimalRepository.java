package org.serratec.Ong.repository;

import java.util.List;

import org.serratec.Ong.domain.Animal;
import org.serratec.Ong.enummerated.Especie;
import org.serratec.Ong.enummerated.Porte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository <Animal, Long>{
    List<Animal> findByEspecie(Especie especie);
    List<Animal> findByPorte(Porte porte);
    
}
