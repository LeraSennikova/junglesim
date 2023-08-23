package ru.sennikova.junglesim._main;

import ru.sennikova.junglesim.entity.Dolphin;
import ru.sennikova.junglesim.util.EventExecutor;

public class _Main {
    public static void main(String[] args){
        Dolphin dolphin = new Dolphin();
        EventExecutor eventExecutor = new EventExecutor();
        eventExecutor.startSimulation(dolphin);
    }
}
