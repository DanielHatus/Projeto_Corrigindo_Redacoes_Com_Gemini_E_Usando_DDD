package com.example.correct.Easy.infra.exception.response.runtime;

import java.time.LocalDate;
import java.time.LocalTime;

public record ResponseGeneric(String message, LocalDate dateRequest, LocalTime hourRequest){}
