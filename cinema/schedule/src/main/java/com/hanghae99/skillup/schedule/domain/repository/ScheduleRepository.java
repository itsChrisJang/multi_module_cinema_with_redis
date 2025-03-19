package com.hanghae99.skillup.schedule.domain.repository;

import com.hanghae99.skillup.schedule.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}
