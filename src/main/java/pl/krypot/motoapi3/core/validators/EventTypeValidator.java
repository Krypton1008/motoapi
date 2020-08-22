package pl.krypot.motoapi3.core.validators;

import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.ValidatorBase;
import pl.krypot.motoapi3.core.model.inputs.AddEventTypeInput;
import pl.krypot.motoapi3.exceptions.InvalidParametersException;

@Service
public class EventTypeValidator extends ValidatorBase<AddEventTypeInput> {
    @Override
    public void validate(AddEventTypeInput addEventTypeInput) throws InvalidParametersException {
        String errors = "";

        //name
        errors += validateName(addEventTypeInput.getName(), "TypeName");

        if (!errors.isEmpty()) {
            throw new InvalidParametersException(errors);
        }
    }
}
