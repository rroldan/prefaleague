package org.ibertech.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.ibertech.shared.Team;

/**
 * {@link AbstractGwtValidatorFactory} that creates the specified {@link GwtValidator}.
 */
public final class SampleValidatorFactory extends AbstractGwtValidatorFactory {

  /**
   * Validator marker for the Validation Sample project. Only the classes listed
   * in the {@link GwtValidation} annotation can be validated.
   */
  @GwtValidation(value = Team.class) //,groups = {Default.class}
  public interface GwtValidator extends Validator {
  }

  @Override
  public AbstractGwtValidator createValidator() {
    return GWT.create(GwtValidator.class);
  }
}