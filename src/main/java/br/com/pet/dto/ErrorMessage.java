package br.com.pet.dto;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus status,String Message) {
}
