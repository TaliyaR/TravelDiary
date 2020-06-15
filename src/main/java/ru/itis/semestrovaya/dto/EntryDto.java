package ru.itis.semestrovaya.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EntryDto {
    private String title;
    private String text;
    private String date;
    private String location;
    private String isPublic;
    private String[] tag;
    private MultipartFile file;
}
