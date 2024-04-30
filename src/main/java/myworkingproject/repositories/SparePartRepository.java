package myworkingproject.repositories;

import myworkingproject.entitys.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart, Integer> {
    Optional<SparePart> findByIdSparePart(Integer idSparePart);

    Optional<SparePart> findByName(String name);

}
