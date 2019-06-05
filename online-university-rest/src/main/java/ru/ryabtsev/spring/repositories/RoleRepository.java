package ru.ryabtsev.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ryabtsev.spring.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findOneByName(final String name);


}
