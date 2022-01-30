package Jaroslav.Zuban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Sort {
     List getList();
     void setList(List list);
     void sortPlay();
     public void sortWatch(List temp,int i) throws IOException;
}
