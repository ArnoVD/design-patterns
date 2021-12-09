package com.company.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    // This can also be a stack (probably better)
    private List<EditorState> states =  new ArrayList<>();

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop(){
        var lastState = states.get(states.size() - 1);
        states.remove(lastState);

        return lastState;
    }
}
