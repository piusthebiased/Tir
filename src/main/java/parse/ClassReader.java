package parse;

import org.apache.commons.codec.binary.StringUtils;
import parse.components.ClassF;
import parse.components.Function;
import parse.components.Parameter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ClassReader {
    public static ClassF parse(String fileName) throws IOException {
        Path f = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        BufferedReader br = Files.newBufferedReader(f, charset);
        ClassF c = new ClassF();

        String line;
        String funct = "";
        boolean ft = false;
        boolean cn = false;
        int counter = 0;
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if(ft) funct += line;
            if(!cn) {
                for(int i = 0; i < st.countTokens(); i++) {
                    if(st.nextToken().equals("class")) {
                        c.setClassName(st.nextToken());
                        cn = true;
                    }
                }
            } else {
                if(line.contains("}")){
                    counter--;
                    if(counter == 0){
                        ft = false;
                        ArrayList<Function> alf = c.getFunctions();
                        Function temp = alf.get(alf.size() - 1);
                        funct = funct.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\\s+", " ");
                        temp.setComment(funct);
                        alf.remove(alf.size() - 1);
                        alf.add(temp);
                        c.setFunctions(alf);
                        funct = "";
                    }
                }
                if(line.contains("{")){
                    if(counter == 0){
                        ft = true;
                        funct += line;

                        Function func = new Function();
                        StringBuilder buffer = new StringBuilder();
                        String token = "";
                        while((token = st.nextToken()).split("\\x28").length < 2) {
                            buffer.append(token+ " ");
                        }
                        func.setFunctionModifiers(buffer.toString());
                        func.setFunctionName(token.split("\\x28")[0]);
                        String[] params = line.split("\\x28")[1].split("\\x29")[0].split(",");
                        for(String p: params){
                            p = p.trim();
                            String[] pr = p.split(" ");
                            func.addParameter(new Parameter(pr[0], pr[1]));
                        }

                        c.addFunction(func);
                    }
                    counter++;
                }
            }
        }

        return c;
    }
}
