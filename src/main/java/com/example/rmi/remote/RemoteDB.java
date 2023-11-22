package com.example.rmi.remote;

import com.example.rmi.component.Column;
import com.example.rmi.component.OperatorType;
import com.example.rmi.component.Row;
import com.example.rmi.component.TableData;
import com.example.rmi.component.column.ColumnType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteDB extends Remote {

  public List<Row> getRows(int tableIndex) throws RemoteException;

  public List<Column> getColumns(int tableIndex) throws RemoteException;

  public List<TableData> getTablesData() throws RemoteException;



  public Boolean createTable(String name) throws RemoteException;

  public Boolean addRow(int tableIndex) throws RemoteException;

  public Boolean addColumn(int tableIndex, String name, ColumnType columnType, String min, String max) throws RemoteException;



  public Boolean deleteTable(int tableIndex) throws RemoteException;

  public Boolean deleteColumn(int tableIndex, int columnIndex) throws RemoteException;

  public Boolean deleteRow(int tableIndex, int rowIndex) throws RemoteException;



  public Boolean renameTable(int tableIndex, String name) throws RemoteException;
  public Boolean renameColumn(int tableIndex, int columnIndex, String name) throws RemoteException;
  public Boolean changeColumnType(int tableIndex, int columnIndex, ColumnType columnType) throws RemoteException;



  public Boolean editCell(int tableIndex, int rowIndex, int columnIndex, String value) throws RemoteException;
  public Boolean deleteDuplicateRows(int tableIndex) throws RemoteException;
  public void createTestTable() throws RemoteException;
}
