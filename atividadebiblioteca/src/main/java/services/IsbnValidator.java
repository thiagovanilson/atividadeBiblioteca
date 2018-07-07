package services;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;
import org.apache.commons.validator.routines.ISBNValidator;

@FacesValidator("isbnValidator")
public class IsbnValidator implements Validator{
    
    ISBNValidator validador;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
   
        validador = new ISBNValidator();
        
        if (!validador.isValid( (String) value)){
            FacesMessage msg = new FacesMessage("Erro: ISBN inválido!");
            msg.setSeverity(msg.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    
}