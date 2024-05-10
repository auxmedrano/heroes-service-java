package com.ventura.heroeservice.repositories;

import com.ventura.heroeservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
