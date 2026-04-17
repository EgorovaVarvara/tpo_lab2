package org.example.csvUtil;

import org.example.function.AbstractFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static java.lang.String.format;

public class CSVWriter {
    private static final String DEFAULT_DIR =
            System.getProperty("user.dir") + File.separator + "test" + File.separator;
    private final BufferedWriter writer;
    private final AbstractFunction fun;
    private final String filename;
    private final String outputDir;

    public CSVWriter(AbstractFunction fun) throws IOException {
        this(fun, DEFAULT_DIR);
    }

    public CSVWriter(AbstractFunction fun, String outputDir) throws IOException {
        this.fun = fun;
        this.outputDir = outputDir;
        this.filename = getFilePath(fun);
        this.writer = createWriter();
    }

    private BufferedWriter createWriter() throws IOException {
        File file = new File(this.filename);
        file.getParentFile().mkdirs();
        if (file.exists()){
            return new BufferedWriter(new FileWriter(file, false));
        }else{
            return new BufferedWriter(new FileWriter(file));
        }
    }

    private String getFilePath(AbstractFunction fun){
        return outputDir + fun.getClass().getSimpleName() + ".csv";
    }

    public void write(Double x1, Double x2, Double step, Double eps) throws IOException{
        try{
            writer.write("x;y");
            writer.newLine();
            for (Double i = x1; i <= x2; i += step){
                try{
                    Double y = fun.calculate(i, eps);
                    if (y != null){
                        writer.write(String.format(java.util.Locale.US, "%f;%f%n", i, y));
                    }else{
                        writer.newLine();
                    }
                } catch (ArithmeticException e){
                    writer.newLine();
                }
            }
        }finally {
            writer.flush();
        }
    }
}
