package com.greetmate.service;


import com.greetmate.model.BirthdayInfo;
import com.greetmate.model.GreetMateRequest;
import com.greetmate.model.GreetMateResponse;
import com.greetmate.respository.GreetMateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GreetMateService {

    @Autowired
    private GreetMateRepository repository;

    public GreetMateResponse addFriendBirthday(GreetMateRequest request) {
        BirthdayInfo info = new BirthdayInfo();
        info.setName(request.getName());
        info.setDob(request.getDob());
        info.setPhoneNumber(request.getPhoneNumber());
        repository.save(info);
        return new GreetMateResponse("Birthday information saved successfully");
    }

    public List<BirthdayInfo> getTodayBirthdays() {
        LocalDate today = LocalDate.now();
        return repository.findByDob(today);
    }
}
