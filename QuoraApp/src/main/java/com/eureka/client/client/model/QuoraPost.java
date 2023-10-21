package com.eureka.client.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "GloQuoraPosts")
public class QuoraPost {
    @Id
    String id = UUID.randomUUID().toString();
    String title;
    Long userId;
    String body;

}
