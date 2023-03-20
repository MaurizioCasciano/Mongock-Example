package dev.example.mongock.service;

import dev.example.mongock.domain.Questionnaire;

public interface QuestionnaireService extends DatasetLoader<Questionnaire> {
    String aQuestionnaireDataset = "classpath:dataset/questionnaire/a/questionnaire-a.json";
    String bQuestionnaireDataset = "classpath:dataset/questionnaire/b/questionnaire-b.json";

    Questionnaire loadAQuestionnaireData();

    Questionnaire loadBQuestionnaireData();
}
