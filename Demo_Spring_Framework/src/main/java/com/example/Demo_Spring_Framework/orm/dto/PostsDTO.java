package com.example.Demo_Spring_Framework.orm.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostsDTO {
    @JsonIgnore
    private Integer id;

    private String title;

    private String content;
    @JsonIgnore
    private Integer idUser;

    private String nameUser;

    public PostsDTO(String title, String content, String nameUser) {
        this.title = title;
        this.content = content;
        this.nameUser = nameUser;
    }
}
