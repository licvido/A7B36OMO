package homework;
 
import java.util.ArrayList;
import java.util.List;
 
interface CellListener {
    void cellContentsChanged(Cell source, int oldValue, int newValue);
}
 
class Cell {
    int contents;
    List<CellListener> cls = new ArrayList<CellListener>();
 
    Cell(int c) {
        contents = c;
    }
 
    void set(int c) {
        int oc = contents;
        if(contents == c) return;
            
        contents = c;   
        for(CellListener cl : new ArrayList<CellListener>(cls)){
            cl.cellContentsChanged(this, oc, contents);
        }
    }
 
    int get() {
        return contents;
    }
 
    void addCellListener(CellListener l) {
        cls.add(l);
    }
 
    void removeCellListener(CellListener l) {
        cls.remove(l);
    }
}
 
public class Homework9Main {
    public static void main(String[] args) {
        final Cell c1 = new Cell(10);
        final Cell c2 = new Cell(20);
        c1.addCellListener(new CellListener() {
            public void cellContentsChanged(Cell source, int oldValue, int newValue) {
                c2.set(newValue + 10);
            }
        });
        c2.addCellListener(new CellListener() {
            public void cellContentsChanged(Cell source, int oldValue, int newValue) {
                c1.set(newValue - 10);
            }
        });
 
        c1.set(15);
    }
}