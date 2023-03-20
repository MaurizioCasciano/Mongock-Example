package dev.example.mongock.repository;

import dev.example.mongock.domain.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
}
