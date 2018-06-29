package com.zenpanda;

import com.zenpanda.entity.Schedule;
import com.zenpanda.service.ScheduleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupportWheelOfFateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportWheelOfFateApplication.class, args);
		Schedule schedule = new ScheduleService().getSchedule("");
	}
}
