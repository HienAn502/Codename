package personal.codename.domain.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import personal.codename.domain.enums.PlayerRole;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PlayerRoleConverter implements AttributeConverter<PlayerRole, String> {

    @Override
    public String convertToDatabaseColumn(PlayerRole playerRole) {
        return playerRole.getValue();
    }

    @Override
    public PlayerRole convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(PlayerRole.values())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
