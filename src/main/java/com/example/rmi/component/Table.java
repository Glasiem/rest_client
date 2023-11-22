package com.example.rmi.component;


import com.example.rmi.component.column.*;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public String name;
    public List<Row> rows = new ArrayList<>();
    public List<Column> columns = new ArrayList<>();

    public Table(String name){
        this.name = name;
    }

    public Table(Table table) {
        this.name = table.name;
        for (Row row : table.rows) {
            Row newRow = new Row();
            for (String data : row.values) {
                newRow.values.add(data);
            }
            this.rows.add(newRow);
        }
        for (Column column : table.columns) {
            switch (ColumnType.valueOf(column.type)) {
                case INT -> {
                    Column columnInt = new IntegerColumn(column.name);
                    this.columns.add(columnInt);
                }
                case REAL -> {
                    Column columnReal = new RealColumn(column.name);
                    this.columns.add(columnReal);
                }
                case STRING -> {
                    Column columnStr = new StringColumn(column.name);
                    this.columns.add(columnStr);
                }
                case CHAR -> {
                    Column columnChar = new CharColumn(column.name);
                    this.columns.add(columnChar);
                }
                case MONEY -> {
                    Column moneyColumn = new MoneyColumn(column.name);
                    this.columns.add(moneyColumn);
                }
                case MONEY_INVL -> {
                    Column moneyInvlColumn = new MoneyInvlColumn(column.name, ((MoneyInvlColumn) column).getMin(), ((MoneyInvlColumn) column).getMax());
                    this.columns.add(moneyInvlColumn);
                }
            }
        }
    }


    public void addRow(Row row) {
        rows.add(row);
    }

    public void deleteRow(int rowIndex) {
        rows.remove(rowIndex);
    }

    public void deleteColumn(int columnIndex) {
        columns.remove(columnIndex);
        for (Row row: rows) {
            row.values.remove(columnIndex);
        }
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void setName(String name) {
        this.name = name;
    }
}
