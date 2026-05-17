package org.serratec.Ong.repository;

import org.serratec.Ong.domain.InteresseAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseAdocaoRepository extends JpaRepository <InteresseAdocao, Long>{

}
