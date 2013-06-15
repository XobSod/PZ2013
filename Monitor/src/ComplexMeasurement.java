
import java.util.ArrayList;
import java.util.LinkedList;


/**
 *
 * @author Sylwia Wnek
 */
class ComplexMeasurement implements Measurement{
    private int time;
    private int number;
    private String operation;
    private String simpleName; 
    private int id;
    private String name;
    private boolean initialized;
    
    private boolean dataCollected = false;
    private int result;
    private LinkedList <Data> dataList = new LinkedList();
    

    ComplexMeasurement(String simpleName){
        this.time = 5;
        this.number = 30;
        this.operation = "mean";
        this.simpleName = simpleName;
        this.id = new SimpleMeasurement("").getID();
        this.name = simpleName+id;       
        this.initialized = false;

        MeasurementContainer.addMeasurement(this); //
    }
    
     ComplexMeasurement(int time, String operation, String simpleName, String name){
        this.time = time;
        this.number = time*6;
        this.operation = operation;
        this.simpleName = simpleName;
        this.id = new SimpleMeasurement("").getID();        
        this.name = name;
        this.initialized = false;
        
        MeasurementContainer.addMeasurement(this); //
    }
    

    public String getSimpleName(){
        return simpleName;
    }
    
    public void setSimpleName(String name){
        this.simpleName = name;
    }
   
    public int getResult() {
        return result;
    }

    public void setResult(int result){
        this.result = result;
    }

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
    
    private void mean(){        
        int sum = 0;
        
        for (int i=0;i<number;i++){
            sum += new Integer(dataList.get(i).getData());
        }
        
        this.result = sum/number;
    }    
    
    private void maksimum(){
        int max;
        
        max = new Integer(dataList.get(0).getData());
        
        for (int i=0;i<number;i++){
            if (max<new Integer(dataList.get(i).getData())){max = new Integer(dataList.get(i).getData());}
        }
        
        result = max;
    }
      
    private void minimum(){
        int min;
        
        min = new Integer(dataList.get(0).getData());
        
        for (int i=0;i<number;i++){
            if (min<new Integer(dataList.get(i).getData())){min = new Integer(dataList.get(i).getData());}
        }
        
        result = min;
    }

    
    @Override
    public void addData(long timestamp, String data){
        if (dataList.size()<number){
            dataList.add(new Data(timestamp,data));
        }
        else {
            dataCollected = true;
            dataList.poll();
            dataList.add(new Data(timestamp,data));
        }
    }    
        
    @Override
    public int getID(){
        return id;
    }
    
    @Override
    public ArrayList<Data> getData() {
        return new ArrayList<>(dataList);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public void setInitialized(boolean b) {
        this.initialized = b;
    }
}