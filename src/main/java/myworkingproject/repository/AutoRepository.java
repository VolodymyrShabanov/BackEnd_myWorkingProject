package myworkingproject.repository;

import myworkingproject.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    Optional<Auto> findByVinNumber(String vinNumber);

    List<Auto> findByBrand(String brand);

    List<Auto> findByModel(String model);

}

