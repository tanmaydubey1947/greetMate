package com.greetmate.scheduler;


import com.greetmate.model.BirthdayInfo;
import com.greetmate.service.EmailService;
import com.greetmate.service.GreetMateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    private GreetMateService greetMateService;

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.receiver}")
    private String email;

    @Scheduled(cron = "* * * * * *") //TODO: Configure Time for scheduler
    public void checkAndSendBirthdayWishes() {
        log.info("Checking for today's birthdays...");
        List<BirthdayInfo> birthdayFriends = greetMateService.getTodayBirthdays();

        for (BirthdayInfo birthdayInfo : birthdayFriends) {
            String name = birthdayInfo.getName();
            log.info("Sending birthday wishes to: " + name);
            String emailBody = constructEmailBody(birthdayInfo);
            emailService.sendEmail(email, name, emailBody);
            log.info("Birthday wishes sent for: " + name);
        }
    }

    private String constructEmailBody(BirthdayInfo birthdayInfo) {
        String whatsappLink = "https://wa.me/" + birthdayInfo.getPhoneNumber() +
                "?text=Happy%20Birthday%20" + birthdayInfo.getName() + "!";

        return "It's " + birthdayInfo.getName() + "'s birthday today! Click the link to send wishes: "
                + whatsappLink;
    }
}
