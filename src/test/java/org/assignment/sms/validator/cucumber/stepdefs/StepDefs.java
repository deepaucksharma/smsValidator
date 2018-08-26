package org.assignment.sms.validator.cucumber.stepdefs;

import org.assignment.sms.validator.SmsValidatorApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = SmsValidatorApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
