package proyecto.sinergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sinergia.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
