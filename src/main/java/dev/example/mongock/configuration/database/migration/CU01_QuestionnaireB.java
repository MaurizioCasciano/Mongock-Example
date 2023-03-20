package dev.example.mongock.configuration.database.migration;

import io.mongock.api.annotations.*;
import dev.example.mongock.domain.Questionnaire;
import dev.example.mongock.repository.QuestionnaireRepository;
import dev.example.mongock.service.QuestionnaireService;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id="questionnaire-b-initializer", order = "1", author = "dev", runAlways = true)
public class CU01_QuestionnaireB {
    @BeforeExecution
    public void beforeExecution(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(Questionnaire.class)) {
            mongoTemplate.createCollection(Questionnaire.class);
        }
    }

    @RollbackBeforeExecution
    public void rollbackBeforeExecution(MongoTemplate mongoTemplate) {
        if (mongoTemplate.collectionExists(Questionnaire.class)) {
            mongoTemplate.dropCollection(Questionnaire.class);
        }
    }

    @Execution
    public void execution(QuestionnaireService questionnaireService, QuestionnaireRepository questionnaireRepository) {
        Questionnaire questionnaire = questionnaireService.loadBQuestionnaireData();

        System.out.println(questionnaire);

        questionnaireRepository.save(questionnaire);
    }

    @RollbackExecution
    public void rollbackExecution(QuestionnaireService questionnaireService, QuestionnaireRepository questionnaireRepository) {
        Questionnaire questionnaire = questionnaireService.loadBQuestionnaireData();
        questionnaireRepository.delete(questionnaire);
    }
}
