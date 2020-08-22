package pl.krypot.motoapi3.core.validators;

import org.springframework.stereotype.Service;
import pl.krypot.motoapi3.core.ValidatorBase;
import pl.krypot.motoapi3.core.model.inputs.AddEventInput;
import pl.krypot.motoapi3.exceptions.InvalidParametersException;

@Service
public class EventValidator extends ValidatorBase<AddEventInput> {
    @Override
    public void validate(AddEventInput addEventInput) throws InvalidParametersException {
        String errors = "";

        //dishTypeInput

        //price
        //Double price = addEventInput.getPrice();

        //name
        errors += validateDescription(addEventInput.getName(), "DishName");
        //description
        errors += validateDescription(addEventInput.getDescription(), "Description");

        if (!errors.isEmpty()) {
            throw new InvalidParametersException(errors);
        }
    }
}
