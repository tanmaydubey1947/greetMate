package com.greetmate.scheduler;


import com.greetmate.model.BirthdayInfo;
import com.greetmate.service.EmailService;
import com.greetmate.service.GreetMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private GreetMateService greetMateService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 8 * * ?") // Runs every day at 8 AM
    public void checkAndSendBirthdayWishes() {
        List<BirthdayInfo> birthdayFriends = greetMateService.getTodayBirthdays();
        for (BirthdayInfo birthdayInfo : birthdayFriends) {
            String whatsappLink = "https://wa.me/" + birthdayInfo.getPhoneNumber() +
                    "?text=Happy%20Birthday%20" + birthdayInfo.getName() + "!";
            String emailBody = "It's " + birthdayInfo.getName() + "'s birthday today! Click the link to send wishes: " + whatsappLink;
            emailService.sendEmail("your-email@example.com", "Birthday Reminder", emailBody);
        }
    }
}
