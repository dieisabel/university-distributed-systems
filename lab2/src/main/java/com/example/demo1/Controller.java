package com.example.demo1;

import com.example.demo1.logic.Function;
import com.example.demo1.logic.IntegralCalculator;
import com.example.demo1.logic.TableRow;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML private TableView<TableRow> tableArea;
    @FXML private TableColumn<TableRow, Integer> idColumn;
    @FXML private TableColumn<TableRow, Integer> threadsColumn;
    @FXML private TableColumn<TableRow, Integer> nColumn;
    @FXML private TableColumn<TableRow, Double> resultColumn;
    @FXML private TableColumn<TableRow, Long> timeColumn;

    @FXML private TextField splitCount;
    @FXML private TextField threadsCount;

    IntegralCalculator calculator;
    Integer idCounter;

    public void initialize() {
        configureTableArea();
        idCounter = 0;
    }

    public void calculateIntegral() {
        int n = Integer.parseInt(splitCount.getText());
        int threadsCount = Integer.parseInt(this.threadsCount.getText());
        calculator = new IntegralCalculator(1.0, 4.0, n, new Function()::calculate);
        long start = System.currentTimeMillis();
        double result = calculator.calculate(threadsCount);
        long finish = System.currentTimeMillis();
        long time = finish - start;
        tableArea.getItems().add(new TableRow(++idCounter, n, threadsCount, result, time));
    }

    private void configureTableArea() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nColumn.setCellValueFactory(new PropertyValueFactory<>("n"));
        threadsColumn.setCellValueFactory(new PropertyValueFactory<>("threads"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
    }
}
