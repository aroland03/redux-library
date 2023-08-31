package com.aroland03.learnredux.rest.dto;

import com.aroland03.learnredux.model.BookState;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private BookState state;

    @NotBlank
    private int year;

    private String coverUrl;
}
