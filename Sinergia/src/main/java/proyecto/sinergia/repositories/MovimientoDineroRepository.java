package proyecto.sinergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sinergia.entities.MovimientoDinero;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Long> {

}
