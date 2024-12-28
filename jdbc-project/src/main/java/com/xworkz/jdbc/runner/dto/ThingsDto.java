package com.xworkz.jdbc.runner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThingsDto {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookGenres;
}
