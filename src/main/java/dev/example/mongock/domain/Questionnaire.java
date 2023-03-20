package dev.example.mongock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.example.mongock.domain.enumeration.QuestionnaireType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Questionnaire {
    @Id
    private String id;

    @Transient
    @JsonIgnore
    @Builder.Default
    private Class<String> idType = String.class;

    private String name;
    private String description;
    @Indexed(unique = true)
    private QuestionnaireType type;
    private List<String> questions;
}
