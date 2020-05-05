package ru.itis.semestrovaya.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class HandledErrorsCounterBean {

    private int count = 0;

    public void handleNewError() {
        count++;
    }

    public int getCounterOfHandledErrors() {
        return count;
    }
}
