package com.greetmate.respository;

import com.greetmate.model.BirthdayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GreetMateRepository extends JpaRepository<BirthdayInfo, Long> {

    List<BirthdayInfo> findByDob(LocalDate dob);
}
