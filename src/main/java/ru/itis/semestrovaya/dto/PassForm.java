package ru.itis.semestrovaya.dto;

import lombok.Data;

@Data
public class PassForm {
    private String oldPassword;
    private String newPassword;
}
