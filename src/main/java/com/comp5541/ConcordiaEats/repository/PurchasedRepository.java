package com.comp5541.ConcordiaEats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comp5541.ConcordiaEats.model.*;


@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Purchased.PurchasedId> {
    // Additional query methods if needed...
}
