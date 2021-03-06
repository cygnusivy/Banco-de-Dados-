package br.com.letscode.postosaude.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteVacinadoRepositorio extends JpaRepository<PacienteVacinado, Integer> 
{
    void deleteByPacienteId(Integer pacienteId);
    Optional<PacienteVacinado> findOneById(Integer id);
}