package com.greetmate.respository;

import com.greetmate.model.BirthdayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetMateRepository extends JpaRepository<BirthdayInfo, Long> {
}
