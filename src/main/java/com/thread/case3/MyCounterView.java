package com.thread.case3;

import java.awt.*;

public class MyCounterView extends Frame {

    Button startButton;
    Button stopButton;
    Label myLabel;
    public MyCounterView() {
        super.setVisible(true);
        super.setSize(400, 200);
        super.setTitle("My Thread Counter");
        startButton = new Button("Start");
        stopButton = new Button("Stop");
        myLabel = new Label("");

        super.setLayout(null);
        myLabel.setBounds(100, 50, 150, 30);
        startButton.setBounds(70, 100, 150, 30);
        stopButton.setBounds(250, 100, 150, 30);

        super.add(startButton);
        super.add(stopButton);
        super.add(myLabel);


    }


    public Button getStartButton() {
        return startButton;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

    public Button getStopButton() {
        return stopButton;
    }

    public void setStopButton(Button stopButton) {
        this.stopButton = stopButton;
    }

    public Label getMyLabel() {
        return myLabel;
    }

    public void setMyLabel(Label myLabel) {
        this.myLabel = myLabel;
    }
}
