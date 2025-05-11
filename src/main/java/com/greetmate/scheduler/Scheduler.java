package com.greetmate.scheduler;


import com.greetmate.model.BirthdayInfo;
import com.greetmate.service.EmailService;
import com.greetmate.service.GreetMateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Scheduled(cron = "* * * * * *") //TODO: Configure Time for scheduler
    public void checkAndSendBirthdayWishes() {
        log.info("Checking for today's birthdays...");
        List<BirthdayInfo> birthdayFriends = greetMateService.getTodayBirthdays();
        for (BirthdayInfo birthdayInfo : birthdayFriends) {
            log.info("Sending birthday wishes to: " + birthdayInfo.getName());
            String whatsappLink = "https://wa.me/" + birthdayInfo.getPhoneNumber() +
                    "?text=Happy%20Birthday%20" + birthdayInfo.getName() + "!";
            String emailBody = "It's " + birthdayInfo.getName() + "'s birthday today! Click the link to send wishes: " + whatsappLink;
            log.info("Sending email to: " + birthdayInfo.getPhoneNumber() + " with body: " + emailBody);
//            emailService.sendEmail("your-email@example.com", "Birthday Reminder", emailBody);
        }
    }
}
