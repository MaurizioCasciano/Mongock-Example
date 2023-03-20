package dev.example.mongock.domain.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum QuestionnaireType {
    A(0), B(1);

    private final int value;
}
