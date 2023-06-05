package com.example.taskcrudhibernate.dto.simpleDto;

public class SimpleSpecialtyDto {

    private Long id;
    private String name;

    public SimpleSpecialtyDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleSpecialtyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
