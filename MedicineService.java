package com.example.medtrack;

import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MedicineService {

    private final MedicineRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    public MedicineService(MedicineRepository repository) {
        this.repository = repository;
    }

    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }

    public Medicine addMedicine(Medicine medicine) {
        return repository.save(medicine);
    }

    @Transactional
public void deleteMedicine(Long id) {

    entityManager.createNativeQuery(
        "DELETE FROM medicine_batches WHERE medicine_id = :id"
    )
    .setParameter("id", id)
    .executeUpdate();

    repository.deleteById(id);
}
}