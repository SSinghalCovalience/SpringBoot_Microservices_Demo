package com.example.departmentservice.model;

/**
* Employee - Employee Class
*/
public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
