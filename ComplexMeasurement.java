package zespolowe;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;


/**
 *
 * @author Sylwia Wnek
 */
public class ComplexMeasurement implements Measurement{
    ComplexMeasurement(String simpleName){
        this.time = 5;
        this.number = 30;
        this.operation = "mean";
        this.simpleName = simpleName;
        this.type = "complex";
    }
    
    /**
     * 
     * @param time przedzial czasu, dla ktorego wykonywane sa obliczenia
     * @param operation nazwa wykonywanych obliczen
     */
     ComplexMeasurement(int time,String operation, String simpleName){
        this.time = time;
        this.number = time*6;
        this.operation = operation;
        this.simpleName = simpleName;
    }
    
    int number;
    int time;
    String operation;
    String name; // potrzebne ?
    String simpleName; //pomiar prosty, z ktorego pochodzi
    String type;
    boolean isComplex = true;
    int id;
    LinkedList <String> data = new LinkedList();
    
    
    boolean dataCollected = false;
    /**
     * Wynik pomiaru.
     */
    protected int result = -1;
    /**
     *
     */
    protected String operationTime;
    int delay = 1000;
    
    public String getSimpleName(){
        return simpleName;
    }
    
    public void setSimpleName(String name){
        this.simpleName = name;
    }
   
    /**
     * Zwraca wynik pomiaru.
     * @return
     */
    public int getResult() {
        return result;
    }

    /**
     *
     * @return
     */
    public String getOperationTime() {       
        return operationTime;
    }
    
    public int getID(){
        return id;
    }
    
    /**
     * Zbiera dane.
     */
    public void collectData(String insertData){
        Random rand = new Random();
        if (data.size()<number){
            data.add(insertData);
        }
        else {
            dataCollected = true;
            data.poll();
            data.add(insertData);
        }
    }
    
    /**
     * Liczy srednia.
     */
    public void mean(){
        
        int i;
        int sum=0;
        
        for (i=0;i<number;i++){
            sum += new Integer(data.get(i));
        }
        
        this.result = sum/number;
        
    }

    /**
     * Wywoluje odpowiednia operacje na podstawie pola operation.
     */
    public void doOperation(){
        if (dataCollected){
            switch(operation){
                case("mean") : this.mean();
                case("maksimum") : this.maksimum(); 
                case("minimum") : this.minimum(); 
                default : this.mean();    
            }
        }
    }
    
    /**
     * Znajduje maksymalna wartosc z zadanej ilosci pomiarow.
     */
    public void maksimum(){
        
        int i;
        int max;
        
        max = new Integer(data.get(0));
        
        for (i=0;i<number;i++){
            if (max<new Integer(data.get(i))){max = new Integer(data.get(i));}
        }
        
        result = max;
    }
    
    /**
     * Znajduje minimalna wartosc z zadanej ilosci pomiarow.
     */    
    public void minimum(){
        
        int i;
        int min;
        
        min = new Integer(data.get(0));
        
        for (i=0;i<number;i++){
            if (min<new Integer(data.get(i))){min = new Integer(data.get(i));}
        }
        
        this.result = min;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ComplexMeasurement cm = new ComplexMeasurement(5,"mean","cpu");
//        cm.run();
    }


    @Override
    public void addData(long timestamp, String data) {
        
    }

    @Override
    public ArrayList<Data> getData() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    @Override
    public void setInitialized(boolean b) {
        
    }
}
