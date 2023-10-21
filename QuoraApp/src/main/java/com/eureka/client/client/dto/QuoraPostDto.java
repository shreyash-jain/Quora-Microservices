package com.eureka.client.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class QuoraPostDto {
    String id;
    String title;
    Long userid;
    String body;
}
