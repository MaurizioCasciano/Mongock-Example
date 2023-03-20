package dev.example.mongock.service;

import dev.example.mongock.domain.enumeration.QuestionnaireType;
import dev.example.mongock.domain.Questionnaire;
import dev.example.mongock.repository.QuestionnaireRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final MongoTemplate mongoTemplate;

    private final QuestionnaireRepository repository;


    @Override
    public Questionnaire loadAQuestionnaireData() {
        return this.loadData(Questionnaire.class, aQuestionnaireDataset);
    }

    @Override
    public Questionnaire loadBQuestionnaireData() {
        return this.loadData(Questionnaire.class, bQuestionnaireDataset);
    }
}
