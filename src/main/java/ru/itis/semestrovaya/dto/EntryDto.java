package ru.itis.semestrovaya.dto;

import lombok.Data;
import ru.itis.semestrovaya.models.User;

@Data
public class EntryDto {
    private String title;
    private String text;
    private String date;
    private String location;
    private Boolean isPrivate;
}
