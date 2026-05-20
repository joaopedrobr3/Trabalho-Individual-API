package org.serratec.Ong.repository;

import org.serratec.Ong.domain.Endereco;
import org.serratec.Ong.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
   
    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);
    
    Boolean existsBy(Endereco endereco);

    Boolean existsByTelefone(String telefone);
    
}
