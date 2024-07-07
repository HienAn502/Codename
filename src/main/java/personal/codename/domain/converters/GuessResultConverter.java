package personal.codename.domain.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import personal.codename.domain.enums.GuessResult;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GuessResultConverter implements AttributeConverter<GuessResult, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(GuessResult guessResult) {
        return guessResult.isCorrect();
    }

    @Override
    public GuessResult convertToEntityAttribute(Boolean value) {
        if (value == null) {
            return null;
        }
        return Stream.of(GuessResult.values())
                .filter(item -> item.isCorrect() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
