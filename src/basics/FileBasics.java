package basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class FileBasics {
    public static void main(String[] args) {
        DataImport di = new DataImport("inputs.txt");
//        di.printFile();
        DataExport de = new DataExport("results.txt");
        String line;
        String[] params;
        double a, b;
        while (di.hasNext()){
            line = di.readLine();
            System.out.println(line);
            //"8,5,A"
            params = line.split(",");
            a = Double.parseDouble(params[0]);
//            a = (int)params[0];
            b = Double.parseDouble(params[1]);
            switch (params[2]){
                case "A":
                    de.writeLine(String.valueOf(a+b)); break;
                case "S":
                    de.writeLine(String.valueOf(a-b)); break;
                case "M":
                    de.writeLine(String.valueOf(a*b)); break;
                case "D":
                    de.writeLine(String.valueOf(a/b)); break;
            }
        }
        di.finishImport();
        de.finishExport();
    }
}
