package com.company;

import com.company.abuse.Stopwatch;
import com.company.memento.Editor;
import com.company.memento.History;
import com.company.state.BrushTool;
import com.company.state.Canvas;
import com.company.state.EraserTool;

public class Main {

    // Static means that we can call the main function without making an instance of it first.
    public static void main(String[] args) {
        // Memento design pattern is used for undoing
        // We can store current states and go back to previous states
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        // This should print out "b"
        System.out.println(editor.getContent());

        System.out.println();

        // --------------------------------------------------------

        // State design pattern is used for a class with multiple forms. For example a canvas.
        // This design pattern also makes it really easy to add an extra tool for example
        // It also makes the code inside the canvas much cleaner, instead of a bunch of if/else/switch statements.
        var  canvas =  new Canvas();

        canvas.setCurrentType(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentType(new EraserTool());
        canvas.mouseDown();
        canvas.mouseUp();

        System.out.println();

        // --------------------------------------------------------

        // In the abuse package is shown how to abuse design pattern
        // Where a simple if/else turned into a state design pattern
        // which makes it way more complicated than it should be

        var stopwatch = new Stopwatch();
        stopwatch.click();
        stopwatch.click();
        stopwatch.click();

        System.out.println();

        // --------------------------------------------------------
    }
}
