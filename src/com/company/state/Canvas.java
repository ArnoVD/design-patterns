package com.company.state;

public class Canvas implements Tool{
    private Tool currentTool;

    public Tool getCurrentType() {
        return currentTool;
    }

    public void setCurrentType(Tool currentTool) {
        this.currentTool = currentTool;
    }

    @Override
    public void mouseUp() {
        currentTool.mouseUp();
    }

    @Override
    public void mouseDown() {
        currentTool.mouseDown();
    }
}
